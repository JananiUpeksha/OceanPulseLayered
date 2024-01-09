package lk.ijse.DAO;

import lk.ijse.dto.EmployeeDto;
import lk.ijse.dto.InsructorDto;

import java.sql.SQLException;
import java.util.List;

public interface InstructorDAO extends CrudDAO<InsructorDto> {
    boolean save(InsructorDto dto) throws SQLException, ClassNotFoundException;

    boolean update(InsructorDto dto) throws SQLException, ClassNotFoundException;

    InsructorDto searchAll(String id) throws SQLException, ClassNotFoundException;
    boolean delete(String id) throws SQLException, ClassNotFoundException;

    List<InsructorDto> getAll() throws SQLException, ClassNotFoundException;
}
