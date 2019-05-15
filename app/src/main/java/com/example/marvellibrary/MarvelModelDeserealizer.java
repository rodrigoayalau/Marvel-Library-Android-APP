package com.example.marvellibrary;

public class MarvelModelDeserealizer {

    private int code;
    private String status;
    private String copyright;
    private int total;
    private String name;

    public MarvelModelDeserealizer() {}

    public MarvelModelDeserealizer(int code, String status, String copyright, int total, String name) {
        this.code = code;
        this.status = status;
        this.copyright = copyright;
        this.total = total;
        this.name = name;
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
}
