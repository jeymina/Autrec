package control;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.Adresse;
import bean.Commande;
import bean.Utilisateur;
import dao.AdresseDAO;

@Controller
public class AdresseControle {
	
	@RequestMapping(value="/lesadresses",method=RequestMethod.GET)
	public @ResponseBody List<Adresse> listerAdresses(){
		return AdresseDAO.getListeAdresse();
	}
	
	@RequestMapping(value="/adressebyid",method=RequestMethod.GET)
	@ResponseBody
	public Adresse getAdresseById(@RequestParam("id") int id){
		return AdresseDAO.getAdresseById(id);
	}
	
	@RequestMapping(value="/adressecreate",method=RequestMethod.GET)
	@ResponseBody
	public void createAdresse(@RequestParam("voirie") String voirie, 
			@RequestParam("cp") String cp,
			@RequestParam("ville") String ville) {
		Adresse uneAdresse = new Adresse();
		uneAdresse.setVoirie(voirie);
		uneAdresse.setCp(cp);
		uneAdresse.setVille(ville);
		AdresseDAO.createAdresse(uneAdresse);
	}
	
	@RequestMapping(value="/adresseupdate",method=RequestMethod.GET)
	@ResponseBody
	public void updateAdresse(@RequestParam("id") int id, 
			@RequestParam("voirie") String voirie, 
			@RequestParam("cp") String cp,
			@RequestParam("ville") String ville,
			@RequestParam("utilisateurs") Collection<Utilisateur> utilisateurs,
			@RequestParam("commandes") Collection<Commande> commandes) {
		Adresse uneAdresse = new Adresse();
		uneAdresse.setId(id);
		uneAdresse.setVoirie(voirie);
		uneAdresse.setCp(cp);
		uneAdresse.setVille(ville);
		uneAdresse.setListUtilisateur(utilisateurs);
		uneAdresse.setListCommande(commandes);
		AdresseDAO.updateAdresse(uneAdresse);
	}
	
	@RequestMapping(value="/adressedelete",method=RequestMethod.GET)
	@ResponseBody
	public void deleteAdresse(@RequestParam("id") int id){
		AdresseDAO.deleteAdresse(id);
	}

}
