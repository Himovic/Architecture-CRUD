package ServicesMap;

import Constants.Constants;
import Functions.ImplementCrudServices;

import Models.*;

import java.util.List;

public abstract class AbstractMapService<T,REF> {

    List findAll(T t) {
        try{
            if(t instanceof Machine){
                return ImplementCrudServices.implementFindAll(Constants.MACHINE_DB_NAME);
            }else if(t instanceof Pieces){
                return ImplementCrudServices.implementFindAll(Constants.PIECE_DB_NAME);
            }else if(t instanceof ReferencePiece){
                return ImplementCrudServices.implementFindAll(Constants.REFERENCE_PIECE_DB_NAME);
            }else if(t instanceof Stockouts){
                return ImplementCrudServices.implementFindAll(Constants.STOCKOUTS_DB_NAME);
            }else if(t instanceof TransactionPiece){
                return ImplementCrudServices.implementFindAll(Constants.TRANSACTION_DB_NAME);
            }else {
                return null;
            }
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    T findByRef(REF ref,Class<T> tClass){
        Object returnObj = ImplementCrudServices.implementFindByRef(ref,tClass);
        return (T) returnObj;
    }

    T save(T object,Class<T> tClass){
        Object returnObj = ImplementCrudServices.implementSave(object,tClass);
        return (T) returnObj;
    }

    boolean delete(T object,Class<T> tClass){
        return ImplementCrudServices.implementDelete(object,tClass);
    }

    boolean update(T newObject, Class<T> tClass){
        return ImplementCrudServices.implementUpdateObject(newObject,tClass);
    }
}
