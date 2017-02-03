package client.controle;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.Converter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import serveur.bean.Adresse;
import serveur.dao.AdresseDAO;

@Controller
public class AdresseControle {
	
	@Resource
	AdresseDAO dao;
	
	@RequestMapping(value="/lesadresses", method=RequestMethod.GET)
	public @ResponseBody List<Adresse> listerAdresses() {
		return dao.getLesAdresses();
	}

}
