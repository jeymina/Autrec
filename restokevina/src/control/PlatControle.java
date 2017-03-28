package control;

import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.Ing_Plat;
import bean.Plat;
import dao.PlatDAO;
import dto.ResponseBean;

@Controller
public class PlatControle {
	@RequestMapping(value="/lesplats",method=RequestMethod.GET)
	public @ResponseBody ResponseBean listerPlats(){
		ResponseBean response = new ResponseBean();
		response.getResponse().put(ResponseBean.RETOUR, ResponseBean.SUCCESS);
		response.getResponse().put("listePlat", PlatDAO.getListePlat());
		return response;
	}

	public static float computePrice(Plat p) {
		float somme = 0;
		Collection<Ing_Plat> ing = p.getListIngPlat();
		for (Ing_Plat ing_Plat : ing) {
			somme += ing_Plat.getMontant();
		}
		return somme;
	}
}
