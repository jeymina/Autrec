package control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.PaiementDAO;
import dto.ResponseBean;

@Controller
public class PaiementControle {
	@RequestMapping(value="/lespaiements",method=RequestMethod.GET)
	public @ResponseBody ResponseBean listerPaiements(){
		ResponseBean response = new ResponseBean();
		response.getResponse().put(ResponseBean.RETOUR, ResponseBean.SUCCESS);
		response.getResponse().put("listePaie", PaiementDAO.getListePaiement());
		return response;
	}
}
