package dao;

import java.util.List;

import javax.persistence.TypedQuery;

import bean.Plat;

public class PlatDAO {
	
	public static List<Plat> getListePlat() {
		String req = "SELECT a FROM Plat a";
		TypedQuery<Plat> query = DAO.getEM().createQuery(req, Plat.class);
		return query.getResultList();
	}

}
