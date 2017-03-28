package dao;

import java.util.List;

import javax.persistence.TypedQuery;

import bean.Adresse;

public class AdresseDAO {

	public static List<Adresse> getListeAdresse() {
		String req = "SELECT a FROM Adresse a";
		TypedQuery<Adresse> query = DAO.getEM().createQuery(req, Adresse.class);
		return query.getResultList();
	}

	public static Adresse getAdresseById(int id) {
		Adresse uneAdresse = DAO.getEM().find(Adresse.class, id);
		return uneAdresse;
	}

	public static Adresse getAdresse(String ville, String cp, String voirie) {
		String req = "SELECT a FROM Adresse a WHERE a.ville=:ville AND a.cp=:cp AND a.voirie=:voirie";
		TypedQuery<Adresse> query = DAO.getEM().createQuery(req, Adresse.class);
		query.setParameter("ville", ville);
		query.setParameter("cp", cp);
		query.setParameter("voirie", voirie);
		return query.getSingleResult();
	}
	
	public static void createAdresse(Adresse uneAdresse) {
		DAO.getEM().getTransaction().begin();
		DAO.getEM().persist(uneAdresse);
		DAO.getEM().getTransaction().commit();

	}

	public static void updateAdresse(Adresse uneAdresse) {
		DAO.getEM().getTransaction().begin();
		DAO.getEM().persist(uneAdresse);
		DAO.getEM().getTransaction().commit();
	}

	public static void deleteAdresse(int id) {
		Adresse uneAdresse = DAO.getEM().find(Adresse.class, id);
		if (uneAdresse != null) {
			DAO.getEM().getTransaction().begin();
			DAO.getEM().remove(uneAdresse);
			DAO.getEM().getTransaction().commit();
		}
	}	

}
