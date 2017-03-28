package control;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.CommandeDAO;
import dto.IdRequest;
import dto.ResponseBean;

@Controller
public class CommandeControle {
	
	@RequestMapping(value="/lescommandes",method=RequestMethod.GET)
	public @ResponseBody ResponseBean listerCommandes() {
		ResponseBean response = new ResponseBean();
		response.getResponse().put(ResponseBean.RETOUR, ResponseBean.SUCCESS);
		response.getResponse().put("listeCmd", CommandeDAO.getListeCommande());
		return response;
	}
	
	@RequestMapping(value="/commandebyid",method=RequestMethod.GET)
	public @ResponseBody ResponseBean getCommandeById(@RequestParam("id") int id) {
		ResponseBean response = new ResponseBean();
		response.getResponse().put(ResponseBean.RETOUR, ResponseBean.SUCCESS);
		response.getResponse().put("commande", CommandeDAO.getCommandeById(id));
		return response;
	}
		
	@RequestMapping(value="/commandedelete",method=RequestMethod.POST)
	public  @ResponseBody ResponseBean deleteCommandes(@RequestBody @Valid IdRequest request, BindingResult bres) {
		ResponseBean response = new ResponseBean();
		try{			
			CommandeDAO.deleteCommande(Integer.parseInt(request.getId()));
		}catch (NumberFormatException e) {
			response.getResponse().put(ResponseBean.RETOUR, ResponseBean.FAILED);
			response.getResponse().put("message","Entier attendu pour le parametre 'id'");
			return response;
		}
		response.getResponse().put(ResponseBean.RETOUR, ResponseBean.SUCCESS);
		return response;
	}
	
}
