/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.uniajc.ARG;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luis.leon
 */
public class ActividadView {
    public String codigo;
    public String fechaIni;
    public String fechaFin;
    public String horaIni;
    public String horaFin;
    public List<LugarView> lugaresView;

    public ActividadView() {
        this.lugaresView = new ArrayList<LugarView>();
    }
    
    
    public LugarView getPlace(int index){
        if(lugaresView != null && lugaresView.size()>0 && index < lugaresView.size()){
            return lugaresView.get(index);
        }else
        {
            return new LugarView();
        }
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

    public List<LugarView> getLugaresView() {
        return lugaresView;
    }

    public void setLugaresView(List<LugarView> lugaresView) {
        this.lugaresView = lugaresView;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    

   
    
    
    
    
    
    
    
    
    
    
    
}
