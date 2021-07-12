package com.audit.export.App.dao.pdf.entity;

public class ShopData {
    private String title;
    private String value;

    public ShopData(String title, String value) {
        this.title = title;
        this.value = value;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setValue(String value) {
        this.value = value;
    }

    public String getTitle() {
        return title;
    }
    public String getValue() {
        return value;
    }
}
