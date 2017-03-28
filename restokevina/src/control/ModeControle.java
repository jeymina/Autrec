package control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.ModeDAO;
import dto.ResponseBean;

@Controller
public class ModeControle {
	@RequestMapping(value="/lesmodes",method=RequestMethod.GET)
	public @ResponseBody ResponseBean listerModes(){
		ResponseBean response = new ResponseBean();
		response.getResponse().put(ResponseBean.RETOUR, ResponseBean.SUCCESS);
		response.getResponse().put("listeMode", ModeDAO.getListeMode());
		return response;
	}
}
