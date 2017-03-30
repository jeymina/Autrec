package control;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.Ing_Plat;
import bean.Plat;
import dao.PlatDAO;
import dto.IdRequest;
import dto.ResponseBean;

@Controller
public class PlatControle {
	
	@RequestMapping(value="/lesplatstrie",method=RequestMethod.GET)
	public @ResponseBody ResponseBean lesplatstrie(){
		System.out.println("getLesplatstriees");
		ResponseBean response = new ResponseBean();
		List<Plat> listPlat = PlatDAO.getListePlat();
		List<Plat> listEntree = new ArrayList<Plat>();
		List<Plat> listPlatPrinc = new ArrayList<Plat>();
		List<Plat> listDessert = new ArrayList<Plat>();
		for (Plat plat : listPlat) {
			if (plat.getPlatCat().getId() == 1){
				listEntree.add(plat);
			} else if (plat.getPlatCat().getId() == 4 ){
				listDessert.add(plat);
			} else {
				listPlatPrinc.add(plat);
			}
		}
		response.getResponse().put(ResponseBean.RETOUR, ResponseBean.SUCCESS);
		response.getResponse().put("listeEntree", listEntree);
		response.getResponse().put("listePlatPrinc", listPlatPrinc);
		response.getResponse().put("listeDessert", listDessert);
		return response;
	}
	
	@RequestMapping(value="/leprix",method=RequestMethod.GET)
	public @ResponseBody ResponseBean leprix(@RequestBody @Valid IdRequest request, BindingResult bres){
		System.out.println("getLePrixPlat id="+request.getId());
		ResponseBean response = new ResponseBean();
		int platId;
		try{			
			platId = Integer.parseInt(request.getId());
		}catch (NumberFormatException e) {
			response.getResponse().put(ResponseBean.RETOUR, ResponseBean.FAILED);
			response.getResponse().put("message","Entier attendu pour le paramètre 'id'");
			return response;
		}
		response.getResponse().put(ResponseBean.RETOUR, ResponseBean.SUCCESS);
		response.getResponse().put("listeDessert", computePrice(PlatDAO.getPlatById(platId)));
		return response;
	}
	
	public static Float computePrice(Plat p) {
		float somme = 0;
		Collection<Ing_Plat> ing = p.getListIngPlat();
		for (Ing_Plat ing_Plat : ing) {
			somme += ing_Plat.getMontant();
		}
		return somme;
	}
}
