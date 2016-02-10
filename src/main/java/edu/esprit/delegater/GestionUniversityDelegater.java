package edu.esprit.delegater;

import java.util.List;

import edu.esprit.domain.University;
import edu.esprit.locator.ServiceLocator;
import edu.esprit.services.gestion.university.GestionUniversityRemote;


public class GestionUniversityDelegater {
	private static final String jndi = "E-Goverment/GestionUniversity!edu.esprit.services.gestion.university.GestionUniversityRemote";

	private static GestionUniversityRemote getProxy() {
		return (GestionUniversityRemote) ServiceLocator.getInstance().getProxy(jndi);
	}

	public static Boolean doAddUniversity(University university){
		return getProxy().addUniversity(university);
	}

	public static Boolean doDeleteUniversity(University university) {
		return getProxy().deleteUniversity(university);
	}

	public static Boolean doUpdateUniversity(University university) {
		return getProxy().updateUniversity(university);
	}
	
	public static University doFindUniversityByName(String name) {
		return getProxy().findUniversityByName(name);
	}
	public static University doFindUniversityByMail(String mail) {
		return getProxy().findUniversityByMail(mail);
	}
	public static University doFindUniversityByContact(String contact) {
		return getProxy().findUniversityByContact(contact);
	}
	public static List<University> doFindAllUniversity() {
		return getProxy().findAllUniversity();
	}
	
	
	
	
}
