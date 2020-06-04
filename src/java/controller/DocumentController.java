/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DocumentDao;
import entity.Document;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.Part;

/**
 *
 * @author Barsan
 */
@Named
@SessionScoped
public class DocumentController implements Serializable{
    private Document document;
    private List<Document> documentList;
    private DocumentDao documentDao;
    
    private Part doc;
    
    private final String uploadTo ="C:\\Users\\Barsan\\Desktop\\RentACar-master\\web\\upload\\";
    
    public void upload(){
        try{
            InputStream input = doc.getInputStream();
            File f= new File(uploadTo+doc.getSubmittedFileName());
            Files.copy(input, f.toPath());
            
            document = this.getDocument();
            document.setFilePath(f.getParent());
            document.setFileName(f.getName());
            document.setFileType(doc.getContentType());
            this.getDocumentDao().insert(document);
        }catch( IOException e){
            System.out.println(e.getMessage());
        }
    }

    public String getUploadTo() {
        return uploadTo;
    }
    public void silBilgi(Document document) {
        this.document = document;
    }

    public void sil() {
        this.getDocumentDao().sil(this.document);
        this.document = new Document();

    }

    public Document getDocument() {
        if(this.document == null)
            this.document = new Document();
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public List<Document> getDocumentList() {
        this.documentList = this.getDocumentDao().findAll();
        return documentList;
    }

    public void setDocumentList(List<Document> documentList) {
        this.documentList = documentList;
    }

    public DocumentDao getDocumentDao() {
        if( this.documentDao == null){
            this.documentDao = new DocumentDao();
        }
        return documentDao;
    }

    public void setDocumentDao(DocumentDao documentDao) {
        this.documentDao = documentDao;
    }

    public Part getDoc() {
        return doc;
    }

    public void setDoc(Part doc) {
        this.doc = doc;
    }
    
}
