package control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.Adresse;
import dao.AdresseDAO;

@Controller
public class AdresseControle {

	@RequestMapping(value="/lesadresses", method=RequestMethod.GET)
	public @ResponseBody Adresse listerAdresses() {
		return AdresseDAO.getAdresse(1);
	}

}
