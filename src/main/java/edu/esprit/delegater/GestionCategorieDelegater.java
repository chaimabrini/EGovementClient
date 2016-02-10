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

	
	public Boolean doAddCategorie(Categorie categorie){
		return getProxy().addCategorie(categorie);
	}
	public Boolean doDeleteCategorie(Categorie categorie){
		return getProxy().deleteCategorie(categorie);
	}
	public Boolean doUpdateCategorie(Categorie categorie){
		return getProxy().updateCategorie(categorie);
	}
	public Categorie doFindCategorieByName(String name){
		return getProxy().findCategorieByName(name);
	}
	public List<Categorie> doFindAllCategorie(){
		return getProxy().findAllCategorie();
	}
	
}
