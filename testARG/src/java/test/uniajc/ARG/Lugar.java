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
public class Lugar {
    
    private String id;
    private String Descripcion;
    private String idJuego;

    public Lugar(String id, String Descripcion) {
        this.id = id;
        this.Descripcion = Descripcion;
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(String idJuego) {
        this.idJuego = idJuego;
    }
    
    
    
}
