package dao;

import java.util.List;

import javax.persistence.TypedQuery;

import bean.Adresse;

public class AdresseDAO {


	public static Adresse getAdresse(int id) {
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
	
	public static List<Adresse> getLesAdresses() {
		String req = "SELECT a FROM Adresse a";
		TypedQuery<Adresse> query = DAO.getEM().createQuery(req, Adresse.class);
		return query.getResultList();
	}
	
	public static int createAdresse(Adresse uneAdresse) {
		DAO.getEM().persist(uneAdresse);
		DAO.getEM().getTransaction().commit();
		return 0;
	}

	public static int updateAdresse(Adresse anObject) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static int deleteAdresse(Adresse anObject) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
