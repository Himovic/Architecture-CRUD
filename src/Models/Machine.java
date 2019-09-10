package Models;

import java.util.Date;

public class Machine {

    private int id;
    private String reference,designation;
    private Date date;
    private double price;
    private int breakDowns;

    public Machine(){

    }

    public Machine(String reference,String designation,Date date,double price, int breakDowns){
        this.reference = reference;
        this.designation = designation;
        this.date = date;
        this.price = price;
        this.breakDowns = breakDowns;
    }

    public Machine(int id,String reference,String designation,Date date,double price, int breakDowns){
        this.id = id;
        this.reference = reference;
        this.designation = designation;
        this.date = date;
        this.price = price;
        this.breakDowns = breakDowns;
    }

    public int getId() {
        return id;
    }

    public String getReference() {
        return reference;
    }

    public String getDesignation() {
        return designation;
    }

    public Date getDate() {
        return date;
    }

    public double getPrice() {
        return price;
    }

    public int getBreakDowns() {
        return breakDowns;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setBreakDowns(int breakDowns) {
        this.breakDowns = breakDowns;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "[ Reference : "+reference+" - Designation : "+designation+" - Date : "+date+" - Price : "+price+" - Beakdowns : "+breakDowns+" ]";
    }
}
