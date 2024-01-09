package lk.ijse.BO;

import lk.ijse.dto.BoatDto;
import lk.ijse.entity.Boat;

import java.sql.SQLException;
import java.util.List;

public interface BoatBO extends SuperBO {
    public  boolean save(BoatDto boat) throws SQLException, ClassNotFoundException;
    public Boat searchAll(String id) throws SQLException, ClassNotFoundException;
    public boolean update(BoatDto boat) throws SQLException, ClassNotFoundException;
    public  boolean delete(String id) throws SQLException, ClassNotFoundException;
    public List<BoatDto> getAll() throws SQLException, ClassNotFoundException;

}
