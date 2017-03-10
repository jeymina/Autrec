package control;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.Commande;
import dao.CommandeDAO;

@Controller
public class CommandeControle {
	@RequestMapping(value="/lescommandes",method=RequestMethod.GET)
	public @ResponseBody List<Commande> listerCommandes(){
		return CommandeDAO.getListeCommande();
	}
}
