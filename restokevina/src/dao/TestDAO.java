package dao;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import bean.Adresse;
import bean.Utilisateur;

public class TestDAO {

	public static List<Utilisateur> getUserByVille(String ville) {
		String req = "SELECT a FROM Utilisateur a, Adresse b WHERE b.id=a.utilisateurAdr AND b.ville=:ville";
		TypedQuery<Utilisateur> query = DAO.getEM().createQuery(req, Utilisateur.class);
		query.setParameter("ville", ville);
		return query.getResultList();
	}
	
	public static void createAdr(Adresse adr) {
		DAO.getEM().getTransaction().begin();
		DAO.getEM().persist(adr);
		DAO.getEM().getTransaction().commit();
	}
	
	public static void updateADr(Adresse adr) {
		DAO.getEM().getTransaction().begin();
		DAO.getEM().persist(adr);
		DAO.getEM().getTransaction().commit();
	}
	
	public static void deleteADr(int id) {
		Adresse adr = AdresseDAO.getAdresseById(id);
		if (adr != null){
			DAO.getEM().getTransaction().begin();
			DAO.getEM().remove(adr);
			DAO.getEM().getTransaction().commit();			
		}
	}

	public static void testingPOST(Adresse adr) {
		System.out.println("enregistrerADr nom = "+adr.getVoirie());

		Adresse a = new Adresse();
		a.setVoirie(adr.getVoirie());
		a.setCp(adr.getCp());
		a.setVille(adr.getVille());

		TestDAO.createAdr(a);
	}

}
