package lk.ijse.DAO;

import lk.ijse.db.Dbconnection;
import lk.ijse.dto.EmployeeDto;
import lk.ijse.entity.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface EmployeeDAO extends CrudDAO<Employee>{
   /* public boolean save(EmployeeDto dto) throws SQLException, ClassNotFoundException;

    public EmployeeDto searchAll(String id) throws SQLException, ClassNotFoundException;

    public boolean update(EmployeeDto dto) throws SQLException, ClassNotFoundException;

    public boolean delete(String id) throws SQLException, ClassNotFoundException;

    public List<EmployeeDto> getAll() throws SQLException, ClassNotFoundException;*/
}
