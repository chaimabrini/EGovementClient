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
	
	public static Boolean doAddCareerObjectiveService(CareerObjectiveService careerObjectiveService){
		return getProxy().addCareerObjectiveService(careerObjectiveService);
	}
	public static Boolean doDeleteCareerObjectiveService(CareerObjectiveService careerObjectiveService){
		return getProxy().deleteCareerObjectiveService(careerObjectiveService);
	}
	public static Boolean doUpdateCareerObjectiveService(CareerObjectiveService careerObjectiveService){
		return getProxy().updateCareerObjectiveService(careerObjectiveService);
	}
	public static CareerObjectiveService doFindCareerObjectiveServiceByCin(String cin){
		return getProxy().findCareerObjectiveServiceByCin(cin);
	}
	public static CareerObjectiveService doFindCareerObjectiveServiceByGiroAccount(String giroAccount){
		return getProxy().findCareerObjectiveServiceByGiroAccount(giroAccount);
	}
	public static List<CareerObjectiveService> doFindCareerObjectiveServiceByCitizen(Citizen citizen){
		return getProxy().findCareerObjectiveServiceByCitizen(citizen);
	}
	public static List<CareerObjectiveService> doFindCareerObjectiveServiceByAgent(Agent agent){
		return getProxy().findCareerObjectiveServiceByAgent(agent);
	}
	public static List<CareerObjectiveService> doFindAllCareerObjectiveService(){
		return getProxy().findAllCareerObjectiveService();
	}
	
}
