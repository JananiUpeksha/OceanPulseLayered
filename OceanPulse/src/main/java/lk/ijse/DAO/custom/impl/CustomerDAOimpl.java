package lk.ijse.DAO.custom.impl;

import lk.ijse.DAO.SQLUtil;
import lk.ijse.DAO.custom.CustomerDAO;
import lk.ijse.dto.CustomerDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CustomerDAOimpl implements CustomerDAO {
    @Override
    public boolean save(CustomerDto customer) throws SQLException, ClassNotFoundException {
        /*Connection connection = Dbconnection.getInstance().getConnection();;
        String sql = "INSERT INTO customer VALUES(?,?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,dto.getId());
        pstm.setString(2,dto.getName());
        pstm.setString(3,dto.getAddress());
        pstm.setString(4,dto.getContact());
        pstm.setString(5,dto.getNIC());
        return pstm.executeUpdate()>0;*/
        return SQLUtil.execute("INSERT INTO customer VALUES(?,?,?,?,?)",customer.getId(),customer.getName(),customer.getAddress(),customer.getContact(),customer.getNIC());
    }
    @Override
    public CustomerDto searchAll(String id) throws SQLException, ClassNotFoundException {
        /*Connection connection = Dbconnection.getInstance().getConnection();
        String sql = "SELECT * FROM customer WHERE c_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,id);
        ResultSet rs = pstm.executeQuery();
        CustomerDto dto = null;
        if (rs.next()){
            String c_id = rs.getString(1);
            String c_name = rs.getString(2);
            String c_address = rs.getString(3);
            String c_contact = rs.getString(4);
            String c_Nic = rs.getString(5);

            dto = new CustomerDto(c_id,c_name,c_address,c_contact,c_Nic);
        }
        return  dto;*/
        ResultSet rs = SQLUtil.execute("SELECT * FROM customer WHERE c_id = ?",id);
        CustomerDto customer = null;

        if (rs.next()) {
            customer = new CustomerDto(rs.getString("c_id"), rs.getString("name"), rs.getString("address"), rs.getString("contact"),rs.getString("NIC"));
        }

        return customer;
    }
    @Override
    /*public boolean update(CustomerDto customer) throws SQLException, ClassNotFoundException {
        *//*Connection connection = Dbconnection.getInstance().getConnection();
        String sql = "UPDATE customer SET name = ? , address = ? , contact = ?, NIC = ? WHERE c_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, dto.getName());
        pstm.setString(2, dto.getAddress());
        pstm.setString(3, dto.getContact());
        pstm.setString(4, dto.getNIC());
        pstm.setString(5, dto.getId());
        return pstm.executeUpdate() > 0;*//*
        return SQLUtil.execute("UPDATE customer SET name = ? , address = ? , contact = ?, NIC = ? WHERE c_id = ?",customer.getName(),customer.getAddress(),customer.getContact(),customer.getNIC(),customer.getId());
    }*/
    public boolean update(CustomerDto customer) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE customer SET name = ?, address = ?, contact = ?, NIC = ? WHERE c_id = ?";
        return SQLUtil.execute(sql, customer.getName(), customer.getAddress(), customer.getContact(), customer.getNIC(), customer.getId());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        /*Connection connection = Dbconnection.getInstance().getConnection();
        String sql = "DELETE FROM customer WHERE c_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,id);
        return pstm.executeUpdate()>0;*/
        return SQLUtil.execute("DELETE FROM customer WHERE c_id = ?",id);
    }
    @Override
    public List<CustomerDto> getAll() throws SQLException, ClassNotFoundException {
        /*Connection connection = Dbconnection.getInstance().getConnection();
        String sql = "SELECT * FROM customer";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        List<CustomerDto> dtoList = new ArrayList<>();

        while (rs.next()){
            String c_id = rs.getString(1);
            String c_name = rs.getString(2);
            String c_address = rs.getString(3);
            String c_contact = rs.getString(4);
            String c_Nic = rs.getString(5);

            dtoList.add(new CustomerDto(c_id,c_name,c_address,c_contact,c_Nic));
        }
        return dtoList;*/
        ResultSet rs = SQLUtil.execute("SELECT * FROM customer");
        ArrayList<CustomerDto> getAllCustomer = new ArrayList<>();
        while (rs.next()){
            CustomerDto customer = new CustomerDto(rs.getString("c_id"), rs.getString("name"),rs.getString("address"),rs.getString("contact"),rs.getString("NIC"));
            getAllCustomer.add(customer);
        }
        return getAllCustomer;
    }
}
