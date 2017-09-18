/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.uniajc.ARG;

import java.io.Serializable;

/**
 *
 * @author luis.leon
 */
public class ActividadLineTime implements Serializable{
     private static final long serialVersionUID = 1L;
    public String codigo;
    public String fechaIni;
    public String fechaFin;
    public String horaIni;
    public String horaFin;
    public String idLugar;
    public String descripcion;
    public String detalle;
    public boolean notificacion;
    public String id;
    //public TreeNode lugar;

    public ActividadLineTime() {
    
    }

    public ActividadLineTime(String descripcion, String codigo) {
        this.descripcion = descripcion;
        this.codigo=codigo;
    }
    
    
    public ActividadLineTime(String id,String codigo, String fechaIni, String fechaFin, String horaIni, String horaFin , String nombreAct, String idLugar,String detalle) {
       this.id=id;
        this.codigo=codigo;
       this.fechaIni=fechaIni;
       this.fechaFin=fechaFin;
       this.horaIni=horaIni;
       this.horaFin=horaFin;
       this.idLugar=idLugar;
       this.descripcion=nombreAct;
       this.detalle=detalle;
       
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

   

    public String getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(String idLugar) {
        this.idLugar = idLugar;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public boolean isNotificacion() {
        return notificacion;
    }

    public void setNotificacion(boolean notificacion) {
        this.notificacion = notificacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
    
   

   
    
}
