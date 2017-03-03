package dao;

import java.util.List;

import javax.persistence.TypedQuery;

import bean.Utilisateur;

public class UtilisateurDAO {

	public static List<Utilisateur> getUtilisateurs() {
		String req = "SELECT a FROM Utilisateur a";
		TypedQuery<Utilisateur> query = DAO.getEM().createQuery(req, Utilisateur.class);
		return query.getResultList();
	}

}
