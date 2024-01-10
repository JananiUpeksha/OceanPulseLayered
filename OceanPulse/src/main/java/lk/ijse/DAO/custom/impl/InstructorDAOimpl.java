package lk.ijse.DAO.custom.impl;

import lk.ijse.DAO.SQLUtil;
import lk.ijse.DAO.custom.InstructorDAO;
import lk.ijse.dto.InsructorDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InstructorDAOimpl implements InstructorDAO {
    @Override
    public boolean save(InsructorDto insructor) throws SQLException, ClassNotFoundException {
        /*Connection connection = Dbconnection.getInstance().getConnection();;
        String sql = "INSERT INTO instructor VALUES(?,?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,dto.getId());
        pstm.setString(2,dto.getName());
        pstm.setString(3,dto.getAddress());
        pstm.setString(4,dto.getContact());
        pstm.setString(5,dto.getQualification());
        return pstm.executeUpdate()>0;*/
        return SQLUtil.execute("INSERT INTO instructor VALUES(?,?,?,?,?)",insructor.getId(),insructor.getName(),insructor.getAddress(),insructor.getContact(),insructor.getQualification());
    }
    @Override
    public boolean update(InsructorDto insructor) throws SQLException, ClassNotFoundException {
        /*Connection connection = Dbconnection.getInstance().getConnection();
        String sql = "UPDATE instructor SET name = ? , address = ? , contact = ?, qualification = ? WHERE ins_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, dto.getName());
        pstm.setString(2, dto.getAddress());
        pstm.setString(3, dto.getContact());
        pstm.setString(4, dto.getQualification());
        pstm.setString(5, dto.getId());
        return pstm.executeUpdate() > 0;*/
        return SQLUtil.execute("UPDATE instructor SET name = ? , address = ? , contact = ?, qualification = ? WHERE ins_id = ?",insructor.getName(),insructor.getAddress(),insructor.getContact(),insructor.getQualification(),insructor.getId());
    }
    @Override
    public  InsructorDto searchAll(String id) throws SQLException, ClassNotFoundException {
        /*Connection connection = Dbconnection.getInstance().getConnection();
        String sql = "SELECT * FROM instructor WHERE ins_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,id);
        ResultSet rs = pstm.executeQuery();
        InsructorDto dto = null;
        if (rs.next()){
            String ins_id = rs.getString(1);
            String ins_name = rs.getString(2);
            String ins_address = rs.getString(3);
            String ins_contact = rs.getString(4);
            String ins_qualification = rs.getString(5);

            dto = new InsructorDto(ins_id,ins_name,ins_address,ins_contact,ins_qualification);
        }
        return  dto;*/
        ResultSet rs = SQLUtil.execute("SELECT * FROM instructor WHERE ins_id = ?",id);
        InsructorDto insructor = null;

        if (rs.next()) {
            insructor = new InsructorDto(rs.getString("ins_id"), rs.getString("name"), rs.getString("address"), rs.getString("contact"),rs.getString("qualification"));
        }

        return insructor;
    }
    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        /*Connection connection = Dbconnection.getInstance().getConnection();
        String sql = "DELETE FROM instructor WHERE ins_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,id);
        return pstm.executeUpdate()>0;*/
        return SQLUtil.execute("DELETE FROM instructor WHERE ins_id = ?",id);
    }
    @Override
    public List<InsructorDto> getAll() throws SQLException, ClassNotFoundException {
        /*Connection connection = Dbconnection.getInstance().getConnection();
        String sql = "SELECT * FROM instructor";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        List<InsructorDto> dtoList = new ArrayList<>();

        while (rs.next()){
            String i_id = rs.getString(1);
            String i_name = rs.getString(2);
            String i_address = rs.getString(3);
            String i_contact = rs.getString(4);
            String i_qualification = rs.getString(5);

            dtoList.add(new InsructorDto(i_id,i_name,i_address,i_contact,i_qualification));
        }
        return dtoList;
    }*/
        ResultSet rs = SQLUtil.execute("SELECT * FROM instructor");
        ArrayList<InsructorDto> getAllInstructor = new ArrayList<>();
        while (rs.next()){
            InsructorDto instructor = new InsructorDto(rs.getString("ins_id"), rs.getString("name"),rs.getString("address"),rs.getString("contact"),rs.getString("qualification"));
            getAllInstructor.add(instructor);
        }
        return getAllInstructor;
    }
}
