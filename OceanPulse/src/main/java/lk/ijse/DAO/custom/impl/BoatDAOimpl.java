package lk.ijse.DAO.custom.impl;

import lk.ijse.DAO.SQLUtil;
import lk.ijse.DAO.custom.BoatDAO;
import lk.ijse.entity.Boat;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoatDAOimpl implements BoatDAO {
    @Override
    public  boolean save(Boat boat) throws SQLException, ClassNotFoundException {
        /*Connection connection = Dbconnection.getInstance().getConnection();;
        String sql = "INSERT INTO boat VALUES(?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,dto.getId());
        pstm.setString(2,dto.getCapacity());
        pstm.setString(3,dto.getStatus());
        pstm.setString(4,dto.getModel());
        return pstm.executeUpdate()>0;*/
        return SQLUtil.execute("INSERT INTO boat VALUES(?,?,?,?)",boat.getId(),boat.getCapacity(),boat.getStatus(),boat.getModel());
    }

    @Override
    public  Boat searchAll(String id) throws SQLException, ClassNotFoundException {
        /*Connection connection = Dbconnection.getInstance().getConnection();
        String sql = "SELECT * FROM boat WHERE b_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,id);
        ResultSet rs = pstm.executeQuery();
        BoatDto dto = null;
        if (rs.next()){
            String b_id = rs.getString(1);
            String b_capacity = rs.getString(2);
            String b_status = rs.getString(3);
            String b_model = rs.getString(4);

            dto = new BoatDto(b_id,b_capacity,b_status,b_model);
        }
        return  dto;*/

        ResultSet rs = SQLUtil.execute("SELECT * FROM boat WHERE b_id = ?",id);
        Boat boat = null;

        if (rs.next()) {
            boat = new Boat(rs.getString("b_id"), rs.getString("capacity"), rs.getString("status"), rs.getString("model"));
        }

        return boat;
    }
    @Override
    public boolean update(Boat boat) throws SQLException, ClassNotFoundException {
        /*Connection connection = Dbconnection.getInstance().getConnection();
        String sql = "UPDATE boat SET capacity = ? , status = ? , model = ? WHERE b_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, dto.getCapacity());
        pstm.setString(2, dto.getStatus());
        pstm.setString(3, dto.getModel());
        pstm.setString(4, dto.getId());
        return pstm.executeUpdate() > 0;*/
        return SQLUtil.execute("UPDATE boat SET capacity = ? , status = ? , model = ? WHERE b_id = ?",boat.getCapacity(),boat.getStatus(),boat.getModel(),boat.getId());
    }
    @Override
    public  boolean delete(String id) throws SQLException, ClassNotFoundException {
        /*Connection connection = Dbconnection.getInstance().getConnection();
        String sql = "DELETE FROM boat WHERE b_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,id);
        return pstm.executeUpdate()>0;*/
        return SQLUtil.execute("DELETE FROM boat WHERE b_id = ?",id);
    }
    @Override
    public List<Boat> getAll() throws SQLException, ClassNotFoundException {
        /*Connection connection = Dbconnection.getInstance().getConnection();
        String sql = "SELECT * FROM boat";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        List<BoatDto> dtoList = new ArrayList<>();

        while (rs.next()){
            String b_id = rs.getString(1);
            String b_capacity = rs.getString(2);
            String b_status = rs.getString(3);
            String b_model = rs.getString(4);

            dtoList.add(new BoatDto(b_id,b_capacity,b_status,b_model));
        }
        return dtoList;*/
        ResultSet rs = SQLUtil.execute("SELECT * FROM boat");
        ArrayList<Boat> getAllBoat = new ArrayList<>();
        while (rs.next()){
            Boat boat = new Boat(rs.getString("b_id"), rs.getString("capacity"),rs.getString("status"),rs.getString("model"));
            getAllBoat.add(boat);
        }
        return getAllBoat;
    }

}
