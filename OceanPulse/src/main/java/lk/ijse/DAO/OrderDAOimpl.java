package lk.ijse.DAO;

import lk.ijse.db.Dbconnection;
import lk.ijse.dto.tm.AddTm;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;


public class OrderDAOimpl implements OrderDAO{
    public  boolean saveOrder(String o_Id, LocalDate date,  String c_id, String s_id) throws SQLException, ClassNotFoundException {
        /*Connection connection = Dbconnection.getInstance().getConnection();

        String sql = "INSERT INTO orders VALUES(?, ?, ?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, o_Id);
        pstm.setDate(2, Date.valueOf(date));
        pstm.setString(3,c_id);
        pstm.setString(4,s_id);

        return pstm.executeUpdate() > 0;*/
        String sql = "INSERT INTO orders VALUES(?, ?, ?,?)";
        return SQLUtil.execute(sql, o_Id, Date.valueOf(date), c_id, s_id);

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
        ResultSet resultSet = SQLUtil.execute("SELECT o_id FROM orders ORDER BY o_id DESC LIMIT 1");

        if (resultSet.next()) {
            return getNextId(resultSet.getString("o_id"));
        } else {
            return getNextId(null);
        }
    }

    public String getNextId(String currentId) {
        if (currentId!= null){
            String numericPart = currentId.substring(1);
            int numericValue = Integer.parseInt(numericPart);
            numericValue++;
            String nextStockId = String.format("R%03d", numericValue);
            return nextStockId;
        }
        else {
            return "R001";
        }
    }


    public boolean saveOrderDetails(List <AddTm> list , String o_id) throws SQLException, ClassNotFoundException {

        for (AddTm item : list){
            if (!saveDetails(o_id,item.getId(), item.getQty())){
                return  false;
            }
        }

        return  true;
    }

    private boolean saveDetails(String oId, String id, int qty) throws SQLException, ClassNotFoundException {
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
