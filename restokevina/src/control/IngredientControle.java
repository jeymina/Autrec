package control;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.IngredientDAO;
import dto.IdRequest;
import dto.ResponseBean;

@Controller
public class IngredientControle {
	
	@RequestMapping(value="/lesingredients",method=RequestMethod.GET)
	public @ResponseBody ResponseBean listerIngredients(){
		ResponseBean response = new ResponseBean();
		response.getResponse().put(ResponseBean.RETOUR, ResponseBean.SUCCESS);
		response.getResponse().put("listeIngr", IngredientDAO.getListeIngredient());
		return response;
	}
	
	@RequestMapping(value="/ingredientbyid",method=RequestMethod.GET)
	public @ResponseBody ResponseBean getIngredientById(@RequestParam("id") int id){
		ResponseBean response = new ResponseBean();
		response.getResponse().put(ResponseBean.RETOUR, ResponseBean.SUCCESS);
		response.getResponse().put("ingredient", IngredientDAO.getIngredientById(id));
		return response;
	}
	
	@RequestMapping(value="/ingredientdelete",method=RequestMethod.POST)
	public @ResponseBody ResponseBean deleteIngredients(@RequestBody @Valid IdRequest request, BindingResult bres){
		ResponseBean response = new ResponseBean();
		try{
			IngredientDAO.deleteIngredient(Integer.parseInt(request.getId()));
		}catch (NumberFormatException e) {
			response.getResponse().put(ResponseBean.RETOUR, ResponseBean.FAILED);
			response.getResponse().put("message","Entier attendu pour le parametre 'id'");
			return response;
		}
		response.getResponse().put(ResponseBean.RETOUR, ResponseBean.SUCCESS);
		return response;
	}
}
