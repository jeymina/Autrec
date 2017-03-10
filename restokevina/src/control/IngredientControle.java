package control;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.Ingredient;
import dao.IngredientDAO;

@Controller
public class IngredientControle {
	@RequestMapping(value="/lesingredients",method=RequestMethod.GET)
	public @ResponseBody List<Ingredient> listerIngredients(){
		return IngredientDAO.getListeIngredient();
	}
}
