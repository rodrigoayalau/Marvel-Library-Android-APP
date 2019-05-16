package com.example.marvellibrary;

import com.google.gson.annotations.SerializedName;

public class MarvelModelDeserealizer {

    private int code;
    private String status;
    private String copyright;
    private int total;
    private String name;
    private String description;
    private String path;
    private String extension;

    public MarvelModelDeserealizer() {}

    public MarvelModelDeserealizer(int code, String status, String copyright, int total, String name, String description, String path, String extension) {
        this.code = code;
        this.status = status;
        this.copyright = copyright;
        this.total = total;
        this.name = name;
        this.description = description;
        this.path = path;
        this.extension = extension;
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

    public int getTotal() { return total; }

    public void setTotal(int total) { this.total = total; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
