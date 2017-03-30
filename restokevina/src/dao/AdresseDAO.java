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
		Adresse a;
		try {
			a = query.getSingleResult();
		}catch (Exception e) {
			System.err.println("Pas d'adresse avec le infos '"+ville+";"+cp+";"+voirie+"' trouv�");
			return null;
		}
		return a;
	}
	
	public static void createAdresse(Adresse uneAdresse) {
		if (!DAO.getEM().getTransaction().isActive()) DAO.getEM().getTransaction().begin();
		DAO.getEM().merge(uneAdresse);
		DAO.getEM().getTransaction().commit();

	}

	public static void updateAdresse(Adresse uneAdresse) {
		if (!DAO.getEM().getTransaction().isActive()) DAO.getEM().getTransaction().begin();
		DAO.getEM().merge(uneAdresse);
		DAO.getEM().getTransaction().commit();
	}

	public static void deleteAdresse(int id) {
		Adresse uneAdresse = DAO.getEM().find(Adresse.class, id);
		if (uneAdresse != null) {
			if (!DAO.getEM().getTransaction().isActive()) DAO.getEM().getTransaction().begin();
			DAO.getEM().remove(uneAdresse);
			DAO.getEM().getTransaction().commit();
		}
	}	

}
