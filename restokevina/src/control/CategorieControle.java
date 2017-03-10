package control;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.Categorie;
import bean.Plat;
import dao.CategorieDAO;

@Controller
public class CategorieControle {
	
	@RequestMapping(value="/lescategories",method=RequestMethod.GET)
	public @ResponseBody List<Categorie> listerCategories() {
		return CategorieDAO.getListeCategorie();
	}
	
	@RequestMapping(value="/categoriebyid",method=RequestMethod.GET)
	@ResponseBody
	public Categorie getCategorieById(@RequestParam("id") int id){
		return CategorieDAO.getCategorieById(id);
	}
	
	@RequestMapping(value="/categoriecreate",method=RequestMethod.GET)
	@ResponseBody
	public void createCategorie(@RequestParam("nom") String nom) {
		Categorie uneCategorie = new Categorie();
		uneCategorie.setNom(nom);
		CategorieDAO.createCategorie(uneCategorie);
	}
	
	@RequestMapping(value="/categorieupdate",method=RequestMethod.GET)
	@ResponseBody
	public void updateCategorie(@RequestParam("id") int id, 
			@RequestParam("nom") String nom,
			@RequestParam("plats") Collection<Plat> plats) {
		Categorie uneCategorie = new Categorie();
		uneCategorie.setId(id);
		uneCategorie.setNom(nom);
		uneCategorie.setListPlat(plats);
		CategorieDAO.updateCategorie(uneCategorie);
	}
	
	@RequestMapping(value="/categoriedelete",method=RequestMethod.GET)
	@ResponseBody
	public void deleteCategorie(@RequestParam("id") int id) {
		CategorieDAO.deleteCategorie(id);
	}
	
	
	
}
