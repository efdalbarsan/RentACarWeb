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
public class SehirController implements Serializable {

    private List<Sehir> clist;
    private SehirDAO adao;

    private int page = 1;
    private int pageSize = 5;
    private int pageCount;

    public void next() {
        if (this.page == this.getPageCount()) {
            this.page = 1;
        } else {
            this.page++;
        }
    }

    public void previous() {
        if (this.page == 1) {
            this.page = this.getPageCount();
        } else {
            this.page--;
        }
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount = (int) Math.ceil(this.getAdao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public SehirController() {
    }

    private Sehir sehir;

    public void updateForm(Sehir sehir) {
        this.sehir = sehir;//Guncellemek istedigimiz nesneyi sehircontroller bean nin sehir nesnesine atama islemini yaptik.
    }

    public void clearForm() {
        this.sehir = new Sehir();
    }

    public String index() {
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

    public void modify() {
        this.getAdao().update(this.sehir);
        clearForm();
    }

    public void create() {
        this.getAdao().create(this.sehir);
        clearForm();
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

    public List<Sehir> getClist() {
        this.clist = this.getAdao().read(page, pageSize);
        return this.clist;
    }

    public List<Sehir> getCilist() {
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

}
