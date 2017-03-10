package control;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.Plat;
import dao.PlatDAO;

@Controller
public class PlatControle {
	@RequestMapping(value="/lesplats",method=RequestMethod.GET)
	public @ResponseBody List<Plat> listerPlats(){
		return PlatDAO.getListePlat();
	}
}
