package lk.ijse.DAO;

import lk.ijse.entity.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOimpl implements EmployeeDAO {
    @Override
    public boolean save(Employee employee) throws SQLException, ClassNotFoundException {
        /*Connection connection = Dbconnection.getInstance().getConnection();;
        String sql = "INSERT INTO employee VALUES(?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,dto.getId());
        pstm.setString(2,dto.getName());
        pstm.setString(3,dto.getAddress());
        pstm.setString(4,dto.getContact());
        return pstm.executeUpdate()>0;*/
        return SQLUtil.execute("INSERT INTO employee VALUES(?,?,?,?)",employee.getId(),employee.getName(),employee.getAddress(),employee.getContact());
    }
    @Override
    public Employee searchAll(String id) throws SQLException, ClassNotFoundException {
        /*Connection connection = Dbconnection.getInstance().getConnection();
        String sql = "SELECT * FROM employee WHERE e_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,id);
        ResultSet rs = pstm.executeQuery();
        EmployeeDto dto = null;
        if (rs.next()){
            String e_id = rs.getString(1);
            String e_name = rs.getString(2);
            String e_address = rs.getString(3);
            String e_contact = rs.getString(4);

            dto = new EmployeeDto(e_id,e_name,e_address,e_contact);
        }
        return  dto;*/
        ResultSet rs = SQLUtil.execute("SELECT * FROM employee WHERE e_id = ?",id);
        Employee employee = null;

        if (rs.next()) {
            employee = new Employee(rs.getString("e_id"), rs.getString("name"), rs.getString("address"), rs.getString("contact"));
        }

        return employee;
    }
    //@Override
    /*public boolean update(Employee employee) throws SQLException, ClassNotFoundException {
      *//*  Connection connection = Dbconnection.getInstance().getConnection();
        String sql = "UPDATE employee SET name = ? , address = ? , contact = ? WHERE e_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, dto.getName());
        pstm.setString(2, dto.getAddress());
        pstm.setString(3, dto.getContact());
        pstm.setString(4, dto.getId());
        return pstm.executeUpdate() > 0;*//*
        return SQLUtil.execute("UPDATE employee SET name = ? , address = ? , contact = ? WHERE e_id = ?",employee.getName(),employee.getAddress(),employee.getContact(),employee.getId());
    }*/
    @Override
    public boolean update(Employee employee) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE employee SET name = ? , address = ? , contact = ? WHERE e_id = ?", employee.getName(), employee.getAddress(), employee.getContact(), employee.getId());
    }
    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        /*Connection connection = Dbconnection.getInstance().getConnection();
        String sql = "DELETE FROM employee WHERE e_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,id);
        return pstm.executeUpdate()>0;*/
        return SQLUtil.execute("DELETE FROM employee WHERE e_id = ?",id);
    }
    @Override
    public List<Employee> getAll() throws SQLException, ClassNotFoundException {
        /*Connection connection = Dbconnection.getInstance().getConnection();
        String sql = "SELECT * FROM employee";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        List<EmployeeDto> dtoList = new ArrayList<>();

        while (rs.next()){
            String e_id = rs.getString(1);
            String e_name = rs.getString(2);
            String e_address = rs.getString(3);
            String e_contact = rs.getString(4);

            dtoList.add(new EmployeeDto(e_id,e_name,e_address,e_contact));
        }
        return dtoList;
    }*/
        ResultSet rs = SQLUtil.execute("SELECT * FROM employee");
        ArrayList<Employee> getAllEmployee = new ArrayList<>();
        while (rs.next()){
            Employee employee = new Employee(rs.getString("e_id"), rs.getString("name"),rs.getString("address"),rs.getString("contact"));
            getAllEmployee.add(employee);
        }
        return getAllEmployee;
    }
}
