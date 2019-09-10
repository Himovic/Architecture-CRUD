package Services;

import Models.Pieces;

import java.util.Date;

public interface PiecesService extends CrudService<Pieces,String> {

    Pieces findByDesignation(String designation);
    Pieces findByReference(String reference);
    Pieces findByFloor(String refFloor);
    Pieces findByDate(Date date);
}
