package lk.ijse.BO.custom.impl;

import lk.ijse.BO.custom.SheduleBO;
import lk.ijse.DAO.DAOFactory;
import lk.ijse.DAO.custom.SheduleDAO;
import lk.ijse.dto.ScheduleDto;

import java.sql.SQLException;
import java.util.List;

public class sheduleBOimpl implements SheduleBO {
    SheduleDAO sheduleDAO = (SheduleDAO) DAOFactory.getDAO(DAOFactory.DAOTypes.SHEDULE);
    public List<String> getAlls() throws SQLException, ClassNotFoundException {
       return sheduleDAO.getAlls();

    }
    @Override
    public  List<ScheduleDto> getAllShedule() throws SQLException, ClassNotFoundException {
        return sheduleDAO.getAllShedule();
    }
    @Override
    public boolean saveSchedule(ScheduleDto schedule) throws SQLException, ClassNotFoundException {
        return sheduleDAO.saveSchedule(schedule);
    }
}
