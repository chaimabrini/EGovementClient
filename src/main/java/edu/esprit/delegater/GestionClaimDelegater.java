package edu.esprit.delegater;

import java.util.List;

import edu.esprit.domain.Claim;
import edu.esprit.locator.ServiceLocator;
import edu.esprit.services.gestion.claim.*;

public class GestionClaimDelegater {
	private static final String jndi = "E-Goverment/GestionClaim!edu.esprit.services.gestion.claim.GestionClaimRemote";

	private static GestionClaimRemote getProxy() {
		return (GestionClaimRemote) ServiceLocator.getInstance().getProxy(jndi);
	}

	public static Boolean doAddClaim(Claim claim){
		return getProxy().addClaim(claim);
	}

	public static Boolean doDeleteClaim(Claim claim) {
		return getProxy().deleteClaim(claim);
	}

	public static Boolean doUpdateClaim(Claim claim) {
		return getProxy().updateClaim(claim);
	}
	public static List<Claim> doFindAllClaim() {
		return getProxy().findAllClaim();
	}
}														
