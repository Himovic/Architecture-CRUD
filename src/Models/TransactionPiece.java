package Models;

import java.util.Date;

public class TransactionPiece {

    private String reference;
    private Pieces piece;
    private Machine machine;
    private Date dateUsing;
    private int quantityUsing;
    private String personFactory;
    private String type;

    public TransactionPiece(){

    }

    public TransactionPiece(Pieces piece, Machine machine, Date dateUsing, int quantityUsing, String personFactory, String type){
        this.piece = piece;
        this.machine = machine;
        this.dateUsing = dateUsing;
        this.quantityUsing = quantityUsing;
        this.personFactory = personFactory;
        this.type = type;
    }

    public TransactionPiece(String reference, Pieces piece, Machine machine, Date dateUsing, int quantityUsing, String personFactory, String type){
        this.reference = reference;
        this.piece = piece;
        this.machine = machine;
        this.dateUsing = dateUsing;
        this.quantityUsing = quantityUsing;
        this.personFactory = personFactory;
        this.type = type;
    }

    public String getReference() {
        return reference;
    }

    public Pieces getPiece() {
        return piece;
    }

    public Machine getMachine() {
        return machine;
    }

    public Date getDateUsing() {
        return dateUsing;
    }

    public int getQuantityUsing() {
        return quantityUsing;
    }

    public String getPersonFactory() {
        return personFactory;
    }

    public String getType() {
        return type;
    }

    public void setPiece(Pieces piece) {
        this.piece = piece;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public void setDateUsing(Date dateUsing) {
        this.dateUsing = dateUsing;
    }

    public void setQuantityUsing(int quantityUsing) {
        this.quantityUsing = quantityUsing;
    }

    public void setPersonFactory(String personFactory) {
        this.personFactory = personFactory;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setId(String reference) {
        this.reference = reference;
    }

    @Override
    public String toString() {
        return "[ Piece : "+piece.getDesignation()+" - Machine : "+machine.getReference()+" - Date : "+dateUsing+" - Quantity : "+quantityUsing+" - Person : "+personFactory+" - Type : "+type+" ]";
    }
}
