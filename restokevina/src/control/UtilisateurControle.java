package control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.UtilisateurDAO;
import dto.ResponseBean;

@Controller
public class UtilisateurControle {
	@RequestMapping(value="/lesutilisateurs", method=RequestMethod.GET)
	public @ResponseBody ResponseBean listerUtilisateur() {
		ResponseBean response = new ResponseBean();
		response.getResponse().put(ResponseBean.RETOUR, ResponseBean.SUCCESS);
		response.getResponse().put("listeUtil", UtilisateurDAO.getListeUtilisateur());
		return response;
	}
}
