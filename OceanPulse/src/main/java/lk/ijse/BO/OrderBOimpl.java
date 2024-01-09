package lk.ijse.BO;

import lk.ijse.DAO.DAOFactory;
import lk.ijse.DAO.DriverDAO;
import lk.ijse.DAO.OrderDAO;
import lk.ijse.DAO.SQLUtil;
import lk.ijse.db.Dbconnection;

import java.sql.*;
import java.time.LocalDate;

public class OrderBOimpl implements OrderBO{
    OrderDAO orderDAO = (OrderDAO) DAOFactory.getDAO(DAOFactory.DAOTypes.ORDERS);
    public  boolean saveOrder(String o_Id, LocalDate date,  String c_id, String s_id) throws SQLException, ClassNotFoundException {
        /*Connection connection = Dbconnection.getInstance().getConnection();

        String sql = "INSERT INTO orders VALUES(?, ?, ?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, o_Id);
        pstm.setDate(2, Date.valueOf(date));
        pstm.setInt(3,qty);
        pstm.setString(4,c_id);
        pstm.setString(5,s_id);

        return pstm.executeUpdate() > 0;*/
        return orderDAO.saveOrder(o_Id, Date.valueOf(date).toLocalDate(), c_id, s_id);
    }

    public String generateNextOrderId() throws SQLException, ClassNotFoundException {
        /*Connection connection = Dbconnection.getInstance().getConnection();
        String sql = "SELECT o_id FROM orders ORDER BY o_id DESC LIMIT 1";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            return getNextId(  resultSet.getString(1));
        }
        return getNextId(null);*/
        return orderDAO.generateNextOrderId();


    }

    public String getNextId(String currentId) {
        /*if (currentId!= null){
            String numericPart = currentId.substring(1);
            int numericValue = Integer.parseInt(numericPart);
            numericValue++;
            String nextStockId = String.format("R%03d", numericValue);
            return nextStockId;
        }
        else {
            return "R001";
        }*/
        return orderDAO.getNextId(currentId);
    }

    public boolean saveOrderDetails(String oId, String id, int qty) throws SQLException, ClassNotFoundException {
        /*Connection connection = Dbconnection.getInstance().getConnection();
        String sql = "INSERT INTO order_manage_details VALUES(?, ?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, oId);
        pstm.setString(2, id);
        pstm.setInt(3,qty);



        return pstm.executeUpdate() > 0;*/
        String sql = "INSERT INTO order_manage_details VALUES(?, ?,?)";
        return SQLUtil.execute(sql,oId,id,qty);
    }
}
