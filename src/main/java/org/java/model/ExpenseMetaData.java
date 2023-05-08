package org.java.model;

public class ExpenseMetaData {
    private String name;
    private String imgURL;
    private String notes;

    public ExpenseMetaData(String name,String imgURL,String notes){
        this.name=name;
        this.imgURL=imgURL;
        this.notes=notes;
    }

    //getters and setters

    public String getName() {
        return name;
    }

    public String getImgURL() {
        return imgURL;
    }

    public String getNotes() {
        return notes;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}
