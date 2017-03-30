package control;

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

	@RequestMapping(value="/getpanier",method=RequestMethod.GET)
	public  @ResponseBody ResponseBean getpanier(@RequestParam("id") int id) {
		ResponseBean response = new ResponseBean();
		
		List<Commande> list_cmd = CommandeDAO.getCommandeEnCour(id);
		if(list_cmd == null || list_cmd.isEmpty()){
			response.getResponse().put(ResponseBean.RETOUR, ResponseBean.FAILED);
			response.getResponse().put("message", "Aucune commande active");
			return response;
		}
		if(list_cmd.size() > 1){
			response.getResponse().put(ResponseBean.RETOUR, ResponseBean.FAILED);
			response.getResponse().put("message", "Plus d'une commande active");
			return response;
		}
		
		Commande cmd = list_cmd.get(0);
		if (cmd == null){
			response.getResponse().put(ResponseBean.RETOUR, ResponseBean.FAILED);
			response.getResponse().put("message", "Commande mal initialisee Null Pointeur");
			return response;
		}
				
		response.getResponse().put(ResponseBean.RETOUR, ResponseBean.SUCCESS);
		response.getResponse().put("commande", cmd);
		return response;
		
	}
	
	@RequestMapping(value="/removefrompanier",method=RequestMethod.POST)
	public  @ResponseBody ResponseBean removefrompanier(@RequestBody @Valid PanierRequest request, BindingResult bres) {
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
		if (l_commandeEnCour == null || l_commandeEnCour.isEmpty()){
			response.getResponse().put(ResponseBean.RETOUR, ResponseBean.FAILED);
			response.getResponse().put("message","Aucune commande en cours trouvée");
			return response;
		}
		if (l_commandeEnCour.size() > 1){
			response.getResponse().put(ResponseBean.RETOUR, ResponseBean.FAILED);
			response.getResponse().put("message","Plus d'une commande en cours trouvée");
			return response;
		}
		Commande cmd = l_commandeEnCour.get(0);
		if (cmd == null){
			response.getResponse().put(ResponseBean.RETOUR, ResponseBean.FAILED);
			response.getResponse().put("message","Commande en cours égale à NULL");
			return response;
		}
		Com_Plat complat = CommandeDAO.getComPlaById(cmd.getId(), platId);
		if (complat == null){
			response.getResponse().put(ResponseBean.RETOUR, ResponseBean.FAILED);
			response.getResponse().put("message","Aucune commande pour ce plat trouvée");
			return response;
		}
		
		int qteActuelle = complat.getQuantite();
		if (qte > qteActuelle) qte = qteActuelle;
		
		CommandeDAO.removeUneQte(complat, qte);
		complat = CommandeDAO.getComPlaById(cmd.getId(), platId);
		if (complat == null){
			response.getResponse().put(ResponseBean.RETOUR, ResponseBean.FAILED);
			response.getResponse().put("message","Aucune commande pour ce plat trouvée (apres modif QTE)");
			return response;
		}
		if (complat.getQuantite() <= 0){
			CommandeDAO.removeComPla(complat);
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

		Com_Plat complat = CommandeDAO.getComPlaById(cmd.getId(), platId);
		if (complat != null){
			CommandeDAO.ajouteUneQte(complat, qte);			
		} else {
			complat = new Com_Plat();
			complat.setComplatCom(cmd);
			complat.setComplatPlat(PlatDAO.getPlatById(platId));
			complat.setQuantite(qte);
			CommandeDAO.createComPlat(complat);
		}	

		response.getResponse().put(ResponseBean.RETOUR, ResponseBean.SUCCESS);
		response.getResponse().put("idCmd", cmd.getId());
		response.getResponse().put("prix", computePrice(cmd.getId()));
		return response;
	}

	public static Float computePrice(int id) {
		float somme = 0;
		Commande cmd = CommandeDAO.getCommandeById(id);
		List<Com_Plat> l_complat = CommandeDAO.getComPlaById(cmd.getId());
		for (Com_Plat com_Plat : l_complat) {
			Plat p = com_Plat.getComplatPlat();
			somme += PlatControle.computePrice(p) * com_Plat.getQuantite();
		}
		return somme;
	}
}
