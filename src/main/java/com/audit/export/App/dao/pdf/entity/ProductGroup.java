package com.audit.export.App.dao.pdf.entity;
import java.util.List;
public class ProductGroup {
    private int pgNumber;
    private String pgName;
    List<Article> articles;
    public ProductGroup(int pgNumber, String pgName, List<Article> articles) {
        this.pgNumber = pgNumber;
        this.pgName = pgName;
        this.articles = articles;
    }
    public int getPgNumber() {
        return pgNumber;
    }
    public void setPgNumber(int pgNumber) {
        this.pgNumber = pgNumber;
    }
    public String getPgName() {
        return pgName;
    }
    public void setPgName(String pgName) {
        this.pgName = pgName;
    }
    public List<Article> getArticles() {
        return articles;
    }
    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
    @Override
    public String toString() {
        return "ProductGroup{" +
                "pgNumber=" + pgNumber +
                ", pgName='" + pgName + '\'' +
                ", articles=" + articles +
                '}';
    }
}