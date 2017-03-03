package control;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.Adresse;
import bean.Categorie;
import bean.Commande;
import bean.Ingredient;
import bean.Mode;
import bean.Supplement;
import bean.Paiement;
import bean.Plat;
import bean.Utilisateur;
import dao.AdresseDAO;
import dao.CategorieDAO;
import dao.CommandeDAO;
import dao.IngredientDAO;
import dao.ModeDAO;
import dao.SupplementDAO;
import dao.PaiementDAO;
import dao.PlatDAO;
import dao.UtilisateurDAO;


@Controller
public class TestControle {
	
	// OK
	@RequestMapping(value="/testingAdr", method=RequestMethod.GET)
	public @ResponseBody List<Adresse> testingAdr() {
		return AdresseDAO.getLesAdresses();
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
	@RequestMapping(value="/testingSupp", method=RequestMethod.GET)
	public @ResponseBody List<Supplement> testingOpt() {
		return SupplementDAO.getListeSupplement();
	}
	
	// OK
	@RequestMapping(value="/testingPaie", method=RequestMethod.GET)
	public @ResponseBody List<Paiement> testingPaie() {
		return PaiementDAO.getListePaiement();
	}
	
	// OKL
	@RequestMapping(value="/testingPlat", method=RequestMethod.GET)
	public @ResponseBody List<Plat> testingPlat() {
		return PlatDAO.getListePlat();
	}

	@RequestMapping(value="/testingUtil", method=RequestMethod.GET)
	public @ResponseBody List<Utilisateur> testingUtil() {
		return UtilisateurDAO.getListeUtilisateur();
	}
}
