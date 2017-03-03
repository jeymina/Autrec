package dao;

import java.util.List;

import javax.persistence.TypedQuery;

import bean.Commande;

public class CommandeDAO {

	public static List<Commande> getListeCommande() {
		String req = "SELECT a FROM Commande a";
		TypedQuery<Commande> query = DAO.getEM().createQuery(req, Commande.class);
		return query.getResultList();
	}
	
}
