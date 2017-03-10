package control;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.Paiement;
import dao.PaiementDAO;

@Controller
public class PaiementControle {
	@RequestMapping(value="/lespaiement",method=RequestMethod.GET)
	public @ResponseBody List<Paiement> listerPaiements(){
		return PaiementDAO.getListePaiement();
	}
}
