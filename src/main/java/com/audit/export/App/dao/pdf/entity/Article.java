package com.audit.export.App.dao.pdf.entity;
public class Article {
    private int articleNumber;
    private String branch;
    private String mode;
    private String featureText;
    private String multiPack;
    private String pro;
    private String sal;
    private String note;
    public Article(int articleNumber, String branch, String mode, String featureText, String multiPack, String pro, String sal, String note) {
        this.articleNumber = articleNumber;
        this.branch = branch;
        this.mode = mode;
        this.featureText = featureText;
        this.multiPack = multiPack;
        this.pro = pro;
        this.sal = sal;
        this.note = note;
    }
    @Override
    public String toString() {
        return "Article{" +
                "articleNumber=" + articleNumber +
                ", branch='" + branch + '\'' +
                ", mode='" + mode + '\'' +
                ", featureText='" + featureText + '\'' +
                ", multiPack='" + multiPack + '\'' +
                ", pro='" + pro + '\'' +
                ", sal='" + sal + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
    public int getArticleNumber() {
        return articleNumber;
    }
    public void setArticleNumber(int articleNumber) {
        this.articleNumber = articleNumber;
    }
    public String getBranch() {
        return branch;
    }
    public void setBranch(String branch) {
        this.branch = branch;
    }
    public String getMode() {
        return mode;
    }
    public void setMode(String mode) {
        this.mode = mode;
    }
    public String getFeatureText() {
        return featureText;
    }
    public void setFeatureText(String featureText) {
        this.featureText = featureText;
    }
    public String getMultiPack() {
        return multiPack;
    }
    public void setMultiPack(String multiPack) {
        this.multiPack = multiPack;
    }
    public String getPro() {
        return pro;
    }
    public void setPro(String pro) {
        this.pro = pro;
    }
    public String getSal() {
        return sal;
    }
    public void setSal(String sal) {
        this.sal = sal;
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
}