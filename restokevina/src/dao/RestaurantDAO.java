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
	
	public static Restaurant getRestaurantById(int id) {
		Restaurant unRestaurant = DAO.getEM().find(Restaurant.class, id);
		return unRestaurant;
	}

	public static void createRestaurant(Restaurant unRestaurant) {
		DAO.getEM().getTransaction().begin();
		DAO.getEM().persist(unRestaurant);
		DAO.getEM().getTransaction().commit();
	}
	
	public static void updateRestaurant(Restaurant unRestaurant) {
		DAO.getEM().getTransaction().begin();
		DAO.getEM().persist(unRestaurant);
		DAO.getEM().getTransaction().commit();
	}
	
	public static void deleteRestaurant(Restaurant unRestaurant) {
		DAO.getEM().getTransaction().begin();
		DAO.getEM().remove(unRestaurant);
		DAO.getEM().getTransaction().commit();
	}
	
}
