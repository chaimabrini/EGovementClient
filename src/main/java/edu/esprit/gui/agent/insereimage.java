package edu.esprit.gui.agent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import edu.esprit.delegater.GestionRoadTaxServiceDelegater;
import edu.esprit.domain.RoadTaxService;

public class insereimage {

	public static void main(String[] args) throws FileNotFoundException {
		 
		File file = new File("c:\\test.png");
		byte[] imageData = new byte[(int) file.length()];
		 
		try {
		    FileInputStream fileInputStream = new FileInputStream(file);
		    fileInputStream.read(imageData);
		    fileInputStream.close();
		} catch (Exception e) {
		    e.printStackTrace();
		}
		RoadTaxService roadTaxService=new RoadTaxService();
		  
		  roadTaxService.setDrivingLicense(imageData);
		  GestionRoadTaxServiceDelegater.doAddRoadTaxService(roadTaxService);

	}

}
