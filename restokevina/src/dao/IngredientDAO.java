package dao;

import java.util.List;

import javax.persistence.TypedQuery;
import bean.Ingredient;

public class IngredientDAO {
	
	public static List<Ingredient> getListeIngredient() {
		String req = "SELECT a FROM Ingredient a";
		TypedQuery<Ingredient> query = DAO.getEM().createQuery(req, Ingredient.class);
		return query.getResultList();
	}

	public static Ingredient getIngredientById(int id) {
		Ingredient unIngredient = DAO.getEM().find(Ingredient.class, id);
		return unIngredient;
	}
	
	public static void createIngredient(Ingredient unIngredient) {
		DAO.getEM().getTransaction().begin();
		DAO.getEM().persist(unIngredient);
		DAO.getEM().getTransaction().commit();
	}
	
	public static void updateIngredient(Ingredient unIngredient) {
		DAO.getEM().getTransaction().begin();
		DAO.getEM().persist(unIngredient);
		DAO.getEM().getTransaction().commit();
	}
	
	public static void deleteIngredient(Ingredient unIngredient) {
		DAO.getEM().getTransaction().begin();
		DAO.getEM().remove(unIngredient);
		DAO.getEM().getTransaction().commit();
	}
	
}
