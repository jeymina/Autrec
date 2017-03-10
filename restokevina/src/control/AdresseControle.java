package control;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.Adresse;
import bean.Commande;
import dao.AdresseDAO;

@Controller
public class AdresseControle {
	
	@RequestMapping(value="/lesadresses",method=RequestMethod.GET)
	public @ResponseBody List<Adresse> listerAdresses(){
		return AdresseDAO.getListeAdresse();
	}
	
	@RequestMapping(value="/adressebyid",method=RequestMethod.GET)
	@ResponseBody
	public Adresse adresseById(@RequestParam("id") int id){
		return AdresseDAO.getAdresseById(id);
	}
	
	@RequestMapping(value="/createadr",method=RequestMethod.GET)
	public @ResponseBody void createadr(){
		Adresse adr = new Adresse();
		adr.setCp("22222");
		adr.setListCommande(new ArrayList<Commande>());
		adr.setVille("aaaaaa");
		adr.setVoirie("voiriiiiie");
		AdresseDAO.createAdresse(adr);
	}
}
