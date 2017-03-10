package control;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.Adresse;
import bean.Com_Plat;
import bean.Commande;
import bean.Paiement;
import bean.Utilisateur;
import dao.CommandeDAO;

@Controller
public class CommandeControle {
	
	@RequestMapping(value="/lescommandes",method=RequestMethod.GET)
	public @ResponseBody List<Commande> listerCommandes() {
		return CommandeDAO.getListeCommande();
	}
	
	@RequestMapping(value="/commandebyid",method=RequestMethod.GET)
	@ResponseBody
	public Commande getCommandeById(@RequestParam("id") int id) {
		return CommandeDAO.getCommandeById(id); 
	}
	
	@RequestMapping(value="/commandecreate",method=RequestMethod.GET)
	@ResponseBody
	public void createCommande(@RequestParam("validation") Timestamp validation,
			@RequestParam("utilisateur") Utilisateur utilisateur, 
			@RequestParam("adresse") Adresse adresse, 
			@RequestParam("plats") Collection<Com_Plat> plats) {
		Commande uneCommande = new Commande();
		uneCommande.setDateValidation(validation);
		uneCommande.setCommandeUtil(utilisateur);
		uneCommande.setCommandeAdr(adresse);
		uneCommande.setListComPlat(plats);
		CommandeDAO.createCommande(uneCommande);
	}
	
	@RequestMapping(value="/commandeupdate",method=RequestMethod.GET)
	@ResponseBody
	public void updateCommandes(@RequestParam("id") int id, 
			@RequestParam("validation") Timestamp validation,
			@RequestParam("livraison") Timestamp livraison, 
			@RequestParam("utilisateur") Utilisateur utilisateur, 
			@RequestParam("adresse") Adresse adresse, 
			@RequestParam("paiements") Collection<Paiement> paiements, 
			@RequestParam("plats") Collection<Com_Plat> plats) {
		Commande uneCommande = new Commande();
		uneCommande.setId(id);
		uneCommande.setDateValidation(validation);
		uneCommande.setDateLivraison(livraison);
		uneCommande.setCommandeUtil(utilisateur);
		uneCommande.setCommandeAdr(adresse);
		uneCommande.setListPaiement(paiements);
		uneCommande.setListComPlat(plats);
		CommandeDAO.updateCommande(uneCommande);
	}
	
	@RequestMapping(value="/commandedelete",method=RequestMethod.GET)
	@ResponseBody
	public void deleteCommandes(@RequestParam("id") int id) {
		CommandeDAO.deleteCommande(id);
	}
	
}
