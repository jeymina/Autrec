package dao;

import java.util.List;

import javax.persistence.TypedQuery;

import bean.Mode;

public class ModeDAO {
	
	public static List<Mode> getListeMode() {
		String req = "SELECT a FROM Mode a";
		TypedQuery<Mode> query = DAO.getEM().createQuery(req, Mode.class);
		return query.getResultList();
	}

}
