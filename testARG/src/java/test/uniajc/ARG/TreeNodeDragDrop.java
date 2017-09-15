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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.primefaces.event.DragDropEvent;
import org.primefaces.event.TreeDragDropEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

@ManagedBean
@SessionScoped
public class TreeNodeDragDrop implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private List<Actividad> actividades;
    private List<TreeNode> nodos;

    private Actividad selectedCar;

    //Combos
    private ArrayList<SelectItem> itemsLugares;
    private String v_select_lugar;

    private TreeNode tabla;
    private Actividad selectedActividad;
    //private TreeNode treeSend;
  public static final String KEY = "treeSend";

    @PostConstruct
    public void init() {
        v_select_lugar = "";

        actividades = createAct();
        tabla = new DefaultTreeNode(new Actividad(), null);
        //Creo lugares
        TreeNode salon = new DefaultTreeNode(new Actividad("Salon", "9"), tabla);
        TreeNode blogger = new DefaultTreeNode(new Actividad("blogger", "10"), tabla);

        //Creo actividades
        TreeNode actividad1 = new DefaultTreeNode(actividades.get(0), salon);
        TreeNode actividad2 = new DefaultTreeNode(actividades.get(1), salon);
        TreeNode actividad3 = new DefaultTreeNode(actividades.get(2), blogger);

        nodos = new ArrayList<TreeNode>();
        nodos.add(salon);
        nodos.add(blogger);
        itemsLugares = Consultar_Lugares_combo();

    }

    public void cambiarLugar() {
        quitarNodo();
        ponerNodo();
        v_select_lugar="";
    }

    public void quitarNodo() {

        //recorro los lugares
        for (int i = 0; i < nodos.size(); i++) {
            //recorro las actividades de cada lugar 
            for (int m = 0; m < nodos.get(i).getChildren().size(); m++) {
                Actividad act = (Actividad) nodos.get(i).getChildren().get(m).getData();
                //Encuentro la actividad
                if (act.getId().equalsIgnoreCase(selectedActividad.getId())) {
                    //La quito de ese lugar
                    nodos.get(i).getChildren().remove(nodos.get(i).getChildren().get(m));
                }
            }
        }
    }

    public void ponerNodo() {
        //recorro los lugares
        for (int i = 0; i < nodos.size(); i++) {
            //encuentro el lugar destino
            Actividad lugar = (Actividad) nodos.get(i).getData();
            if (lugar.getId().equalsIgnoreCase(v_select_lugar)) {
                //Meto la actividad en ese lugar
                TreeNode actividad = new DefaultTreeNode(selectedActividad, nodos.get(i));
            }
        }
    }

    public List<Actividad> createAct() {
        List<Actividad> list = new ArrayList<>();
        list.add(new Actividad("1", "06/05/2017", "06/05/2018", "8:00pm", "19:00", "Correr", "Biblioteca", "Correr en el parque"));
        list.add(new Actividad("2", "08/05/2017", "08/05/2018", "5:00pm", "22:00", "Trotar", "Salon", "Trotar en el puesto por 30 segundos"));
        list.add(new Actividad("3", "08/05/2017", "08/05/2018", "5:00pm", "22:00", "saltar", "blogger", "Saltar lazo 30 rep"));
        return list;
    }

    public ArrayList<SelectItem> Consultar_Lugares_combo() {

        ArrayList<SelectItem> items = new ArrayList<SelectItem>();
        for (TreeNode obj : nodos) {
            Actividad act = (Actividad) obj.getData();
            items.add(new SelectItem(act.id, act.getDescripcion()));
        }
        return items;
    }
    
     public String navega() throws NamingException {
        
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getSessionMap().put(KEY, tabla);
            return "treeNodeDragDropDetail.xhtml";
     }
    
    public void cargarActividad(){
       v_select_lugar= selectedActividad.getIdLugar();
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }

    public Actividad getSelectedCar() {
        return selectedCar;
    }

    public void setSelectedCar(Actividad selectedCar) {
        this.selectedCar = selectedCar;
    }

    public TreeNode getTabla() {
        return tabla;
    }

    public void setTabla(TreeNode tabla) {
        this.tabla = tabla;
    }

    public List<TreeNode> getNodos() {
        return nodos;
    }

    public void setNodos(List<TreeNode> nodos) {
        this.nodos = nodos;
    }

    public ArrayList<SelectItem> getItemsLugares() {
        return itemsLugares;
    }

    public void setItemsLugares(ArrayList<SelectItem> itemsLugares) {
        this.itemsLugares = itemsLugares;
    }

    public String getV_select_lugar() {
        return v_select_lugar;
    }

    public void setV_select_lugar(String v_select_lugar) {
        this.v_select_lugar = v_select_lugar;
    }

    public Actividad getSelectedActividad() {
        return selectedActividad;
    }

    public void setSelectedActividad(Actividad selectedActividad) {
        this.selectedActividad = selectedActividad;
    }
}