package dao;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import bean.Adresse;

public abstract class AdresseDAO {
	
//	@Resource
//	DAO dao;
//	EntityManager em;
//	
//	public AdresseDAO() {
//		this.em = dao.getEM();
//	}
//
//	public Adresse getAdresse(int id) {
//		Adresse uneAdresse = em.find(Adresse.class, id);
//		return uneAdresse;
//	}
//
//	public Adresse getAdresse(String ville, String cp, String voirie) {
//		String req = "SELECT a FROM Adresse a WHERE a.ville=:ville AND a.cp=:cp AND a.voirie=:voirie";
//		TypedQuery<Adresse> query = em.createQuery(req, Adresse.class);
//		query.setParameter("ville", ville);
//		query.setParameter("cp", cp);
//		query.setParameter("voirie", voirie);
//		return query.getSingleResult();
//	}
//	
//	public List<Adresse> getLesAdresses() {
//		String req = "SELECT a FROM Adresse a";
//		TypedQuery<Adresse> query = em.createQuery(req, Adresse.class);
//		return query.getResultList();
//	}
//	
//	public int createAdresse(Adresse uneAdresse) {
//		em.persist(uneAdresse);
//		em.getTransaction().commit();
//		return 0;
//	}
//
//	public int updateAdresse(Adresse anObject) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	public int deleteAdresse(Adresse anObject) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
	

}
