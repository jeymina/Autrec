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
	
	public static Mode getModeById(int id) {
		Mode unMode = DAO.getEM().find(Mode.class, id);
		return unMode;
	}
	
	public static void createMode(Mode unMode) {
		DAO.getEM().getTransaction().begin();
		DAO.getEM().persist(unMode);
		DAO.getEM().getTransaction().commit();
	}

	public static void updateMode(Mode unMode) {
		DAO.getEM().getTransaction().begin();
		DAO.getEM().persist(unMode);
		DAO.getEM().getTransaction().commit();
	}
	
	public static void deleteMode(Mode unMode) {
		DAO.getEM().getTransaction().begin();
		DAO.getEM().remove(unMode);
		DAO.getEM().getTransaction().commit();
	}
	
}
