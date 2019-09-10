package Models;

import java.util.Date;

public class Stockouts {

    private String reference;
    private Date notifyDate;
    private Pieces pieces;
    private int confirmAsk;

    public Stockouts(){

    }

    public Stockouts(Date notifyDate, Pieces pieces, int confirmAsk){
        this.notifyDate = notifyDate;
        this.pieces = pieces;
        this.confirmAsk = confirmAsk;
    }

    public Stockouts(String reference, Date notifyDate, Pieces pieces, int confirmAsk){
        this.reference = reference;
        this.notifyDate = notifyDate;
        this.pieces = pieces;
        this.confirmAsk = confirmAsk;
    }

    public String getReference() {
        return reference;
    }

    public Date getNotifyDate() {
        return notifyDate;
    }

    public Pieces getPieces() {
        return pieces;
    }

    public int getConfirmAsk() {
        return confirmAsk;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setNotifyDate(Date notifyDate) {
        this.notifyDate = notifyDate;
    }

    public void setPieces(Pieces pieces) {
        this.pieces = pieces;
    }

    public void setConfirmAsk(int confirmAsk) {
        this.confirmAsk = confirmAsk;
    }

    @Override
    public String toString() {
        return "[ Notify Date : "+notifyDate+" - Piece : "+pieces.getDesignation()+" - Confirm Ask : "+confirmAsk+" ]";
    }
}
