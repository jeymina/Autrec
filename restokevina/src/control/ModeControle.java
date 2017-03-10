package control;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.Mode;
import dao.ModeDAO;

@Controller
public class ModeControle {
	@RequestMapping(value="/lesmodes",method=RequestMethod.GET)
	public @ResponseBody List<Mode> listerModes(){
		return ModeDAO.getListeMode();
	}
}
