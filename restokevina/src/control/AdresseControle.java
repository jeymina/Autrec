package control;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.AdresseDAO;
import dto.IdRequest;
import dto.ResponseBean;

@Controller
public class AdresseControle {
	
	@RequestMapping(value="/lesadresses",method=RequestMethod.GET)
	public @ResponseBody ResponseBean listerAdresses(){
		ResponseBean response = new ResponseBean();
		response.getResponse().put(ResponseBean.RETOUR, ResponseBean.SUCCESS);
		response.getResponse().put("listeAdr", AdresseDAO.getListeAdresse());
		return response;
	}
	
	@RequestMapping(value="/adressebyid",method=RequestMethod.GET)
	public @ResponseBody ResponseBean getAdresseById(@RequestParam("id") int id){
		ResponseBean response = new ResponseBean();
		response.getResponse().put(ResponseBean.RETOUR, ResponseBean.SUCCESS);
		response.getResponse().put("adresse", AdresseDAO.getAdresseById(id));
		return response;
	}	
	
	@RequestMapping(value="/adressedelete",method=RequestMethod.POST)
	public @ResponseBody ResponseBean deleteAdresse(@RequestBody @Valid IdRequest request, BindingResult bres){
		ResponseBean response = new ResponseBean();
		try{			
			AdresseDAO.deleteAdresse(Integer.parseInt(request.getId()));
		}catch (NumberFormatException e) {
			response.getResponse().put(ResponseBean.RETOUR, ResponseBean.FAILED);
			response.getResponse().put("message","Entier attendu pour le paramètre 'id'");
			return response;
		}
		response.getResponse().put(ResponseBean.RETOUR, ResponseBean.SUCCESS);
		return response;
	}

}
