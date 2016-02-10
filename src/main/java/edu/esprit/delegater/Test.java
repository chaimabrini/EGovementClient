package edu.esprit.delegater;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import edu.esprit.domain.Claim;
import edu.esprit.services.gestion.claim.GestionClaimRemote;

public class Test {

	public static void main(String[] args) {
		
		GestionClaimRemote gestionClaimRemote = null;
		
		try {
			
			Context ctx = new InitialContext();
			Object proxy = ctx.lookup("E-Goverment/GestionClaim!edu.esprit.services.gestion.claim.GestionClaimRemote");
			gestionClaimRemote =  (GestionClaimRemote) proxy;	
			
			Claim claim = new Claim();
			claim.setMail("mail");
			claim.setState("state");
			claim.setSubject("sub");
			claim.setTextClaim("text");
			gestionClaimRemote.addClaim(claim);
			
			System.out.println("Fucking Amazing");
		} catch (NamingException e) {
			e.printStackTrace();
		}

	}

}
