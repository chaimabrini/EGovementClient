package edu.esprit.delegater;

import java.util.List;

import edu.esprit.domain.Agent;
import edu.esprit.domain.CareerObjectiveService;
import edu.esprit.domain.Citizen;
import edu.esprit.locator.ServiceLocator;
import edu.esprit.services.gestion.careerobjectiveservice.GestionCareerObjectiveServiceRemote;


public class GestionCareerObjectiveServiceDelegater {

private static final String jndi = "E-Goverment/GestionCareerObjectiveService!edu.esprit.services.gestion.careerobjectiveservice.GestionCareerObjectiveServiceRemote";
	
	private static GestionCareerObjectiveServiceRemote getProxy() {
		return (GestionCareerObjectiveServiceRemote) ServiceLocator.getInstance().getProxy(jndi);
	}
	
	Boolean doAddCareerObjectiveService(CareerObjectiveService careerObjectiveService){
		return getProxy().addCareerObjectiveService(careerObjectiveService);
	}
	Boolean doDeleteCareerObjectiveService(CareerObjectiveService careerObjectiveService){
		return getProxy().deleteCareerObjectiveService(careerObjectiveService);
	}
	Boolean doUpdateCareerObjectiveService(CareerObjectiveService careerObjectiveService){
		return getProxy().updateCareerObjectiveService(careerObjectiveService);
	}
	CareerObjectiveService doFindCareerObjectiveServiceByCin(String cin){
		return getProxy().findCareerObjectiveServiceByCin(cin);
	}
	CareerObjectiveService doFindCareerObjectiveServiceByGiroAccount(String giroAccount){
		return getProxy().findCareerObjectiveServiceByGiroAccount(giroAccount);
	}
	List<CareerObjectiveService> doFindCareerObjectiveServiceByCitizen(Citizen citizen){
		return getProxy().findCareerObjectiveServiceByCitizen(citizen);
	}
	List<CareerObjectiveService> doFindCareerObjectiveServiceByAgent(Agent agent){
		return getProxy().findCareerObjectiveServiceByAgent(agent);
	}
	List<CareerObjectiveService> doFindAllCareerObjectiveService(){
		return getProxy().findAllCareerObjectiveService();
	}
	
}
