/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import dao.GrupDAO;
import entity.Grup;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author BARSAN
 */
@FacesConverter(value="GrupConverter")
public class GrupConverter implements Converter{

    private GrupDAO grupDAO;
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getGrupDAO().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object arg2) {
        Grup t=(Grup) arg2;
        return t.getGrupid().toString();
    }

    public GrupDAO getGrupDAO() {
        if (this.grupDAO==null) 
            this.grupDAO=new GrupDAO();
        return grupDAO;
    }

    public void setGrupDAO(GrupDAO grupDAO) {
        this.grupDAO = grupDAO;
    }
    
}
