package serveur.dao;

public interface IDAO <T> {
	
	T get(int id);
	
	int create(T anObject);
	
	int update(T anObject);
	
	int delete(T anObject);

}
