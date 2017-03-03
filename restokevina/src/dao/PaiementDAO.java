package dao;

import java.util.List;

import javax.persistence.TypedQuery;

import bean.Paiement;

public class PaiementDAO {
	
	public static List<Paiement> getListePaiement() {
		String req = "SELECT a FROM Paiement a";
		TypedQuery<Paiement> query = DAO.getEM().createQuery(req, Paiement.class);
		return query.getResultList();
	}

}
