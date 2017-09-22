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
import javax.faces.model.SelectItem;

/**
 *
 * @author luis.leon
 */
@ManagedBean
@SessionScoped
public class LineTimeBean {

    private List<ActividadLineTime> actividades;
    private List<ActividadView> actividadesView;
    private List<Lugar> gamePlaces;
    private LugarView lugarViewSelected;
    private List<String> ids;
    private List<String> codes;

    private int idAct = 0;
    private int idView = 0;
    //Combos
    private ArrayList<SelectItem> itemsPlaces;
    private String v_select_lugar, v_select_place_change;

    private ArrayList<SelectItem> itemsLine;
    private String v_select_line;

    //Insertar
    private ActividadLineTime actInsert;
    private ActividadLineTime actEdit;

    @PostConstruct
    public void init() {

        // actividades =createAct();
        //actividadesView=actOrderBy(actividades);
        actividades = new ArrayList<>();
        actividadesView=new ArrayList<>();
        ids = new ArrayList<>();
        codes = new ArrayList<>();
        v_select_line = "";
        gamePlaces = loadPlaces();
        lugarViewSelected = new LugarView();
        itemsPlaces = Consultar_Lugares_combo();
        actInsert = new ActividadLineTime();
        actEdit = new ActividadLineTime();
        lugarViewSelected = new LugarView();

    }

