package lk.ijse.DAO;

import lk.ijse.entity.Driver;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DriverDAOimpl implements DriverDAO {
    @Override
    public boolean save(Driver driver) throws SQLException, ClassNotFoundException {
        /*Connection connection = Dbconnection.getInstance().getConnection();;
        String sql = "INSERT INTO driver VALUES(?,?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,dto.getId());
        pstm.setString(2,dto.getName());
        pstm.setString(3,dto.getAddress());
        pstm.setString(4,dto.getContact());
        pstm.setString(5,dto.getExperience());
        return pstm.executeUpdate()>0;*/
        return SQLUtil.execute("INSERT INTO driver VALUES(?,?,?,?,?)",driver.getId(),driver.getName(),driver.getAddress(),driver.getContact(),driver.getExperience());
    }
    @Override
    public boolean update(Driver driver) throws SQLException, ClassNotFoundException {
        /*Connection connection = Dbconnection.getInstance().getConnection();
        String sql = "UPDATE driver SET name = ? , address = ? , contact = ?, experience = ? WHERE d_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, dto.getName());
        pstm.setString(2, dto.getAddress());
        pstm.setString(3, dto.getContact());
        pstm.setString(4, dto.getExperience());
        pstm.setString(5, dto.getId());
        return pstm.executeUpdate() > 0;*/
        return SQLUtil.execute("UPDATE driver SET name = ? , address = ? , contact = ?, experience = ? WHERE d_id = ?",driver.getName(),driver.getAddress(),driver.getContact(),driver.getExperience(),driver.getId());
    }
    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
       /* Connection connection = Dbconnection.getInstance().getConnection();
        String sql = "DELETE FROM driver WHERE d_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,id);
        return pstm.executeUpdate()>0;*/
        return SQLUtil.execute("DELETE FROM driver WHERE d_id = ?",id);
    }
    @Override
    public Driver searchAll(String id) throws SQLException, ClassNotFoundException {
        /*Connection connection = Dbconnection.getInstance().getConnection();
        String sql = "SELECT * FROM driver WHERE d_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,id);
        ResultSet rs = pstm.executeQuery();
        DriverDto dto = null;
        if (rs.next()){
            String d_id = rs.getString(1);
            String d_name = rs.getString(2);
            String d_contact = rs.getString(3);
            String d_address = rs.getString(4);
            String d_experience = rs.getString(5);

            dto = new DriverDto(d_id,d_name,d_address,d_contact,d_experience);
        }
        return  dto;*/
        ResultSet rs = SQLUtil.execute("SELECT * FROM driver WHERE d_id = ?",id);
        Driver driver = null;

        if (rs.next()) {
            driver = new Driver(rs.getString("d_id"), rs.getString("name"), rs.getString("address"), rs.getString("contact"),rs.getString("experience"));
        }

        return driver;
    }
    @Override
    public List<Driver> getAll() throws SQLException, ClassNotFoundException {
        /*Connection connection = Dbconnection.getInstance().getConnection();
        String sql = "SELECT * FROM driver";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        //emty arraylist ekak hdagnnwa dto objects save krgnna
        List<DriverDto> dtoList = new ArrayList<>();

        while (rs.next()){
            String d_id = rs.getString(1);
            String d_name = rs.getString(2);
            String d_contact = rs.getString(3);
            String d_address = rs.getString(4);
            String d_experience = rs.getString(5);

            dtoList.add(new DriverDto(d_id,d_name,d_contact,d_address,d_experience));
        }
        return dtoList; //arraylist athuwa list ekakin return klma list interface eke one ekak ekka wda krnna pluwn
*/      ResultSet rs = SQLUtil.execute("SELECT * FROM driver");
        ArrayList<Driver> getAllDriver = new ArrayList<>();
        while (rs.next()){
            Driver driver = new Driver(rs.getString("d_id"), rs.getString("name"),rs.getString("address"),rs.getString("contact"),rs.getString("experience"));
            getAllDriver.add(driver);
        }
        return getAllDriver;
    }
}
