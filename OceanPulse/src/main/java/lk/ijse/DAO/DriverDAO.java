package lk.ijse.DAO;

import lk.ijse.db.Dbconnection;
import lk.ijse.dto.BoatDto;
import lk.ijse.dto.DriverDto;
import lk.ijse.entity.Driver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface DriverDAO extends CrudDAO<Driver> {

    /*boolean save(DriverDto dto) throws SQLException, ClassNotFoundException;

    boolean update(DriverDto dto) throws SQLException, ClassNotFoundException;

    boolean delete(String id) throws SQLException, ClassNotFoundException;

    DriverDto searchAll(String id) throws SQLException, ClassNotFoundException;

    List<DriverDto> getAll() throws SQLException, ClassNotFoundException;*/

}
