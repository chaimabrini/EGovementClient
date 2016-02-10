package edu.esprit.delegater;

import java.util.List;

import edu.esprit.domain.RoadTaxService;
import edu.esprit.locator.ServiceLocator;
import edu.esprit.services.gestion.roadtaxservice.GestionRoadTaxServiceRemote;


public class GestionRoadTaxServiceDelegater {
	private static final String jndi = "E-Goverment/GestionRoadTaxService!edu.esprit.services.gestion.roadtaxservice.GestionRoadTaxServiceRemote";

	private static GestionRoadTaxServiceRemote getProxy() {
		return (GestionRoadTaxServiceRemote) ServiceLocator.getInstance().getProxy(jndi);
	}

	public static Boolean doAddRoadTaxService(RoadTaxService roadTaxService){
		return getProxy().addRoadTaxService(roadTaxService);
	}

	public static Boolean doDeleteRoadTaxService(RoadTaxService roadTaxService) {
		return getProxy().deleteRoadTaxService(roadTaxService);
	}

	public static Boolean doUpdateRoadTaxService(RoadTaxService roadTaxService) {
		return getProxy().updateRoadTaxService(roadTaxService);
	}
	public static List<RoadTaxService> doFindAllRoadTaxService() {
		return getProxy().findAllRoadTaxService();
	}
}
