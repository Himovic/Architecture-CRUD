package Functions;

import Models.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ImplementCrudServices {

    public static List implementFindAll(String tableName) {
        ArrayList list = null;
        try{
            Connection cnx = DbManagement.Connect();
            PreparedStatement statement = cnx.prepareStatement("SELECT * FROM "+tableName);
            ResultSet resultSet = statement.getResultSet();
            ResultSetMetaData md = resultSet.getMetaData();
            int columns = md.getColumnCount();
            list = new ArrayList(resultSet.getFetchSize());
            while (resultSet.next()){
                HashMap row = new HashMap(columns);
                for(int i=0;i<columns;i++){
                    row.put(md.getColumnName(i),resultSet.getObject(i));
                }
                list.add(row);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return list;
    }

    public static Object implementSave(Object object,Class t){
        Object obj = null;
        Connection cnx = null;
        try {
            if(t == Machine.class){
                cnx = DbManagement.Connect();
                Machine machine = Resources.cast(object);
                PreparedStatement statement =
                        cnx.prepareStatement
                                ("INSERT INTO Machine(reference,designation,date,price,breakDowns) VALUES(?,?,?,?,?)");
                statement.setString(1,machine.getReference());
                statement.setString(2,machine.getDesignation());
                statement.setDate(3, (java.sql.Date) machine.getDate());
                statement.setDouble(4,machine.getPrice());
                statement.setInt(5,machine.getBreakDowns());
                if(statement.execute()){
                    obj = Resources.cast(machine);
                    return obj;
                }
            }else if(t == Pieces.class){
                cnx = DbManagement.Connect();
                int count = 0;
                Pieces pieces = Resources.cast(object);
                List<ReferencePiece> referencePieces = pieces.getReferences();
                for(int i=0;i<referencePieces.size();i++){
                    PreparedStatement statement = cnx.prepareStatement("INSERT INTO ReferencePiece(reference)VALUES(?)",Statement.RETURN_GENERATED_KEYS);
                    statement.setString(1,referencePieces.get(i).getReference());
                    if(statement.executeUpdate() > 0){
                        ResultSet generatedKey = statement.getGeneratedKeys();
                        if(generatedKey.next()){
                            int ID_REF_PIECE = generatedKey.getInt(1);
                            PreparedStatement addPiece =
                                    cnx.prepareStatement
                                            ("INSERT INTO Pieces(reference,designation,refFloor,date,price,quantity)VALUES(?,?,?,?,?,?)");
                            addPiece.setString(1,referencePieces.get(i).getReference());
                            addPiece.setString(2,pieces.getDesignation());
                            addPiece.setString(3,pieces.getRefFloor());
                            addPiece.setDate(4, (java.sql.Date) pieces.getDate());
                            addPiece.setDouble(5,pieces.getPrice());
                            addPiece.setInt(6,pieces.getQuantity());
                            int confirmAdd = addPiece.executeUpdate();
                            if(confirmAdd > 0){
                                count++;
                            }
                        }
                    }else{
                        obj = null;
                        return obj;
                    }
                }
                if(count == referencePieces.size()){
                    obj = Resources.cast(pieces);
                    return obj;
                }else {
                    obj = null;
                    return obj;
                }
            }else if(t == ReferencePiece.class){
                cnx = DbManagement.Connect();
                ReferencePiece referencePiece = Resources.cast(object);
                String sqlReferencePiece = "INSERT INTO ReferencePiece(reference)VALUES(?)";
                PreparedStatement statRefPiece = cnx.prepareStatement(sqlReferencePiece);
                statRefPiece.setString(1,referencePiece.getReference());
                int confirmAddRefPiece = statRefPiece.executeUpdate();
                if(confirmAddRefPiece > 0){
                    obj = Resources.cast(referencePiece);
                    return obj;
                }else{
                    obj = null;
                    return obj;
                }
            }else if(t == Stockouts.class){
                cnx = DbManagement.Connect();
                Stockouts stockouts = Resources.cast(object);
                String Sql_Stockouts = "INSERT INTO Stockouts(reference,notifyDate,idPiece,confirmAsk)VALUES(?,?,?,?)";
                PreparedStatement statStockOuts = cnx.prepareStatement(Sql_Stockouts);
                statStockOuts.setString(1,stockouts.getReference());
                statStockOuts.setDate(2, (java.sql.Date) stockouts.getNotifyDate());
                statStockOuts.setInt(3,stockouts.getPieces().getId());
                statStockOuts.setInt(4,stockouts.getConfirmAsk());
                int confirmAddStockOuts = statStockOuts.executeUpdate();
                if(confirmAddStockOuts > 0){
                    obj = Resources.cast(stockouts);
                    return obj;
                }else{
                    obj = null;
                    return obj;
                }
            }else if(t == TransactionPiece.class){
                cnx = DbManagement.Connect();
                TransactionPiece transactionPiece = Resources.cast(object);
                String SQL_TRANSACTION = "INSERT INTO TransactionPiece(reference,idPiece,refMachine,dateUsing,quantityUsing,personFactory,type) " +
                        "VALUES(?,?,?,?,?,?,?)";
                PreparedStatement statTransaction = cnx.prepareStatement(SQL_TRANSACTION);
                statTransaction.setString(1,transactionPiece.getReference());
                statTransaction.setInt(2,transactionPiece.getPiece().getId());
                statTransaction.setString(3,transactionPiece.getMachine().getReference());
                statTransaction.setDate(4, (java.sql.Date) transactionPiece.getDateUsing());
                statTransaction.setInt(5,transactionPiece.getQuantityUsing());
                statTransaction.setString(6,transactionPiece.getPersonFactory());
                statTransaction.setString(7,transactionPiece.getType());
                int confirmAddTransaction = statTransaction.executeUpdate();
                if(confirmAddTransaction > 0 ){
                    obj = Resources.cast(transactionPiece);
                    return obj;
                }else {
                    return obj;
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return obj;
    }

    public static Object implementFindByRef(Object ref,Class t){
        Object obj = null;
        String reference = Resources.cast(ref).toString();
        Connection cnx = DbManagement.Connect();
        try {
            if(t == Machine.class){
                String sql = "SELECT * FROM Machine WHERE reference = ?";
                PreparedStatement findMachine = cnx.prepareStatement(sql);
                findMachine.setString(1,reference);
                ResultSet resultSet = findMachine.executeQuery();
                Machine machine = new Machine(
                        resultSet.getString("reference"),
                        resultSet.getString("designation"),
                        resultSet.getDate("date"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("breakDowns"));
                return Resources.cast(machine);
            }else if(t == Pieces.class) {
                String sql = "SELECT * FROM Pieces WHERE reference = ?";
                PreparedStatement findPieces = cnx.prepareStatement(sql);
                findPieces.setString(1,reference);
                ResultSet resultSet = findPieces.executeQuery();
                Pieces piece = new Pieces(
                        new ReferencePiece(resultSet.getString("reference")),
                        resultSet.getString("designation"),
                        resultSet.getString("refFloor"),
                        resultSet.getDate("date"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("quantity"));
                return Resources.cast(piece);
            }else if(t == ReferencePiece.class){
                String sql = "SELECT * FROM ReferencePiece WHERE reference = ?";
                PreparedStatement findRefPiece = cnx.prepareStatement(sql);
                findRefPiece.setString(1,reference);
                ResultSet resultSet = findRefPiece.executeQuery();
                ReferencePiece referencePiece = new ReferencePiece(resultSet.getString("reference"));
                return Resources.cast(referencePiece);
            }else if(t == Stockouts.class){
                String sql = "SELECT * FROM Stockouts WHERE reference = ?";
                PreparedStatement findStockouts = cnx.prepareStatement(sql);
                findStockouts.setString(1,reference);
                ResultSet resultSet = findStockouts.executeQuery();
                String refPiece = resultSet.getString("refPiece");
                Pieces piece = (Pieces) implementFindByRef(refPiece,Pieces.class);
                Stockouts stockouts = new Stockouts(
                        resultSet.getString("reference"),
                        resultSet.getDate("notifyDate"),
                        piece,
                        resultSet.getInt("confirmAsk")
                );
                return Resources.cast(stockouts);
            }else if(t == TransactionPiece.class){
                String sql = "SELECT * FROM TransactionPiece WHERE reference = ?";
                PreparedStatement findTransaction = cnx.prepareStatement(sql);
                findTransaction.setString(1,reference);
                ResultSet resultSet = findTransaction.executeQuery();
                String refPiece = resultSet.getString("refPiece");
                String refMachine = resultSet.getString("refMachine");
                Pieces piece = (Pieces) implementFindByRef(refPiece,Pieces.class);
                Machine machine = (Machine) implementFindByRef(refMachine,Machine.class);
                TransactionPiece transactionPiece = new TransactionPiece(
                        piece,
                        machine,
                        resultSet.getDate("dateUsing"),
                        resultSet.getInt("quantityUsing"),
                        resultSet.getString("personFactory"),
                        resultSet.getString("type")
                );
                return Resources.cast(transactionPiece);
            }else{
                return null;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return obj;
    }

    public static boolean implementDelete(Object object,Class t){
        Connection cnx = DbManagement.Connect();
        try{
            if(t == Machine.class){
                Machine machine = Resources.cast(object);
                String sql = "DELETE FROM Machine WHERE reference = ?";
                PreparedStatement deleteMachine = cnx.prepareStatement(sql);
                deleteMachine.setString(1,machine.getReference());
                return deleteMachine.execute();
            }else if(t == Pieces.class){
                Pieces piece = Resources.cast(object);
                String sql = "DELETE FROM Pieces WHERE designation = ?";
                PreparedStatement deletePieces = cnx.prepareStatement(sql);
                deletePieces.setString(1,piece.getDesignation());
                return deletePieces.execute();
            }else if(t == ReferencePiece.class){
                ReferencePiece referencePiece = Resources.cast(object);
                String sql = "DELETE FROM ReferencePiece WHERE reference = ?";
                PreparedStatement deleteRefPiece = cnx.prepareStatement(sql);
                deleteRefPiece.setString(1,referencePiece.getReference());
                return deleteRefPiece.execute();
            }else if(t == Stockouts.class){
                Stockouts stockouts = Resources.cast(object);
                String sql = "DELETE FROM Stockouts WHERE reference = ?";
                PreparedStatement deleteStockout = cnx.prepareStatement(sql);
                deleteStockout.setString(1,stockouts.getReference());
                return deleteStockout.execute();
            }else if(t == TransactionPiece.class){
                TransactionPiece transactionPiece = Resources.cast(object);
                String sql = "DELETE FROM TransactionPiece WHERE reference = ?";
                PreparedStatement deleteTransaction = cnx.prepareStatement(sql);
                deleteTransaction.setString(1,transactionPiece.getReference());
                return deleteTransaction.execute();
            }
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
        return false;
    }

    public static boolean implementUpdateObject(Object newObject, Class t){
        Connection cnx = DbManagement.Connect();
        try{
            if(t == Machine.class){
                Machine machine = Resources.cast(newObject);
                String sql = "UPDATE Machine SET designation = ?, price = ? WHERE reference = ?";
                PreparedStatement statement = cnx.prepareStatement(sql);
                statement.setString(1,machine.getDesignation());
                statement.setDouble(2,machine.getPrice());
                statement.setString(3,machine.getReference());
                return statement.execute();
            }else if(t == Pieces.class){
                Pieces piece = Resources.cast(newObject);
                String sql = "UPDATE Pieces SET designation = ?, refFloor = ?, price = ?, quantity = ? WHERE reference = ?";
                PreparedStatement statement = cnx.prepareStatement(sql);
                statement.setString(1,piece.getDesignation());
                statement.setString(2,piece.getRefFloor());
                statement.setDouble(3,piece.getPrice());
                statement.setInt(4,piece.getQuantity());
                statement.setString(5,piece.getReference().getReference());
                return statement.execute();
            }else if(t == ReferencePiece.class){
                ReferencePiece referencePiece = Resources.cast(newObject);
                String sql = "UPDATE ReferencePiece SET reference = ? WHERE reference = ?";
                PreparedStatement statement = cnx.prepareStatement(sql);
                statement.setString(1,referencePiece.getReference());
                statement.setString(2,referencePiece.getReference());
                return statement.execute();
            }else {
                return false;
            }
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
}
