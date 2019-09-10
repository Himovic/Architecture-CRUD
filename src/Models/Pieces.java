package Models;

import java.util.Date;
import java.util.List;

public class Pieces {

    private int id;
    private List<ReferencePiece> references;
    private ReferencePiece reference;
    private String designation;
    private String refFloor;
    private Date date;
    private double price;
    private int quantity;

    public Pieces(){

    }

    public Pieces(List<ReferencePiece> references, String designation, String refFloor, Date date, double price, int quantity){
        this.references = references;
        this.designation = designation;
        this.refFloor = refFloor;
        this.date = date;
        this.price = price;
        this.quantity = quantity;
    }

    public Pieces(ReferencePiece reference, String designation, String refFloor, Date date, double price, int quantity){
        this.reference = reference;
        this.designation = designation;
        this.refFloor = refFloor;
        this.date = date;
        this.price = price;
        this.quantity = quantity;
    }

    public Pieces(int id, List<ReferencePiece> references, String designation, String refFloor, Date date, double price, int quantity){
        this.id = id;
        this.references = references;
        this.designation = designation;
        this.refFloor = refFloor;
        this.date = date;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public List<ReferencePiece> getReferences() {
        return references;
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

    public int getQuantity() {
        return quantity;
    }

    public String getRefFloor() {
        return refFloor;
    }

    public ReferencePiece getReference() {
        return reference;
    }

    public void setReferences(List<ReferencePiece> references) {
        this.references = references;
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

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRefFloor(String refFloor) {
        this.refFloor = refFloor;
    }

    public void setReference(ReferencePiece reference) {
        this.reference = reference;
    }

    @Override
    public String toString() {
        return "[ References : "+references.toString()+" - Designation : "+designation+" - Date : "+date+" - Price : "+price+" - Quantity : "+quantity+" ]";
    }

}
