package control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
