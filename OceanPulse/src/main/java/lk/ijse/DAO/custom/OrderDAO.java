package lk.ijse.DAO.custom;

import lk.ijse.DAO.SuperDAO;
import lk.ijse.db.Dbconnection;
import lk.ijse.dto.tm.AddTm;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public interface OrderDAO extends SuperDAO {
    public boolean saveOrder(String o_Id, LocalDate date, String c_id, String s_id) throws SQLException, ClassNotFoundException;
    public  String generateNextOrderId() throws SQLException, ClassNotFoundException;
    String getNextId(String currentId);
    boolean saveOrderDetails(List<AddTm> list, String oId) throws SQLException, ClassNotFoundException;
}
