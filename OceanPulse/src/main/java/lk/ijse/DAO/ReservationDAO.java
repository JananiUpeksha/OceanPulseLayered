package lk.ijse.DAO;

import lk.ijse.db.Dbconnection;
import lk.ijse.dto.tm.ReservationDto;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public interface ReservationDAO extends SuperDAO{
    public  boolean reservation(ReservationDto dto, String i_id) throws SQLException, ClassNotFoundException;
}
