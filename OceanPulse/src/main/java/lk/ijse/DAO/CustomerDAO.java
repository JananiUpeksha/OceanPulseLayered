package lk.ijse.DAO;

import lk.ijse.dto.CustomerDto;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDAO extends CrudDAO<CustomerDto>{
    boolean save(CustomerDto dto) throws SQLException, ClassNotFoundException;

    CustomerDto searchAll(String id) throws SQLException, ClassNotFoundException;

    boolean update(CustomerDto dto) throws SQLException, ClassNotFoundException;

    boolean delete(String id) throws SQLException, ClassNotFoundException;

    List<CustomerDto> getAll() throws SQLException, ClassNotFoundException;
}
