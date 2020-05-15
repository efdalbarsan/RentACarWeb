package controller;

import dao.FirmaDAO;
import dao.SehirDAO;
import entity.Firma;
import entity.Sehir;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class FirmaController implements Serializable {
@Inject
    private SehirController sehirController;

    private List<Firma> clist;
    private FirmaDAO firmaDAO;
    private List<Sehir> slist;
    private SehirDAO sdao;
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
        this.pageCount = (int) Math.ceil(this.getFirmaDAO().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public FirmaController() {
    }

    private Firma firma;

    public void updateForm(Firma firma) {
        this.firma = firma;//Guncellemek istedigimiz nesneyi firmacontroller bean nin firma nesnesine atama islemini yaptik.
    }

    public void clearForm() {
        this.firma = new Firma();
    }

    public String index() {
        clearForm();
        return "index";
    }

    public void deleteConfirm(Firma firma) {
        this.firma = firma;
    }

    public void delete() {
        this.getFirmaDAO().delete(this.firma);
        clearForm();
    }

    public void modify() {
        this.getFirmaDAO().update(this.firma);
    }

    public void create() {
        this.getFirmaDAO().create(this.firma);
        clearForm();
    }

    public List<Firma> getClist() {
        this.clist = this.getFirmaDAO().read();
        return this.clist;
    }

    public void setClist(List<Firma> clist) {
        this.clist = clist;
    }

    public FirmaDAO getFirmaDAO() {
        if (this.firmaDAO == null) {
            this.firmaDAO = new FirmaDAO();
        }
        return firmaDAO;
    }

    public void setAdao(FirmaDAO firmaDAO) {
        this.firmaDAO = firmaDAO;
    }

    public Firma getFirma() {
        if (this.firma == null) {
            this.firma = new Firma();
        }
        return this.firma;
    }

    public void setFirma(Firma firma) {
        this.firma = firma;
    }

    public SehirController getSehirController() {
        return sehirController;
    }

    public void setSehirController(SehirController sehirController) {
        this.sehirController = sehirController;
    }

    public List<Sehir> getSlist() {
        return slist;
    }

    public void setSlist(List<Sehir> slist) {
        this.slist = slist;
    }

    public SehirDAO getSdao() {
        if(this.sdao == null){
            this.sdao = new SehirDAO();
        }
        return sdao;
    }



}
