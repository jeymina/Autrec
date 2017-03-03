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

}
