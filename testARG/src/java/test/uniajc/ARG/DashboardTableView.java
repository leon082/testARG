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
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
 
import org.primefaces.event.CloseEvent;
import org.primefaces.event.DashboardReorderEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.DashboardColumn;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardColumn;
import org.primefaces.model.DefaultDashboardModel;
 
@ManagedBean(name = "dashboardTableView")

@SessionScoped
public class DashboardTableView implements Serializable {
     
    private DashboardModel model;
    private DashboardModel model2;
     
    @PostConstruct
    public void init() {
        model = new DefaultDashboardModel();
        DashboardColumn column1 = new DefaultDashboardColumn();
        DashboardColumn column2 = new DefaultDashboardColumn();
        DashboardColumn column3 = new DefaultDashboardColumn();
         
        column1.addWidget("sports");
        column1.addWidget("finance");
         
        column2.addWidget("lifestyle");
        column2.addWidget("weather");
         
        column3.addWidget("politics");
 
        model.addColumn(column1);
        model.addColumn(column2);
        model.addColumn(column3);
        //model2
        model2 = new DefaultDashboardModel();
        DashboardColumn column01 = new DefaultDashboardColumn();
        DashboardColumn column02 = new DefaultDashboardColumn();
        DashboardColumn column03 = new DefaultDashboardColumn();
         
        column01.addWidget("correr");
        column01.addWidget("trotar");
         
        column02.addWidget("resolver");
        column02.addWidget("nadar");
         
        column03.addWidget("saltar");
 
        model2.addColumn(column01);
        model2.addColumn(column02);
        model2.addColumn(column03);
    }
     
    public void handleReorder(DashboardReorderEvent event) {
        FacesMessage message = new FacesMessage();
        message.setSeverity(FacesMessage.SEVERITY_INFO);
        message.setSummary("Reordered: " + event.getWidgetId());
        message.setDetail("Item index: " + event.getItemIndex() + ", Column index: " + event.getColumnIndex() + ", Sender index: " + event.getSenderColumnIndex());
         
        addMessage(message);
    }
     
    public void handleClose(CloseEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Panel Closed", "Closed panel id:'" + event.getComponent().getId() + "'");
         
        addMessage(message);
    }
     
    public void handleToggle(ToggleEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, event.getComponent().getId() + " toggled", "Status:" + event.getVisibility().name());
         
        addMessage(message);
    }
     
    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
     
    public DashboardModel getModel() {
        return model;
    }

    public DashboardModel getModel2() {
        return model2;
    }

    public void setModel2(DashboardModel model2) {
        this.model2 = model2;
    }
    
    
}

