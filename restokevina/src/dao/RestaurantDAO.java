package dao;

import java.util.List;

import javax.persistence.TypedQuery;

import bean.Restaurant;

public class RestaurantDAO {
	
	public static List<Restaurant> getListeRestaurant() {
		String req = "SELECT a FROM Restaurant a";
		TypedQuery<Restaurant> query = DAO.getEM().createQuery(req, Restaurant.class);
		return query.getResultList();
	}

}
