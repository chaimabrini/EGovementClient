package edu.esprit.delegater;

import java.util.List;

import edu.esprit.domain.Categorie;
import edu.esprit.domain.Etablishment;
import edu.esprit.domain.RequiredDocument;
import edu.esprit.domain.Service;
import edu.esprit.egov.service.ServiceRemote;
import edu.esprit.locator.ServiceLocator;

public class ManageServicesDelegater {
	private static final String jndi = "/E-Goverment/EgovService!edu.esprit.egov.service.ServiceRemote";
	
	private static ServiceRemote getProxy() {
		return (ServiceRemote) ServiceLocator.getInstance().getProxy(jndi);
	}
	
	
	
	public void doAddService (Service s){
		 getProxy().addService(s);
	}
	
	public void doUpdateService(Service s){
		getProxy().updateService(s);
	}
	
	public void doDeleteService(int idService){
		getProxy().deleteService(idService);
	}
	public List<Service> doShowAllServices(){
		return getProxy().showAllServices();
	}
	public Service doFindServiceById(int id){
		return getProxy().findServiceById(id);
	}
	public List<Service> doFindServiceByCategory(Categorie c){
		return getProxy().findServiceByCategory(c);
	}
	public List<Service> doFindServiceByEstablishment(Etablishment e){
		return getProxy().findServiceByEstablishment(e);
	}
	
	public void doAddDocumentToservice(RequiredDocument d){
		getProxy().addDocumentToservice(d);
	}
	public void doUpdateDocument(RequiredDocument d){
		getProxy().updateDocument(d);
	}
	public void doDeleteDocument(int idDocument){
		getProxy().deleteDocument(idDocument);
	}
	public List<RequiredDocument> doGetRequiredDocumentsByService(Service s){
		return getProxy().getRequiredDocumentsByService(s);
	}
	
	public RequiredDocument doFindDocumentById(int id){
		return getProxy().findDocumentById(id);
	}
	
	
	
	


}
