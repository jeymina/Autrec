package control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.SupplementDAO;
import dto.ResponseBean;

@Controller
public class SupplementControle {
	@RequestMapping(value="/lessupplements",method=RequestMethod.GET)
	public @ResponseBody ResponseBean listerSupplements(){
		ResponseBean response = new ResponseBean();
		response.getResponse().put(ResponseBean.RETOUR, ResponseBean.SUCCESS);
		response.getResponse().put("listeSuppl", SupplementDAO.getListeSupplement());
		return response;
	}
}
