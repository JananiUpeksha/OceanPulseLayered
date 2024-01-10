package lk.ijse.BO.custom;

import lk.ijse.BO.SuperBO;
import lk.ijse.dto.DriverDto;

import java.sql.SQLException;
import java.util.List;

public interface DriverBO extends SuperBO {
    boolean save(DriverDto dto) throws SQLException, ClassNotFoundException;

    boolean update(DriverDto dto) throws SQLException, ClassNotFoundException;

    boolean delete(String id) throws SQLException, ClassNotFoundException;

    DriverDto searchAll(String id) throws SQLException, ClassNotFoundException;

    List<DriverDto> getAll() throws SQLException, ClassNotFoundException;
}
