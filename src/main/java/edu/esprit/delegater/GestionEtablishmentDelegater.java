package edu.esprit.delegater;

import java.util.List;

import edu.esprit.domain.Etablishment;
import edu.esprit.locator.ServiceLocator;
import edu.esprit.services.gestion.etablishment.GestionEtablishmentRemote;


public class GestionEtablishmentDelegater {
	private static final String jndi = "E-Goverment/GestionEtablishment!edu.esprit.services.gestion.etablishment.GestionEtablishmentRemote";

	private static GestionEtablishmentRemote getProxy() {
		return (GestionEtablishmentRemote) ServiceLocator.getInstance().getProxy(jndi);
	}

	public static Boolean doAddEtablishment(Etablishment etablishment){
		return getProxy().addEtablishment(etablishment);
	}

	public static Boolean doDeleteEtablishment(Etablishment etablishment) {
		return getProxy().deleteEtablishment(etablishment);
	}

	public static Boolean doUpdateEtablishment(Etablishment etablishment) {
		return getProxy().updateEtablishment(etablishment);
	}
	public static List<Etablishment> doFindAllEtablishment() {
		return getProxy().findAllEtablishments();
	}
	public static Etablishment doFindAllEtablishmentByName(String name) {
		return getProxy().findEtablishmentByName(name);
	}
}
