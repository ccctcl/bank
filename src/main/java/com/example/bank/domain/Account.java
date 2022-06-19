package com.example.bank.domain;

public class Account {

    private Integer id;
    private String name;
    private Integer nameId;
    private Float money;

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

    public void setNameId(Integer nameId) {
        this.nameId = nameId;
    }

    public Integer getNameId() {
        return nameId;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nameId=" + nameId +
                ", money=" + money +
                '}';
    }
}
