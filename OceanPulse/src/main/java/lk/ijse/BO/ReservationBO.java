package lk.ijse.BO;

import lk.ijse.dto.tm.ReservationDto;

import java.sql.SQLException;

public interface ReservationBO extends SuperBO{
    public  boolean reservation(ReservationDto dto, String i_id) throws SQLException, ClassNotFoundException;
}
