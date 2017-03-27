package control;


import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import bean.Session;
import bean.Utilisateur;
import dao.UtilisateurDAO;
import dto.ConnexionRequest;
import dto.ResponseBean;

@Controller
@SessionAttributes
public class SessionControle {
	
	@RequestMapping(value="/getSession", method = RequestMethod.GET)
	public @ResponseBody Session test3a(){
		System.out.println("getSession");
		Session res = Session.getInstance();
		return res;
	}
	
	@RequestMapping(value="/connexion",method=RequestMethod.POST)
	public @ResponseBody ResponseBean connexion(@RequestBody @Valid ConnexionRequest request, BindingResult bres) {
		System.out.println("Testing to connect : mail=" + request.getId()+ " ; pwd="+request.getPass());
		ResponseBean response = new ResponseBean();
		List<Utilisateur> listU = UtilisateurDAO.connexion(request.getId(), request.getPass());
		if (listU != null && listU.size() == 1){
			Utilisateur u = listU.get(0);
			Session.getInstance().setUtilActif(u);

			response.getResponse().put("retour", "success");
			response.getResponse().put("IdUtilisateur", ""+u.getId());
			
		} else {
			response.getResponse().put("retour","failed");
		}
		return response;
	}
	
	@RequestMapping(value="/deconnexion",method=RequestMethod.POST)
	public @ResponseBody ResponseBean deconnexion() {
		System.out.println("Testing to deconnect");
		Session.getInstance().setUtilActif(null);
		ResponseBean response = new ResponseBean();
		response.getResponse().put("retour", "success");
		return response;
	}
	
}
