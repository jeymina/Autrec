package dao;

import java.util.List;

import javax.persistence.TypedQuery;

import bean.Option;

public class OptionDAO {
	
	public static List<Option> getListeOption() {
		String req = "SELECT a FROM Option a";
		TypedQuery<Option> query = DAO.getEM().createQuery(req, Option.class);
		return query.getResultList();
	}

}
