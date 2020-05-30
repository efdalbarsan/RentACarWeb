/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import dao.AracDAO;
import entity.Arac;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter(value="AracConverter")
public class AracConverter implements Converter{

    private AracDAO aracDAO;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getAracDAO().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object arg2) {
        Arac t = (Arac) arg2;
        return t.getAracid().toString();
    }

    public AracDAO getAracDAO() {
        if (this.aracDAO == null) {
            aracDAO = new AracDAO();
        }
        return aracDAO;
    }

    public void setAracDAO(AracDAO aracDAO) {
        this.aracDAO = aracDAO;
    }

}
