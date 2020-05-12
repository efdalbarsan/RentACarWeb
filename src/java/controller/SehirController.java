/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SehirDAO;
import entity.Sehir;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Barsan
 */
@Named
@SessionScoped
public class SehirController implements Serializable{
     private List<Sehir> clist;
    private SehirDAO adao;

    public SehirController() {
    }

    private Sehir sehir;

    public void updateForm(Sehir sehir) {
        this.sehir = sehir;//Guncellemek istedigimiz nesneyi sehircontroller bean nin sehir nesnesine atama islemini yaptik.
    }

    public void clearForm() {
        this.sehir = new Sehir();        
    }
    public String index(){
        clearForm();
        return "index";
    }
   
    public void deleteConfirm(Sehir sehir) {
        this.sehir = sehir;
    }

    public void delete() {
        this.getAdao().delete(this.sehir);
        clearForm();
    }

    public void update() {
        this.getAdao().update(this.sehir);
    }

    public void create() {
        this.getAdao().create(this.sehir);
        clearForm();
    }

    public List<Sehir> getClist() {
        this.clist = this.getAdao().read();
        return this.clist;
    }

    public void setClist(List<Sehir> clist) {
        this.clist = clist;
    }

    public SehirDAO getAdao() {
        if (this.adao == null) {
            this.adao = new SehirDAO();
        }
        return adao;
    }

    public void setAdao(SehirDAO adao) {
        this.adao = adao;
    }

    public Sehir getSehir() {
        if (this.sehir == null) {
            this.sehir = new Sehir();
        }
        return this.sehir;
    }

    public void setSehir(Sehir sehir) {
        this.sehir = sehir;
    }
    
}