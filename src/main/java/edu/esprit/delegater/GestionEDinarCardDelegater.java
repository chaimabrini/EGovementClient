package edu.esprit.delegater;

import java.util.List;

import edu.esprit.domain.EDinarCard;
import edu.esprit.locator.ServiceLocator;
import edu.esprit.services.gestion.eDinarCard.GestionEDinarCardRemote;

public class GestionEDinarCardDelegater {

	private static final String jndi = "E-Goverment/GestionEDinarCard!edu.esprit.services.gestion.eDinarCard.GestionEDinarCardRemote";

	private static GestionEDinarCardRemote getProxy() {
		return (GestionEDinarCardRemote) ServiceLocator.getInstance().getProxy(jndi);
	}

	
	public static Boolean doAddEDinarCard(EDinarCard eDinarCard){
		return getProxy().addEDinarCard(eDinarCard);
	}
	public static Boolean doDeleteEDinarCard(EDinarCard eDinarCard){
		return getProxy().deleteEDinarCard(eDinarCard);
	}
	public static Boolean doUpdateEDinarCard(EDinarCard eDinarCard){
		return getProxy().updateEDinarCard(eDinarCard);
	}
	public static EDinarCard doFindEDinarCardByNumeroCard(String numeroCard){
		return getProxy().findEDinarCardByNumeroCard(numeroCard);
	}
	public static List<EDinarCard> doFindAllEDinarCard(){
		return getProxy().findAllEDinarCard();
	}
}
