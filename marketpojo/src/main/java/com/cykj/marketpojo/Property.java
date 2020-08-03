package com.cykj.marketpojo;

public class Property {
    private int id;
    private String typeText;
    private String type;
    private String name;
    private  String value;

    public Property(int id, String typeText, String type, String name, String value) {
        this.id = id;
        this.typeText = typeText;
        this.type = type;
        this.name = name;
        this.value = value;
    }

    public Property() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeText() {
        return typeText;
    }

    public void setTypeText(String typeText) {
        this.typeText = typeText;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
