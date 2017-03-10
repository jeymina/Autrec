package control;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.Categorie;
import dao.CategorieDAO;

@Controller
public class CategorieControle {
	@RequestMapping(value="/lescategories",method=RequestMethod.GET)
	public @ResponseBody List<Categorie> listerCategories(){
		return CategorieDAO.getListeCategorie();
	}
}
