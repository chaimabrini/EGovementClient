package edu.esprit.delegater;

import java.util.List;

import edu.esprit.domain.Agent;
import edu.esprit.domain.EDinarServiceRequest;
import edu.esprit.domain.Service;
import edu.esprit.domain.TransportLine;
import edu.esprit.domain.University;
import edu.esprit.locator.ServiceLocator;
import edu.esprit.services.gestion.edinarservicerequest.GestionEDinarServiceRequestRemote;


public class GestionEDinarServiceRequestDelegater {
	private static final String jndi = "E-Goverment/GestionEDinarServiceRequest!edu.esprit.services.gestion.edinarservicerequest.GestionEDinarServiceRequestRemote";

	private static GestionEDinarServiceRequestRemote getProxy() {
		return (GestionEDinarServiceRequestRemote) ServiceLocator.getInstance().getProxy(jndi);
	}

	public static Boolean doAddEDinarServiceRequest(EDinarServiceRequest eDinarServiceRequest){
		return getProxy().addEDinarServiceRequest(eDinarServiceRequest);
	}

	public static Boolean doDeleteEDinarServiceRequest(EDinarServiceRequest eDinarServiceRequest) {
		return getProxy().deleteEDinarServiceRequest(eDinarServiceRequest);
	}

	public static Boolean doUpdateEDinarServiceRequest(EDinarServiceRequest eDinarServiceRequest) {
		return getProxy().updateEDinarServiceRequest(eDinarServiceRequest);
	}
	public static List<EDinarServiceRequest> doFindAlleDinarServiceRequestByService(Service service) {
		return getProxy().findEDinarServiceRequestByService(service);
	}
	public static List<EDinarServiceRequest> doFindAlleDinarServiceRequestByUniverity(University university) {
		return getProxy().findEDinarServiceRequestByUniversity(university);
	}
	public static List<EDinarServiceRequest> doFindAlleDinarServiceRequestByTransportLine(TransportLine transportLine) {
		return getProxy().findEDinarServiceRequestByTransportLine(transportLine);
	}
	
	public static List<EDinarServiceRequest> doFindAlleDinarServiceRequestByAgent(Agent agent) {
		return getProxy().findEDinarServiceRequestByAgent(agent);
	}
	
	
	public static List<EDinarServiceRequest> doFindAlleDinarServiceRequest() {
		return getProxy().findAllEDinarServiceRequest();
	}
}
