package lk.ijse.BO.custom;

import lk.ijse.BO.SuperBO;
import lk.ijse.dto.ScheduleDto;

import java.sql.SQLException;
import java.util.List;

public interface SheduleBO extends SuperBO {
    public List<String> getAlls() throws SQLException, ClassNotFoundException;
    public  List<ScheduleDto> getAllShedule() throws SQLException, ClassNotFoundException;
    public boolean saveSchedule(ScheduleDto schedule) throws SQLException, ClassNotFoundException;
}
