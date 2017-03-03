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

}
