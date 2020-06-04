    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import dao.DocumentDao;
import entity.Document;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author 
 */
@FacesConverter("DocumentConverter")
public class DocumentConverter implements Converter{

    private DocumentDao documentDAO;
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
       return this.getDocumentDAO().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object arg2) {
        Document y=(Document) arg2;
        return y.getId().toString();
    }

    public DocumentDao getDocumentDAO() {
         if (this.documentDAO==null) 
            this.documentDAO=new DocumentDao();
        return documentDAO;
    }
    
}
