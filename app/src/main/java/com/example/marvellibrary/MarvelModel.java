package com.example.marvellibrary;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

public class MarvelModel {

    private int code;
    private String status;
    private String copyright;
    private DataModel data;

    public MarvelModel() {}

    public MarvelModel(int code, String status, String copyright, DataModel data) {
        this.code = code;
        this.status = status;
        this.copyright = copyright;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public DataModel getData() {
        return data;
    }

    public void setData(DataModel data) {
        this.data = data;
    }

    public static DataModel parseJSON(String response){
        Gson gson = new GsonBuilder().create();
        DataModel data = gson.fromJson(response, DataModel.class);
        return data;
    }
}
