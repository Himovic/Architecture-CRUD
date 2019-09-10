package Models;

public class ReferencePiece {

    private int id;
    private String reference;

    public ReferencePiece(){

    }

    public ReferencePiece(String reference){
        this.reference = reference;
    }

    public ReferencePiece(int id,String reference){
        this.id = id;
        this.reference = reference;
    }

    public int getId() {
        return id;
    }

    public String getReference() {
        return reference;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Override
    public String toString() {
        return "[ ID : "+id+" - Reference : "+reference+" ]";
    }
}
