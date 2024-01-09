package lk.ijse.DAO;

import lk.ijse.dto.ScheduleDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface SheduleDAO extends SuperDAO  {
    public List<String> getAlls() throws SQLException, ClassNotFoundException;
    public  List<ScheduleDto> getAllShedule() throws SQLException, ClassNotFoundException;
    public boolean saveSchedule(ScheduleDto schedule) throws SQLException, ClassNotFoundException;
}
