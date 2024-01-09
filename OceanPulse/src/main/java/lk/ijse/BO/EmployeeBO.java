package lk.ijse.BO;

import lk.ijse.dto.EmployeeDto;
import lk.ijse.entity.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeBO extends SuperBO {
    public boolean save(EmployeeDto dto) throws SQLException, ClassNotFoundException;

    public Employee searchAll(String id) throws SQLException, ClassNotFoundException;

    public boolean update(EmployeeDto dto) throws SQLException, ClassNotFoundException;

    public boolean delete(String id) throws SQLException, ClassNotFoundException;

    public List<Employee> getAll() throws SQLException, ClassNotFoundException;
}
