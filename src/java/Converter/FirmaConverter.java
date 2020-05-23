/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import dao.FirmaDAO;
import entity.Firma;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Barsan
 */
@FacesConverter("FirmaConverter")
public class FirmaConverter implements Converter{

    private FirmaDAO firmaDAO;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getFirmaDAO().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object arg2) {
        Firma t = (Firma) arg2;
        return t.getFirmaid().toString();
    }

    public FirmaDAO getFirmaDAO() {
        if (this.firmaDAO == null) {
            firmaDAO = new FirmaDAO();
        }
        return firmaDAO;
    }

    public void setFirmaDAO(FirmaDAO firmaDAO) {
        this.firmaDAO = firmaDAO;
    }

}
