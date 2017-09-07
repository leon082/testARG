package test.uniajc.ARG;

import java.io.Serializable;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

public class Actividad implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    public String id;
    public String fechaIni;
    public String fechaFin;
    public String horaIni;
    public String horaFin;
    public String idLugar;
    public String descripcion;
    private TreeNode lugar;

    public Actividad() {
    
    }
    
    public Actividad(String id, String fechaIni, String fechaFin, String horaIni, String horaFin , String nombreAct, String idLugar) {
       this.id=id;
       this.fechaIni=fechaIni;
       this.fechaFin=fechaFin;
       this.horaIni=horaIni;
       this.horaFin=horaFin;
       this.idLugar=idLugar;
       this.descripcion=nombreAct;
       lugar = new DefaultTreeNode(idLugar, null);
       TreeNode act = new DefaultTreeNode(descripcion, lugar);
    }
    
   

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(String fechaIni) {
        this.fechaIni = fechaIni;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getHoraIni() {
        return horaIni;
    }

    public void setHoraIni(String horaIni) {
        this.horaIni = horaIni;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public TreeNode getLugar() {
        return lugar;
    }

    public void setLugar(TreeNode lugar) {
        this.lugar = lugar;
    }

    public String getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(String idLugar) {
        this.idLugar = idLugar;
    }

    
   

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Actividad other = (Actividad) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }
}
