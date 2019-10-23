package tests.cucumber.app.dto;

import tests.cucumber.android.utils.TypeChoose;

import java.math.BigDecimal;

public class Article {
    public String name;
    public BigDecimal quantity;
    public String id;
    public BigDecimal price;
    public boolean isAdditional = false;
    public TypeChoose ageRestriction = TypeChoose.EMPTY;
    public boolean isPortion = false ;
    public Article articleAdditional;
    public String noted;
    public String isDeposit;
    public String stringPrice;

    public Article( String id,String name, BigDecimal quantity, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public Article( String name, BigDecimal quantity, BigDecimal price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public Article() {

    }

    public boolean isAdditional() {
        return isAdditional;
    }

    public void setAdditional(boolean additional) {
        isAdditional = additional;
    }

    public Article getArticleAdditional() {
        return articleAdditional;
    }

    public void setArticleAdditional(Article articleAdditional) {
        this.articleAdditional = articleAdditional;
    }




}
