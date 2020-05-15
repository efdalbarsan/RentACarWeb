/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import dao.SehirDAO;
import entity.Sehir;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author BARSAN
 */
@FacesConverter(value="SehirConverter")
public class SehirConverter implements Converter{

    private SehirDAO sehirDAO;
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getSehirDAO().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object arg2) {
        Sehir t=(Sehir) arg2;
        return t.getSehir_id().toString();
    }

    public SehirDAO getSehirDAO() {
        if (this.sehirDAO==null) 
            this.sehirDAO=new SehirDAO();
        return sehirDAO;
    }
    
}
