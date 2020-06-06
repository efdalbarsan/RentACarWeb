package Validator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

@Named("validator")
@SessionScoped
public class LoginValidator implements Serializable {

    private Collection<FacesMessage> msgList = new ArrayList<>();

    public boolean validateAdi(FacesContext fc, UIComponent uı, Object v) {

        boolean isValid = true;
        msgList.clear();

        String value = (String) v;
        if (value.equals("")) {
            msgList.add(new FacesMessage("Lütfen Adınızı Giriniz ! "));
            isValid = false;
        } else if (value.length() < 3 || value.length() > 50) {
            msgList.add(new FacesMessage("Ad 3'den Küçük 50 den Büyük Olamaz!"));
            isValid = false;
        }

        if (!isValid) {
            throw new ValidatorException(msgList);
        } else {
            return true;
        }

    }

 
    public boolean validateEmaili(FacesContext fc, UIComponent uı, Object v) {
        boolean isValid = true;
        msgList.clear();

        String value = (String) v;
        value = value.trim();

        if (value == null || value.equals("")) {
            msgList.add(new FacesMessage("Lütfen Email Giriniz! "));
            isValid = false;
        } else if (!value.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
            msgList.add(new FacesMessage("Lütfen Email Adresini Düzgün Giriniz! ÖRN:(example@example.com) "));
            isValid = false;
        }

        if (!isValid) {
            throw new ValidatorException(msgList);

        } else {
            return true;
        }
    }

    public boolean validateSifresi(FacesContext fc, UIComponent uı, Object v) {

        boolean isValid = true;
        msgList.clear();

        String value = (String) v;
        if (value.equals("")) {
            msgList.add(new FacesMessage("Lütfen Şifreinizi Giriniz  ! "));
            isValid = false;
        } else if (value.length() < 5) {
            msgList.add(new FacesMessage("Şifreniz En Az 5 Haneli Olmalı!"));
            isValid = false;
        }

        if (!isValid) {
            throw new ValidatorException(msgList);
        } else {
            return true;
        }

    }

    public Collection<FacesMessage> getMsgList() {
        return msgList;
    }

    public void setMsgList(Collection<FacesMessage> msgList) {
        this.msgList = msgList;
    }

}
