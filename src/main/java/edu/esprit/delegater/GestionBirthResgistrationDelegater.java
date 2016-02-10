package edu.esprit.delegater;

import java.util.List;

import edu.esprit.domain.BirthRegistration;
import edu.esprit.locator.ServiceLocator;
import edu.esprit.services.gestion.birthregistration.GestionBirthRegistrationRemote;



public class GestionBirthResgistrationDelegater {

	private static final String jndi = "E-Goverment/GestionBirthRegistration!edu.esprit.services.gestion.birthregistration.GestionBirthRegistrationRemote";
	
	private static GestionBirthRegistrationRemote getProxy() {
		return (GestionBirthRegistrationRemote) ServiceLocator.getInstance().getProxy(jndi);
	}

	public static Boolean doAddBirthRegistration(BirthRegistration birthRegistration){
		return getProxy().addBirthRegistration(birthRegistration);
	}
	
	public static Boolean doDeleteBirthRegistration(BirthRegistration birthRegistration){
		return getProxy().deleteBirthRegistration(birthRegistration);
	}
	public static Boolean doUpdateBirthRegistration(BirthRegistration birthRegistration){
		return getProxy().updateBirthRegistration(birthRegistration);
	}
	public static List<BirthRegistration> doFindAllBirthRegistration(){
		return getProxy().findAllBirthRegistration();
	}
	
}
