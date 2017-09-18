/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.uniajc.ARG;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author luis.leon
 */
@ManagedBean
@SessionScoped
public class LineTimeBean {

    private List<Actividad> actividades;
    private List<ActividadView> actividadesView;
    private List<Lugar> gamePlaces;

    @PostConstruct
    public void init() {

        actividades = createAct();
        actividadesView = actOrderBy(actividades);
        gamePlaces = loadPlaces();

    }

    public List<Actividad> createAct() {
        List<Actividad> list = new ArrayList<>();
        list.add(new Actividad("1", "06/05/2017", "06/05/2018", "8:00pm", "29:00", "Correr", "1", "Correr en el parque"));
        list.add(new Actividad("2", "06/05/2017", "06/05/2018", "8:00pm", "19:00", "Trotar", "2", "Trotar en el puesto por 30 segundos"));
        list.add(new Actividad("3", "08/05/2017", "08/05/2018", "5:00pm", "22:00", "saltar", "2", "Saltar lazo 30 rep"));
        return list;
    }

    public List<ActividadView> actOrderBy(List<Actividad> actividades) {
        List<ActividadView> actividadesView = new ArrayList<ActividadView>();
        for (Actividad act : actividades) {
            if (actividadesView.isEmpty()) {
                actividadesView.add(createActividadView(act));
            } else {
                boolean flag = false;
                int index = 0;
                for (ActividadView actividadview : actividadesView) {
                    if (actividadview.getFechaFin().equalsIgnoreCase(act.getFechaFin())
                            && actividadview.getFechaIni().equalsIgnoreCase(act.getFechaIni())
                            && actividadview.getHoraFin().equalsIgnoreCase(act.getHoraFin())
                            && actividadview.getHoraIni().equalsIgnoreCase(act.getHoraIni())) {
                        //Logica
                        LugarView lugarview = new LugarView();
                        lugarview.setDescripActividad(act.getDescripcion());
                        lugarview.setDescripLugar("Salon");
                        lugarview.setIdActividad(act.getId());
                        lugarview.setIdLugar(act.getIdLugar());
                        actividadesView.get(index).getLugaresView().add(lugarview);
                        flag = true;

                    }
                    index++;
                }
                if (!flag) {
                    actividadesView.add(createActividadView(act));
                }
            }

        }

        return actividadesView;
    }

    public ActividadView createActividadView(Actividad act) {
        ActividadView actividadView = new ActividadView();
        actividadView.setFechaFin(act.getFechaFin());
        actividadView.setFechaIni(act.getFechaIni());
        actividadView.setHoraFin(act.getHoraFin());
        actividadView.setHoraIni(act.getHoraIni());
        //Creo el Lugar
        LugarView lugarview = new LugarView();
        lugarview.setDescripActividad(act.getDescripcion());
        lugarview.setDescripLugar("Salon");
        lugarview.setIdActividad(act.getId());
        lugarview.setIdLugar(act.getIdLugar());
        actividadView.getLugaresView().add(lugarview);

        return actividadView;
    }

    public List<Lugar> loadPlaces() {
        List<Lugar> places = new ArrayList<Lugar>();
        places.add(new Lugar("1", "Salon"));
        places.add(new Lugar("2", "Blogger"));
        return places;
    }

    public List<Lugar> getGamePlaces() {
        return gamePlaces;
    }

    public void setGamePlaces(List<Lugar> gamePlaces) {
        this.gamePlaces = gamePlaces;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }

    public List<ActividadView> getActividadesView() {
        return actividadesView;
    }

    public void setActividadesView(List<ActividadView> actividadesView) {
        this.actividadesView = actividadesView;
    }

}
