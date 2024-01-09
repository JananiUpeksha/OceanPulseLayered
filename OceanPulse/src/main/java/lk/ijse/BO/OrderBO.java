package lk.ijse.BO;

import lk.ijse.dto.tm.AddTm;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface OrderBO extends SuperBO{
    boolean saveOrder(String o_Id, LocalDate date,  String c_id, String s_id) throws SQLException, ClassNotFoundException;
    public  String generateNextOrderId() throws SQLException, ClassNotFoundException;
    String getNextId(String currentId);
    boolean saveOrderDetails(String oId, String id, int qty) throws SQLException, ClassNotFoundException;
}
