/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.uniajc.ARG;

/**
 *
 * @author luis.leon
 */


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.CloseEvent;
import org.primefaces.event.DashboardReorderEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.DashboardColumn;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardColumn;
import org.primefaces.model.DefaultDashboardModel;

@ManagedBean
@ViewScoped
public class DashboardView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2243134537658957425L;
	private DashboardModel model;
	private DashboardModel model2;
	private List<DashboardModel> modelos;
	private List<String> cadenas;
	private List<String> carros;

	@PostConstruct
	public void init() {
		model = new DefaultDashboardModel();
		model2 = new DefaultDashboardModel();
		DashboardColumn column1 = new DefaultDashboardColumn();
		DashboardColumn column2 = new DefaultDashboardColumn();
		DashboardColumn column3 = new DefaultDashboardColumn();
		DashboardColumn column4 = new DefaultDashboardColumn();
		modelos = new ArrayList<DashboardModel>();
		cadenas = new ArrayList<String>();
		cadenas.add("Pruebas");
		cadenas.add("Pruebas2");
		cadenas.add("Pruebas3");
                
               
		
		column1.addWidget("sports");
		column1.addWidget("blank");
		column1.addWidget("blank");
		
		column2.addWidget("lifestyle");
		column2.addWidget("weather");
		column2.addWidget("blank");
		
		column3.addWidget("politics");
		column3.addWidget("finance");
		column3.addWidget("academic");
		
		column4.addWidget("blank");
		column4.addWidget("blank");
		column4.addWidget("blank");
		
		model.addColumn(column1);
		model.addColumn(column2);
		model.addColumn(column3);
		model.addColumn(column4);

		modelos.add(model);
		modelos.add(model2);
	}

	public void handleReorder(DashboardReorderEvent event) {
		FacesMessage message = new FacesMessage();
		message.setSeverity(FacesMessage.SEVERITY_INFO);
		message.setSummary("Reordered: " + event.getWidgetId());
		message.setDetail("Item index: " + event.getItemIndex()
				+ ", Column index: " + event.getColumnIndex()
				+ ", Sender index: " + event.getSenderColumnIndex());
		System.out.println(DashboardView.class.getName()+".event["+event.getColumnIndex()+"]["+event.getItemIndex()+"]");
		addMessage(message);
	}

	public void handleClose(CloseEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Panel Closed", "Closed panel id:'"
						+ event.getComponent().getId() + "'");

		addMessage(message);
	}

	public void handleToggle(ToggleEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				event.getComponent().getId() + " toggled", "Status:"
						+ event.getVisibility().name());

		addMessage(message);
	}

	private void addMessage(FacesMessage message) {
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public DashboardModel getModel() {
		return model;
	}

	/**
	 * @return the cadenas
	 */
	public List<String> getCadenas() {
		return cadenas;
	}

	/**
	 * @param cadenas
	 *            the cadenas to set
	 */
	public void setCadenas(List<String> cadenas) {
		this.cadenas = cadenas;
	}

	/**
	 * @return the model2
	 */
	public DashboardModel getModel2() {
		return model2;
	}

	/**
	 * @param model2
	 *            the model2 to set
	 */
	public void setModel2(DashboardModel model2) {
		this.model2 = model2;
	}

	/**
	 * @return the modelos
	 */
	public List<DashboardModel> getModelos() {
		return modelos;
	}

	/**
	 * @param modelos
	 *            the modelos to set
	 */
	public void setModelos(List<DashboardModel> modelos) {
		this.modelos = modelos;
	}
}

