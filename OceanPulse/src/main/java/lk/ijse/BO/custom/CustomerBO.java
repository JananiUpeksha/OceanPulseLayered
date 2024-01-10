package lk.ijse.BO.custom;

import lk.ijse.BO.SuperBO;
import lk.ijse.dto.CustomerDto;

import java.sql.SQLException;
import java.util.List;

public interface CustomerBO extends SuperBO {
    boolean save(CustomerDto dto) throws SQLException, ClassNotFoundException;

    CustomerDto searchAll(String id) throws SQLException, ClassNotFoundException;

    boolean update(CustomerDto dto) throws SQLException, ClassNotFoundException;

    boolean delete(String id) throws SQLException, ClassNotFoundException;

    List<CustomerDto> getAll() throws SQLException, ClassNotFoundException;
}
