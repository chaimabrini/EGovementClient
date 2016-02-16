package gui.agent.service;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import edu.esprit.delegater.ManageServicesDelegater;
import edu.esprit.domain.RequiredDocument;
import edu.esprit.domain.Service;

public class DocumentTableModel  extends AbstractTableModel {

	String[] titres = { "id", "Name", "Description"};
	private List<RequiredDocument> services = new ArrayList<>();
	ManageServicesDelegater mngServ;

	public DocumentTableModel(Service s) {
		mngServ = new ManageServicesDelegater();
		services = mngServ.doGetRequiredDocumentsByService(s);

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
			return services.get(rowIndex).getIdRequiredDocument();
		case 1:
			return services.get(rowIndex).getName();
		case 2:
			return services.get(rowIndex).getDescription();
		

		default:
			return null;

		}

	}

	@Override
	public String getColumnName(int column) {
		return titres[column];
	}

}
