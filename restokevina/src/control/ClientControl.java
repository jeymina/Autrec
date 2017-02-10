package control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.Client;

@Controller
public class ClientControl {
	
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public @ResponseBody Client test3a(@ModelAttribute(value="client") @Valid Client client, BindingResult bres ){
		Client res = null;
		if (!bres.hasErrors()) {
			res = new Client(client.getNom(),client.getPrenom());
		}
		else {
			System.out.println("Erreurs détectées");
			for (FieldError fe : bres.getFieldErrors()) {
				System.out.println(fe.getField()+" : "+fe.getDefaultMessage());
			}
		}
		return res;
	}



}