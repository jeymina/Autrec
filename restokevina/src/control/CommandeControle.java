package control;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.Com_Plat;
import bean.Commande;
import bean.Plat;
import dao.CommandeDAO;
import dao.PlatDAO;
import dao.UtilisateurDAO;
import dto.IdRequest;
import dto.PanierRequest;
import dto.ResponseBean;

@Controller
public class CommandeControle {
	
	@RequestMapping(value="/lescommandes",method=RequestMethod.GET)
	public @ResponseBody ResponseBean listerCommandes() {
		ResponseBean response = new ResponseBean();
		response.getResponse().put(ResponseBean.RETOUR, ResponseBean.SUCCESS);
		response.getResponse().put("listeCmd", CommandeDAO.getListeCommande());
		return response;
	}
	
	@RequestMapping(value="/commandebyid",method=RequestMethod.GET)
	public @ResponseBody ResponseBean getCommandeById(@RequestParam("id") int id) {
		ResponseBean response = new ResponseBean();
		response.getResponse().put(ResponseBean.RETOUR, ResponseBean.SUCCESS);
		response.getResponse().put("commande", CommandeDAO.getCommandeById(id));
		return response;
	}
		
	@RequestMapping(value="/commandedelete",method=RequestMethod.POST)
	public  @ResponseBody ResponseBean deleteCommandes(@RequestBody @Valid IdRequest request, BindingResult bres) {
		ResponseBean response = new ResponseBean();
		try{			
			CommandeDAO.deleteCommande(Integer.parseInt(request.getId()));
		}catch (NumberFormatException e) {
			response.getResponse().put(ResponseBean.RETOUR, ResponseBean.FAILED);
			response.getResponse().put("message","Entier attendu pour le paramètre 'id'");
			return response;
		}
		response.getResponse().put(ResponseBean.RETOUR, ResponseBean.SUCCESS);
		return response;
	}

	@RequestMapping(value="/ajoutepanier",method=RequestMethod.POST)
	public  @ResponseBody ResponseBean ajoutePanier(@RequestBody @Valid PanierRequest request, BindingResult bres) {
		ResponseBean response = new ResponseBean();		
		int userId, platId, qte;
		try{
			userId = Integer.parseInt(request.getUserId());			
		}catch ( NumberFormatException e) {
			response.getResponse().put(ResponseBean.RETOUR, ResponseBean.FAILED);
			response.getResponse().put("message","Entier attendu pour le paramètre 'userId'");
			return response;
		}
		try{
			platId = Integer.parseInt(request.getPlatId());			
		}catch ( NumberFormatException e) {
			response.getResponse().put(ResponseBean.RETOUR, ResponseBean.FAILED);
			response.getResponse().put("message","Entier attendu pour le paramètre 'platId'");
			return response;
		}
		try{
			qte = Integer.parseInt(request.getQte());			
		}catch ( NumberFormatException e) {
			response.getResponse().put(ResponseBean.RETOUR, ResponseBean.FAILED);
			response.getResponse().put("message","Entier attendu pour le paramètre 'qte'");
			return response;
		}
		
		List<Commande> l_commandeEnCour = CommandeDAO.getCommandeEnCour(userId);
		if (l_commandeEnCour.size() == 0){
			Commande cmd = new Commande();
			cmd.setCommandeUtil(UtilisateurDAO.getUtilisateurbyId(userId));
			CommandeDAO.createCommande(cmd);
		}
		l_commandeEnCour = CommandeDAO.getCommandeEnCour(userId);
		if (l_commandeEnCour.size() == 0){
			response.getResponse().put(ResponseBean.RETOUR, ResponseBean.FAILED);
			response.getResponse().put("message","Echec lors de la création d'une commande");
			return response;
		}
		Commande cmd = l_commandeEnCour.get(0);
		
		boolean existing_complat = false;
		
		Collection<Com_Plat> l_complat = cmd.getListComPlat();
		for (Com_Plat com_Plat : l_complat) {
			if (com_Plat.getComplatPlat().getId() == platId){
				// Une commande avec ce plat existe. On augmente la quantite
				CommandeDAO.ajouteUneQte(com_Plat, qte);
				existing_complat = true;
			}
		}
		
		if (!existing_complat){
			Com_Plat complat = new Com_Plat();
			complat.setComplatCom(cmd);
			complat.setComplatPlat(PlatDAO.getPlatById(platId));
			complat.setQuantite(qte);
			CommandeDAO.createComPlat(complat);
		}	

		response.getResponse().put(ResponseBean.RETOUR, ResponseBean.SUCCESS);
		response.getResponse().put("idCmd", cmd.getId());
		response.getResponse().put("prix", computePrice(cmd));
		return response;
	}

	public static float computePrice(Commande cmd) {
		float somme = 0;
		Collection<Com_Plat> l_complat = cmd.getListComPlat();
		for (Com_Plat com_Plat : l_complat) {
			Plat p = com_Plat.getComplatPlat();
			somme += PlatControle.computePrice(p) * com_Plat.getQuantite();
		}
		return somme;
	}
}
