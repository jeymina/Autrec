package control;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.Adresse;
import bean.Categorie;
import bean.Com_Plat;
import bean.Commande;
import bean.Ingredient;
import bean.Mode;
import bean.Paiement;
import bean.Plat;
import bean.Restaurant;
import bean.Session;
import bean.Utilisateur;
import dao.AdresseDAO;
import dao.CategorieDAO;
import dao.CommandeDAO;
import dao.IngredientDAO;
import dao.ModeDAO;
import dao.TestDAO;
import dao.PaiementDAO;
import dao.PlatDAO;
import dao.UtilisateurDAO;
import dto.ResponseBean;


@Controller
public class TestControle {

	// OK
	@RequestMapping(value="/testingAdr", method=RequestMethod.GET)
	public @ResponseBody List<Adresse> testingAdr() {
		return AdresseDAO.getListeAdresse();
	}

	// OK
	@RequestMapping(value="/testingCat", method=RequestMethod.GET)
	public @ResponseBody List<Categorie> testingCat() {
		return CategorieDAO.getListeCategorie();
	}

	// OK
	@RequestMapping(value="/testingComm", method=RequestMethod.GET)
	public @ResponseBody List<Commande> testingComm() {
		return CommandeDAO.getListeCommande();
	}

	// OK
	@RequestMapping(value="/testingIng", method=RequestMethod.GET)
	public @ResponseBody List<Ingredient> testingIng() {
		return IngredientDAO.getListeIngredient();
	}

	// OK
	@RequestMapping(value="/testingMode", method=RequestMethod.GET)
	public @ResponseBody List<Mode> testingMode() {
		return ModeDAO.getListeMode();
	}

	// OK
	@RequestMapping(value="/testingPaie", method=RequestMethod.GET)
	public @ResponseBody List<Paiement> testingPaie() {
		return PaiementDAO.getListePaiement();
	}

	// OK
	@RequestMapping(value="/testingPlat", method=RequestMethod.GET)
	public @ResponseBody List<Plat> testingPlat() {
		return PlatDAO.getListePlat();
	}

	@RequestMapping(value="/testingUtil", method=RequestMethod.GET)
	public @ResponseBody List<Utilisateur> testingUtil() {
		return UtilisateurDAO.getListeUtilisateur();
	}

	@RequestMapping(value="/testingAdrByAdr", method=RequestMethod.GET)
	public @ResponseBody Adresse testingAdrByAdr(@RequestParam ("ville") String ville, @RequestParam ("cp") String cp, @RequestParam ("rue") String rue) {
		return AdresseDAO.getAdresse(ville, cp, rue);
	}

	@RequestMapping(value="/testinGetUserByVille", method=RequestMethod.GET)
	public @ResponseBody List<Utilisateur> testinGetUserByVille() {
		return TestDAO.getUserByVille("Brest");
	}

	@RequestMapping(value="/testinCreateADR", method=RequestMethod.GET)
	public @ResponseBody void testinCreateADR() {
		TestDAO.createAdr(new Adresse());
	}

	@RequestMapping(value="/testinUpdateADR", method=RequestMethod.GET)
	public @ResponseBody void testinUpdateADR() {
		Adresse adr = AdresseDAO.getAdresseById(7);
		adr.setVoirie("voiriie modified");
		TestDAO.updateADr(adr);
	}	

	@RequestMapping(value="/testinDeleteADR", method=RequestMethod.GET)
	public @ResponseBody void testinDeleteADR() {
		TestDAO.deleteADr(9);
	}

	@RequestMapping(value="/testingPOST",method=RequestMethod.POST)
	public @ResponseBody void testingPOST(
			@RequestBody @Valid Adresse adr, BindingResult bres) {
		TestDAO.testingPOST(adr);
	}
	
	@RequestMapping(value="/testingConnect",method=RequestMethod.GET)
	public @ResponseBody ResponseBean testingConnect() {
		List<Utilisateur> listU = UtilisateurDAO.connexion("hilary.golay@gmail.com", "azerty");
		System.out.println(listU);
		ResponseBean response = new ResponseBean();

		response.getResponse().put("retour", "success");
		response.getResponse().put("IdUtilisateur", ""+listU.get(0).getId());
		return response;
	}
	
	@RequestMapping(value="/adminGetSessions", method=RequestMethod.GET)
	public @ResponseBody Map<String, Session> adminGetSessions() {
		return Restaurant.getInstance().getSessions();
	}
	
	@RequestMapping(value="/testPanier", method=RequestMethod.GET)
	public @ResponseBody ResponseBean testPanier() {
		return null;
		
	}
	
	
}
