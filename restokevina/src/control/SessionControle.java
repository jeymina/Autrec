package control;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import bean.Adresse;
import bean.Restaurant;
import bean.Session;
import bean.Utilisateur;
import dao.AdresseDAO;
import dao.UtilisateurDAO;
import dto.ConnexionRequest;
import dto.ResponseBean;
import dto.SignInRequest;

@Controller
@SessionAttributes
public class SessionControle {
	
	@RequestMapping(value="/getsession", method = RequestMethod.GET)
	public @ResponseBody ResponseBean test3a(HttpServletRequest httpRequest){
		System.out.println("getSession : "+ httpRequest.getRemoteAddr());
		ResponseBean response = new ResponseBean();
		Session session = Restaurant.getInstance().getSessions(httpRequest.getRemoteAddr());
		response.getResponse().put(ResponseBean.RETOUR, ResponseBean.SUCCESS);
		response.getResponse().put("session", session);
		return response;
	}
	
	@RequestMapping(value="/connexion",method=RequestMethod.POST)
	public @ResponseBody ResponseBean connexion(@RequestBody @Valid ConnexionRequest request, BindingResult bres, HttpServletRequest httpRequest) {
		System.out.println("Testing to connect : mail=" + request.getMail()+ " ; pwd="+request.getPass());
		ResponseBean response = new ResponseBean();
		List<Utilisateur> listU = UtilisateurDAO.connexion(request.getMail(), request.getPass());
		if (listU != null && listU.size() == 1){
			Utilisateur u = listU.get(0);
			Session session = Restaurant.getInstance().getSessions(httpRequest.getRemoteAddr());
			session.setUtilActif(u);

			response.getResponse().put(ResponseBean.RETOUR, ResponseBean.SUCCESS);
			response.getResponse().put("idUtilisateur", ""+u.getId());
			
		} else {
			response.getResponse().put(ResponseBean.RETOUR,ResponseBean.FAILED);
		}
		return response;
	}
	
	@RequestMapping(value="/deconnexion",method=RequestMethod.POST)
	public @ResponseBody ResponseBean deconnexion(HttpServletRequest httpRequest) {
		System.out.println("Testing to deconnect");
		ResponseBean response = new ResponseBean();
		Session session = Restaurant.getInstance().getSessions(httpRequest.getRemoteAddr());
		if (session.getUtilActif() == null){
			response.getResponse().put(ResponseBean.RETOUR, ResponseBean.FAILED);	
		} else {
			session.setUtilActif(null);
			response.getResponse().put(ResponseBean.RETOUR, ResponseBean.SUCCESS);			
		}
		return response;
	}
	
	@RequestMapping(value="/signin",method=RequestMethod.POST)
	public @ResponseBody ResponseBean signin(@RequestBody @Valid SignInRequest request, BindingResult bres, HttpServletRequest httpRequest) {
		System.out.println("Testing to SignIn");
		ResponseBean response = new ResponseBean();
		Utilisateur user = UtilisateurDAO.getUtilisateurbyMail(request.getMail());
		if (user != null){
			response.getResponse().put(ResponseBean.RETOUR, ResponseBean.FAILED);
			response.getResponse().put("message", "Adresse mail déjà existante");
			return response;
		} else {
			Adresse adr = AdresseDAO.getAdresse(request.getVille(), request.getCp(), request.getVoirie());
			if (adr == null) {
				adr = new Adresse();
				adr.setVille(request.getVille());
				adr.setCp(request.getCp());
				adr.setVoirie(request.getVoirie());
				AdresseDAO.createAdresse(adr);
			}
			
			adr = AdresseDAO.getAdresse(request.getVille(), request.getCp(), request.getVoirie());
			if (adr == null) {
				response.getResponse().put(ResponseBean.RETOUR, ResponseBean.FAILED);
				response.getResponse().put("message", "Echec de création d'une adresse");
				return response;
			}
			user = new Utilisateur();
			user.setNom(request.getNom());
			user.setPrenom(request.getPrenom());
			user.setPassword(request.getPass());
			user.setTelephone(request.getTel());
			user.setMail(request.getMail());
			user.setUtilisateurAdr(adr);
			UtilisateurDAO.createUtilisateur(user);
			user = UtilisateurDAO.getUtilisateurbyMail(request.getMail());
			if (user == null){
				response.getResponse().put(ResponseBean.RETOUR, ResponseBean.FAILED);
				response.getResponse().put("message", "Echec de création d'un utilisateur");
				return response;
			}

			Session session = Restaurant.getInstance().getSessions(httpRequest.getRemoteAddr());
			session.setUtilActif(user);
			response.getResponse().put(ResponseBean.RETOUR, ResponseBean.SUCCESS);
			response.getResponse().put("Utilisateur", user);
		}
		return response;
	}
}