    public List<ActividadView> actOrderBy(List<ActividadLineTime> actividades) {
        List<ActividadView> actividadesView = new ArrayList<ActividadView>();
        for (ActividadLineTime act : actividades) {
            if (actividadesView.isEmpty()) {
                actividadesView.add(createActividadView(act));

            } else {
                boolean flag = false;
                int index = 0;
                for (ActividadView actividadview : actividadesView) {
                    //actividadview.getCodigo().trim().equalsIgnoreCase(act.getCodigo().trim())&&
                    if (actividadview.getFechaFin().trim().equalsIgnoreCase(act.getFechaFin().trim())
                            && actividadview.getFechaIni().trim().equalsIgnoreCase(act.getFechaIni().trim())
                            && actividadview.getHoraFin().trim().equalsIgnoreCase(act.getHoraFin().trim())
                            && actividadview.getHoraIni().trim().equalsIgnoreCase(act.getHoraIni().trim())) {
                        //Logica
                        LugarView lugarview = new LugarView();
                        lugarview.setDescripActividad(act.getDescripcion());
                        // lugarview.setDescripLugar("Salon");
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

    public ActividadView createActividadView(ActividadLineTime act) {
        ActividadView actividadView = new ActividadView();
        actividadView.setCodigo("");
        actividadView.setFechaFin(act.getFechaFin());
        actividadView.setFechaIni(act.getFechaIni());
        actividadView.setHoraFin(act.getHoraFin());
        actividadView.setHoraIni(act.getHoraIni());

        //Creo el Lugar
        LugarView lugarview = new LugarView();
        lugarview.setDescripActividad(act.getDescripcion());

        lugarview.setIdActividad(act.getId());
        lugarview.setIdLugar(act.getIdLugar());
        actividadView.getLugaresView().add(lugarview);

        return actividadView;
    }

    public void changePlace() {

        //tengo el lugarview, con el id de la actividad la cambio en la lista principal de actividades
        int index = 0;
        for (ActividadLineTime act : actividades) {
            if (act.getId().equalsIgnoreCase(lugarViewSelected.getIdActividad())) {

                actividades.get(index).setDescripcion(actEdit.getDescripcion());

                if (!registroExistente(actEdit, v_select_place_change)) {

                    actEdit.setIdLugar(v_select_place_change);
                    actividades.remove(index);
                    actividades.add(actEdit);

                }
            }
            index++;
        }
        clear();

        v_select_place_change = "";
    }

    public void changeEdit() {

        if (!(v_select_line == null) && (v_select_line.length() > 0)) {
            for (int i = 0; i < actividadesView.size(); i++) {
                if (actividadesView.get(i).getId().equalsIgnoreCase(v_select_line)) {

                    actEdit.setHoraIni(actividadesView.get(i).getHoraIni());
                    actEdit.setHoraFin(actividadesView.get(i).getHoraFin());
                    actEdit.setFechaIni(actividadesView.get(i).getFechaIni());
                    actEdit.setFechaFin(actividadesView.get(i).getFechaFin());
                    v_select_line = "";

                }

            }
        }

    }

    public void insertAct() {
        //inserto en la lista de actividades normal.
        idAct++;
        actInsert.setIdLugar(v_select_lugar);
        actInsert.setId(String.valueOf(idAct));
        v_select_lugar = "";
        if (!registroExistente(actInsert, actInsert.getIdLugar())) {

            actividades.add(actInsert);
        }
        clear();

    }

    public void setEdit(LugarView lugar) {
        lugarViewSelected = lugar;
        for (ActividadLineTime act : actividades) {
            if (act.getId().equalsIgnoreCase(lugarViewSelected.getIdActividad())) {

                actEdit.setId(act.getId());

                actEdit.setDescripcion(act.getDescripcion());
                actEdit.setFechaFin(act.getFechaFin());
                actEdit.setFechaIni(act.getFechaIni());
                actEdit.setHoraFin(act.getHoraFin());
                actEdit.setHoraIni(act.getHoraIni());
                actEdit.setIdLugar(act.getIdLugar());

                v_select_place_change = act.idLugar;

            }
        }

    }

    public boolean registroExistente(ActividadLineTime actividadLine, String lugar) {
        System.out.println("Entro a registro existente");
        for (ActividadLineTime act : actividades) {

            if (actividadLine.getFechaFin().trim().equalsIgnoreCase(act.getFechaFin().trim())
                    && actividadLine.getFechaIni().trim().equalsIgnoreCase(act.getFechaIni().trim())
                    && actividadLine.getHoraFin().trim().equalsIgnoreCase(act.getHoraFin().trim())
                    && actividadLine.getHoraIni().trim().equalsIgnoreCase(act.getHoraIni().trim())
                    && lugar.trim().equalsIgnoreCase(act.getIdLugar().trim())) {

                return true;

            }
        }

        return false;
    }

    public void clear() {
        getIdCode();
        actividadesView = actOrderBy(actividades);
        
        setIdCode();
        ids = new ArrayList<>();
        codes = new ArrayList<>();
        insertarID();
        itemsLine = new ArrayList<SelectItem>();
        itemsLine = loadLine();
        gamePlaces = loadPlaces();
        lugarViewSelected = new LugarView();
        itemsPlaces = Consultar_Lugares_combo();
        actInsert = new ActividadLineTime();
        actEdit = new ActividadLineTime();

    }

    public void insertarID() {
        for (int i = 0; i < actividadesView.size(); i++) {
            actividadesView.get(i).setId(String.valueOf(i));
        }

    }

    public ArrayList<SelectItem> loadLine() {

        ArrayList<SelectItem> items = new ArrayList<SelectItem>();
        for (ActividadView obj : actividadesView) {

            items.add(new SelectItem(obj.getId(), obj.getId()));
        }
        return items;

    }

    public List<Lugar> loadPlaces() {
        List<Lugar> places = new ArrayList<Lugar>();
        places.add(new Lugar("1", "Salon"));
        places.add(new Lugar("2", "Blogger"));
        places.add(new Lugar("3", "Facebook"));
        return places;
    }

    public void getIdCode() {

        for (ActividadView act : actividadesView) {
            codes.add(act.getCodigo());
             ids.add(act.getId());
        }
    }

    
    
    public void setIdCode(){
        for(int i =0 ;i < actividadesView.size();i++){
            for(int j =0 ;j < ids.size();j++){
                if(actividadesView.get(i).getId().equalsIgnoreCase(ids.get(j))){
                    actividadesView.get(i).setCodigo(codes.get(j));
                }
            }
        }
    }

    public ArrayList<SelectItem> Consultar_Lugares_combo() {

        ArrayList<SelectItem> items = new ArrayList<SelectItem>();
        for (Lugar obj : gamePlaces) {

            items.add(new SelectItem(obj.getId(), obj.getDescripcion()));
        }
        return items;
    }

    public List<Lugar> getGamePlaces() {
        return gamePlaces;
    }

    public void setGamePlaces(List<Lugar> gamePlaces) {
        this.gamePlaces = gamePlaces;
    }

    public List<ActividadLineTime> getActividades() {
        return actividades;
    }

    public void setActividades(List<ActividadLineTime> actividades) {
        this.actividades = actividades;
    }

    public List<ActividadView> getActividadesView() {
        return actividadesView;
    }

    public void setActividadesView(List<ActividadView> actividadesView) {
        this.actividadesView = actividadesView;
    }

    public LugarView getLugarViewSelected() {
        return lugarViewSelected;
    }

    public void setLugarViewSelected(LugarView lugarViewSelected) {
        this.lugarViewSelected = lugarViewSelected;
    }

    public ArrayList<SelectItem> getItemsPlaces() {
        return itemsPlaces;
    }

    public void setItemsPlaces(ArrayList<SelectItem> itemsPlaces) {
        this.itemsPlaces = itemsPlaces;
    }

    public String getV_select_lugar() {
        return v_select_lugar;
    }

    public void setV_select_lugar(String v_select_lugar) {
        this.v_select_lugar = v_select_lugar;
    }

    public ActividadLineTime getActInsert() {
        return actInsert;
    }

    public void setActInsert(ActividadLineTime actInsert) {
        this.actInsert = actInsert;
    }

    public String getV_select_place_change() {
        return v_select_place_change;
    }

    public void setV_select_place_change(String v_select_place_change) {
        this.v_select_place_change = v_select_place_change;
    }

    public int getIdAct() {
        return idAct;
    }

    public void setIdAct(int idAct) {
        this.idAct = idAct;
    }

    public ActividadLineTime getActEdit() {
        return actEdit;
    }

    public void setActEdit(ActividadLineTime actEdit) {
        this.actEdit = actEdit;
    }

    public int getIdView() {
        return idView;
    }

    public void setIdView(int idView) {
        this.idView = idView;
    }

    public ArrayList<SelectItem> getItemsLine() {
        return itemsLine;
    }

    public void setItemsLine(ArrayList<SelectItem> itemsLine) {
        this.itemsLine = itemsLine;
    }

    public String getV_select_line() {
        return v_select_line;
    }

    public void setV_select_line(String v_select_line) {
        this.v_select_line = v_select_line;
    }

}


 /*public List<ActividadLineTime> createAct() {
        List<ActividadLineTime> list = new ArrayList<>();
        list.add(new ActividadLineTime("1", "PRE", "06/05/2017", "06/05/2018", "8:00pm", "29:00", "Correr", "1", "Correr en el parque"));
        list.add(new ActividadLineTime("2", "PRE", "06/05/2017", "06/05/2018", "8:00pm", "29:00", "Trotar", "2", "Trotar en el puesto por 30 segundos"));
        list.add(new ActividadLineTime("3", "P1C", "08/05/2017", "08/05/2018", "5:00pm", "22:00", "saltar", "2", "Saltar lazo 30 rep"));
        //list.add(new ActividadLineTime("PRE", "06/05/2017", "06/05/2018", "8:00pm", "29:00", "Publicar", "3", "Publciar en FBK"));
        //list.add(new ActividadLineTime("P1C", "08/05/2017", "08/05/2018", "5:00pm", "22:00", "Caminar","1", "Saltar lazo 30 rep"));
        return list;
    }*/
