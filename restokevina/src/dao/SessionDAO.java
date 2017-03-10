package dao;

import java.util.List;

import javax.persistence.TypedQuery;

import bean.Session;

public class SessionDAO {
	
	public static List<Session> getListeSession() {
		String req = "SELECT a FROM Session a";
		TypedQuery<Session> query = DAO.getEM().createQuery(req, Session.class);
		return query.getResultList();
	}

	public static Session getSessionById(int id) {
		Session uneSession = DAO.getEM().find(Session.class, id);
		return uneSession;
	}
	
	public static void createSession(Session uneSession) {
		DAO.getEM().getTransaction().begin();
		DAO.getEM().persist(uneSession);
		DAO.getEM().getTransaction().commit();
	}
	
	public static void updateSession(Session uneSession) {
		DAO.getEM().getTransaction().begin();
		DAO.getEM().persist(uneSession);
		DAO.getEM().getTransaction().commit();
	}
	
	public static void deleteSession(int id) {
		Session uneSession = DAO.getEM().find(Session.class, id);
		if (uneSession != null) {
			DAO.getEM().getTransaction().begin();
			DAO.getEM().remove(uneSession);
			DAO.getEM().getTransaction().commit();			
		}
	}
	
}
