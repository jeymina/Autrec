package dao;

import java.util.List;

import javax.persistence.TypedQuery;

import bean.Supplement;

public class SupplementDAO {
	
	public static List<Supplement> getListeSupplement() {
		String req = "SELECT a FROM Supplement a";
		TypedQuery<Supplement> query = DAO.getEM().createQuery(req, Supplement.class);
		return query.getResultList();
	}

}
