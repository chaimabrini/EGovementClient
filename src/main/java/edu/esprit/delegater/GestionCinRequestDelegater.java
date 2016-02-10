package edu.esprit.delegater;

import java.util.List;

import edu.esprit.domain.Agent;
import edu.esprit.domain.CinRequest;
import edu.esprit.domain.Citizen;
import edu.esprit.domain.Service;
import edu.esprit.locator.ServiceLocator;
import edu.esprit.services.gestion.cinRequest.GestionCinRequestRemote;

public class GestionCinRequestDelegater {

private static final String jndi = "E-Goverment/GestionCinRequest!edu.esprit.services.gestion.cinRequest.GestionCinRequestRemote";
	
	private static GestionCinRequestRemote getProxy() {
		return (GestionCinRequestRemote) ServiceLocator.getInstance().getProxy(jndi);
	}
	
	public static Boolean doAddCinRequest(CinRequest cinRequest){
		return getProxy().addCinRequest(cinRequest);
	}
	public static Boolean doDeleteCinRequest(CinRequest cinRequest){
		return getProxy().deleteCinRequest(cinRequest);
	}
	public static Boolean doUpdateCinRequest(CinRequest cinRequest){
		return getProxy().updateCinRequest(cinRequest);
	}
	public static CinRequest doFindCinRequestBybirthExcerpt(String birthExcerpt){
		return getProxy().findCinRequestBybirthExcerpt(birthExcerpt);
	}
	public static CinRequest doFindCinRequestByCitizen(Citizen citizen){
		return getProxy().findCinRequestByCitizen(citizen);
	}
	public static CinRequest doFindCinRequestByService(Service service){
		return getProxy().findCinRequestByService(service);
	}
	public static CinRequest findCinRequestByAgent(Agent agent){
		return getProxy().findCinRequestByAgent(agent);
	}
	public static List<CinRequest> doFindAllCinRequestByRequestState(String state){
		return getProxy().findAllCinRequestByRequestState(state);
	}
	public static List<CinRequest> doFindAllResidenceCertificate(CinRequest cinRequest){
		return getProxy().findAllResidenceCertificate(cinRequest);
	}
	public static List<CinRequest> findAllCinRequest(){
		return getProxy().findAllCinRequest();
	}
	
}
