package dao;

import java.util.List;

import javax.persistence.TypedQuery;

import bean.Com_Plat;
import bean.Commande;

public class CommandeDAO {

	public static List<Commande> getListeCommande() {
		String req = "SELECT a FROM Commande a";
		TypedQuery<Commande> query = DAO.getEM().createQuery(req, Commande.class);
		return query.getResultList();
	}
	
	public static Commande getCommandeById(int id) {
		Commande uneCommande = DAO.getEM().find(Commande.class, id);
		return uneCommande;
	}
	
	public static void createCommande(Commande uneCommande) {
		DAO.getEM().getTransaction().begin();
		DAO.getEM().persist(uneCommande);
		DAO.getEM().getTransaction().commit();
	}
	
	public static void updateCommande(Commande uneCommande) {
		DAO.getEM().getTransaction().begin();
		DAO.getEM().persist(uneCommande);
		DAO.getEM().getTransaction().commit();
	}
	
	public static void deleteCommande(int id) {
		Commande uneCommande = DAO.getEM().find(Commande.class, id);
		if (uneCommande != null) {
			DAO.getEM().getTransaction().begin();
			DAO.getEM().remove(uneCommande);
			DAO.getEM().getTransaction().commit();			
		}
	}

	public static List<Commande> getCommandeEnCour(int userid) {
		String req = "SELECT a FROM Commande a, Utilisateur b WHERE a.commandeUtil=b.id AND b.id=:userid AND a.dateValidation=NULL";
		TypedQuery<Commande> query = DAO.getEM().createQuery(req, Commande.class);
		query.setParameter("userid", userid);
		List<Commande> cmd;
		cmd = query.getResultList();
		return cmd;
	}
	
	public static void ajouteUneQte(Com_Plat complat, int qte) {
		DAO.getEM().getTransaction().begin();
		complat.setQuantite(complat.getQuantite()+qte);
		DAO.getEM().getTransaction().commit();	
	}

	public static void createComPlat(Com_Plat complat) {
		DAO.getEM().getTransaction().begin();
		DAO.getEM().persist(complat);
		DAO.getEM().getTransaction().commit();
	}

	public static Com_Plat getComPlaById(int comId, int platId) {
		System.out.println("***DEB getComPlaById : comId="+comId+" platId="+platId);
		String req = "SELECT a FROM Com_Plat a, Commande b, Plat c WHERE a.complatCom=b.id AND a.complatPlat=c.id AND b.id=:comId AND c.id=:platId";
		TypedQuery<Com_Plat> query = DAO.getEM().createQuery(req, Com_Plat.class);
		query.setParameter("comId", comId);
		query.setParameter("platId", platId);
		Com_Plat compla;
		try {
			compla = query.getSingleResult();
		}catch (Exception e) {
			System.err.println("Pas d'adresse avec les infos comId='"+comId+"' platId='"+platId+"' trouvé");
			return null;
		}

		System.out.println("***END getComPlaById : comId="+compla.getComplatCom().getId()+" platId="+compla.getComplatPlat().getId());
		return compla;
	}
}
