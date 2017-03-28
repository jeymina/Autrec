package control;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.CategorieDAO;
import dto.IdRequest;
import dto.ResponseBean;

@Controller
public class CategorieControle {
	
	@RequestMapping(value="/lescategories",method=RequestMethod.GET)
	public @ResponseBody ResponseBean listerCategories() {
		ResponseBean response = new ResponseBean();
		response.getResponse().put(ResponseBean.RETOUR, ResponseBean.SUCCESS);
		response.getResponse().put("listeCat", CategorieDAO.getListeCategorie());
		return response;
	}
	
	@RequestMapping(value="/categoriebyid",method=RequestMethod.GET)
	public @ResponseBody ResponseBean getCategorieById(@RequestParam("id") int id){
		ResponseBean response = new ResponseBean();
		response.getResponse().put(ResponseBean.RETOUR, ResponseBean.SUCCESS);
		response.getResponse().put("categorie", CategorieDAO.getCategorieById(id));
		return response;
	}
	
	@RequestMapping(value="/categoriedelete",method=RequestMethod.POST)	
	public @ResponseBody ResponseBean deleteCategorie(@RequestBody @Valid IdRequest request, BindingResult bres) {
		ResponseBean response = new ResponseBean();
		try{			
			CategorieDAO.deleteCategorie(Integer.parseInt(request.getId()));
		}catch (NumberFormatException e) {
			response.getResponse().put(ResponseBean.RETOUR, ResponseBean.FAILED);
			response.getResponse().put("message","Entier attendu pour le parametre 'id'");
			return response;
		}
		response.getResponse().put(ResponseBean.RETOUR, ResponseBean.SUCCESS);
		return response;
	}
	
	
	
}
