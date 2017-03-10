package control;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.Supplement;
import dao.SupplementDAO;

@Controller
public class SupplementControle {
	@RequestMapping(value="/lessupplements",method=RequestMethod.GET)
	public @ResponseBody List<Supplement> listerSupplements(){
		return SupplementDAO.getListeSupplement();
	}
}
