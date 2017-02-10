package control;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.Session;

@Controller
public class SessionControle {
	
	@RequestMapping(value="/getSession",method=RequestMethod.GET)
	public @ResponseBody Session test3a(@ModelAttribute(value="client") Session session, BindingResult bres ){
		System.out.println("toto");
		Session res = null;
		if (!bres.hasErrors()) {
			res =Session.getInstance();
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
