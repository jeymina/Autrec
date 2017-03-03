package control;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.Utilisateur;
import dao.UtilisateurDAO;

@Controller
public class UtilisateurControle {
	@RequestMapping(value="/lesutilisateurs", method=RequestMethod.GET)
	public @ResponseBody List<Utilisateur> listerUtilisateur() {
		return UtilisateurDAO.getListeUtilisateur();
	}
}
