package control;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.Adresse;
import bean.Client;
import dao.AdresseDAO;

@Controller
public class AdresseControle {
	
	@RequestMapping(value="/lesadresses",method=RequestMethod.GET)
	public @ResponseBody List<Adresse> listerAdresses(){
		return AdresseDAO.getLesAdresses();
	}
	
}
