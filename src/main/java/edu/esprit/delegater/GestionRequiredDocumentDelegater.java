package edu.esprit.delegater;

import java.util.List;

import edu.esprit.domain.RequiredDocument;
import edu.esprit.domain.Service;
import edu.esprit.locator.ServiceLocator;

import edu.esprit.services.gestion.requireddocument.GestionRequiredDocumentRemote;


public class GestionRequiredDocumentDelegater {
	private static final String jndi = "E-Goverment/GestionRequiredDocument!edu.esprit.services.gestion.requireddocument.GestionRequiredDocumentRemote";

	private static GestionRequiredDocumentRemote getProxy() {
		return (GestionRequiredDocumentRemote) ServiceLocator.getInstance().getProxy(jndi);
	}

	public static Boolean doAddRequiredDocument(RequiredDocument requiredDocument){
		return getProxy().addRequiredDocument(requiredDocument);
	}

	public static Boolean doDeleteRequiredDocument(RequiredDocument requiredDocument) {
		return getProxy().deleteRequiredDocument(requiredDocument);
	}

	public static Boolean doUpdateRequiredDocument(RequiredDocument requiredDocument) {
		return getProxy().updateRequiredDocument(requiredDocument);
	}
	public static List<RequiredDocument> doFindAllRequiredDocument() {
		return getProxy().findAllRequiredDocument();
	}
	public static List<RequiredDocument> doFindAllRequiredDocumentByService(Service service) {
		return getProxy().findRequiredDocumentByService(service);
	}
}
