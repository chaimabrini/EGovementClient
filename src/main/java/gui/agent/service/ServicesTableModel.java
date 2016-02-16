package gui.agent.service;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import edu.esprit.delegater.ManageServicesDelegater;
import edu.esprit.domain.Etablishment;
import edu.esprit.domain.Service;

public class ServicesTableModel extends AbstractTableModel {

	String[] titres = { "id", "Name", "Description", "Establishment", "Category" };
	private List<Service> services = new ArrayList<>();
	ManageServicesDelegater mngServ;

	public ServicesTableModel(){
		mngServ = new ManageServicesDelegater();
		services = mngServ.doShowAllServices();

	}
	
	public ServicesTableModel(Etablishment e){
		mngServ = new ManageServicesDelegater();
		services = mngServ.doFindServiceByEstablishment(e);

	}

	@Override
	public int getRowCount() {
		return services.size();
	}

	@Override
	public int getColumnCount() {
		return titres.length;

	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		switch (columnIndex) {
		case 0:
			return services.get(rowIndex).getIdService();
		case 1:
			return services.get(rowIndex).getName();
		case 2:
			return services.get(rowIndex).getDescription();
		// case 3 : return services.get(rowIndex).getEtablishment().getName();
		 case 4 : return services.get(rowIndex).getCategorie().getName();

		default:
			return null;

		}

	}

	@Override
	public String getColumnName(int column) {
		return titres[column];
	}

}
