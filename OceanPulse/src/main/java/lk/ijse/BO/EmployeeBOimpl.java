package lk.ijse.BO;

import lk.ijse.DAO.DAOFactory;
import lk.ijse.DAO.EmployeeDAO;
import lk.ijse.dto.EmployeeDto;
import lk.ijse.entity.Employee;

import java.sql.SQLException;
import java.util.List;

public class EmployeeBOimpl implements EmployeeBO {
    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getDAO(DAOFactory.DAOTypes.EMPLOYEE);
    @Override
    public boolean save(EmployeeDto employee) throws SQLException, ClassNotFoundException {
       return employeeDAO.save(new Employee(employee.getId(),employee.getName(),employee.getAddress(),employee.getContact()));
    }
    @Override
    public Employee searchAll(String id) throws SQLException, ClassNotFoundException {
        return employeeDAO.searchAll(id);
    }
    @Override
    /*public boolean update(EmployeeDto employee) throws SQLException, ClassNotFoundException {
        return employeeDAO.update(new Employee(employee.getName(),employee.getContact(),employee.getAddress(),employee.getId()));
    }*/
    public boolean update(EmployeeDto employee) throws SQLException, ClassNotFoundException {
        return employeeDAO.update(new Employee(employee.getId(), employee.getName(), employee.getAddress(), employee.getContact()));
    }
    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return employeeDAO.delete(id);
    }
    @Override
    public List<Employee> getAll() throws SQLException, ClassNotFoundException {
        return employeeDAO.getAll();
    }
}
