package com.feng.entity;

public class BookTypeEntity {
    //书本类别表
    private Integer id;
    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "BookType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
