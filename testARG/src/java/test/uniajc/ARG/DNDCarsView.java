package test.uniajc.ARG;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.DragDropEvent;
import org.primefaces.event.TreeDragDropEvent;
import org.primefaces.model.TreeNode;

@ManagedBean(name = "dndCarsView")
@ViewScoped
public class DNDCarsView implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private List<Actividad> actividades;

    private Actividad selectedCar;

    @PostConstruct
    public void init() {
        actividades = createAct();

    }

    public List<Actividad> createAct() {
        List<Actividad> list = new ArrayList<>();
        list.add(new Actividad("1", "06/05/2017", "06/05/2018", "8:00pm", "19:00", "Correr", "Biblioteca"));
        list.add(new Actividad("1", "08/05/2017", "08/05/2018", "5:00pm", "22:00", "Trotar", "Salon"));
        return list;
    }

    public void onDragDrop(TreeDragDropEvent event) {
        TreeNode dragActividadOrigen = event.getDragNode();
        TreeNode dragCajaOrigen = dragActividadOrigen.getParent();
        TreeNode dropCajaDestino = event.getDropNode();
        TreeNode dropActividadDestino =  dropCajaDestino.getChildren().get(0);
        
        
        
        int dropIndex = event.getDropIndex();
        

        //FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Dragged " + dragNode.getData(), "Dropped on " + dropNode.getData() + " at " + dropIndex);
        //FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void actualizarActividades(){
        
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

}
