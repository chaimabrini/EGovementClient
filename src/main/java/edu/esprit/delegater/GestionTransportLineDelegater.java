package edu.esprit.delegater;

import java.util.List;


import edu.esprit.domain.TransportLine;
import edu.esprit.locator.ServiceLocator;

import edu.esprit.services.gestion.transportline.GestionTransportLineRemote;

public class GestionTransportLineDelegater {

	private static final String jndi = "E-Goverment/GestionTransportLine!edu.esprit.services.gestion.transportline.GestionTransportLineRemote";

	private static GestionTransportLineRemote getProxy() {
		return (GestionTransportLineRemote) ServiceLocator.getInstance().getProxy(jndi);
	}

	public static Boolean doAddTransportLine(TransportLine transportLine){
		return getProxy().addTransportLine(transportLine);
	}

	public static Boolean doDeleteTransportLine(TransportLine transportLine) {
		return getProxy().deleteTransportLine(transportLine);
	}

	public static Boolean doUpdateTransportLine(TransportLine transportLine) {
		return getProxy().updateTransportLine(transportLine);
	}
	public static List<TransportLine> doFindAllTransportLine() {
		return getProxy().findAllTransportLines();
	}
	public static TransportLine doFindAllTransportLine(String numeroLine) {
		return getProxy().findTransportLineByNumeroLine(numeroLine);
	}
	
}
