package control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.Session;

@Controller
public class SessionControle {
	
	@RequestMapping(value="/getSession", method = RequestMethod.GET)
	public @ResponseBody Session test3a(){
		System.out.println("tototototototottotototo");
		Session res = Session.getInstance();
		return res;
	}
	
}
