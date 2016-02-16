package edu.esprit.delegater;

import java.util.List;

import edu.esprit.domain.Categorie;
import edu.esprit.locator.ServiceLocator;
import edu.esprit.services.gestion.categorie.GestionCategorieRemote;


public class GestionCategorieDelegater {

	
private static final String jndi = "E-Goverment/GestionCategorie!edu.esprit.services.gestion.categorie.GestionCategorieRemote";
	
	private static GestionCategorieRemote getProxy() {
		return (GestionCategorieRemote) ServiceLocator.getInstance().getProxy(jndi);
	}

	
	public static Boolean doAddCategorie(Categorie categorie){
		return getProxy().addCategorie(categorie);
	}
	public static Boolean doDeleteCategorie(Categorie categorie){
		return getProxy().deleteCategorie(categorie);
	}
	public static Boolean doUpdateCategorie(Categorie categorie){
		return getProxy().updateCategorie(categorie);
	}
	public static Categorie doFindCategorieByName(String name){
		return getProxy().findCategorieByName(name);
	}
	public static List<Categorie> doFindAllCategorie(){
		return getProxy().findAllCategorie();
	}
	
}
