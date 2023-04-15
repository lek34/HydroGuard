package com.example.hydroguard.model;


import androidx.annotation.Size;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;
import io.realm.annotations.Required;

public class Todolist extends RealmObject{

    @PrimaryKey
    @Size(max = 99999999999L)
    private Integer idtdl;

    @Required
    private String judul;

    @Required
    @Size(max = 200)
    private String pembuat;

    private String deskripsi;


    public Todolist() {
    }

    public Todolist(Integer idtdl, String judul, String pembuat, String deskripsi) {
        this.idtdl = idtdl;
        this.judul = judul;
        this.pembuat = pembuat;
        this.deskripsi = deskripsi;
    }

    public Integer getIdtdl() {
        return idtdl;
    }

    public void setIdtdl(Integer idtdl) {
        this.idtdl = idtdl;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPembuat() {
        return pembuat;
    }

    public void setPembuat(String pembuat) {
        this.pembuat = pembuat;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}
