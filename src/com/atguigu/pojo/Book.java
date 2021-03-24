package com.atguigu.pojo;

import java.math.BigDecimal;

public class Book {
    private Integer id;
    private String name;
    private String author;
    private Integer sales;
    private Integer stock;
    private BigDecimal price;
    private String imgPath = "static/img/default.jpg";

    public Book(Integer id, String name, String author, Integer sales, Integer stock, BigDecimal price, String imgPath) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.sales = sales;
        this.stock = stock;
        this.price = price;
        // 图书的封面路径不允许为空
        if (imgPath != null) {
            this.imgPath = imgPath;
        }
    }

    public Book() {
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", sales=" + sales +
                ", stock='" + stock + '\'' +
                ", price=" + price +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        if (imgPath != null) {
            this.imgPath = imgPath;
        }
    }
}
