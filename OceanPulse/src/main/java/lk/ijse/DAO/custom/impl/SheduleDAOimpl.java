package lk.ijse.DAO.custom.impl;

import lk.ijse.DAO.SQLUtil;
import lk.ijse.DAO.custom.SheduleDAO;
import lk.ijse.dto.ScheduleDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SheduleDAOimpl implements SheduleDAO {
    @Override
    public  List<String> getAlls() throws SQLException, ClassNotFoundException {
        /*Connection connection = Dbconnection.getInstance().getConnection();
        String sql = "SELECT s_id FROM schedule ";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        List<String> id = new ArrayList<>();

        while (rs.next()){
            id.add(rs.getString(1));
        }
        return id;*/
        ResultSet rs = SQLUtil.execute("SELECT s_id FROM schedule");
        List<String> idList = new ArrayList<>();

        while (rs.next()) {
            idList.add(rs.getString("s_id"));
        }

        return idList;

    }
    @Override
    public  List<ScheduleDto> getAllShedule() throws SQLException, ClassNotFoundException {
        /*Connection connection = Dbconnection.getInstance().getConnection();
        String sql = "SELECT * FROM schedule";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        List<ScheduleDto> dtoList = new ArrayList<>();

        while (rs.next()){
            String id = rs.getString(1);
            Timestamp  date = Timestamp.valueOf(rs.getString(2));
            String boat_id = rs.getString(3);
            String i_id = rs.getString(4);

            dtoList.add(new ScheduleDto(id,date,boat_id,i_id));
        }
        return dtoList;*/
        ResultSet rs = SQLUtil.execute("SELECT * FROM schedule");
        ArrayList<ScheduleDto> getAllSchedule = new ArrayList<>();
        while (rs.next()){
            ScheduleDto schedule = new ScheduleDto(rs.getString("s_id"), rs.getTimestamp("event_datetime"),rs.getString("b_id"),rs.getString("ins_id"));
            getAllSchedule.add(schedule);
        }
        return getAllSchedule;
    }
    @Override
    public boolean saveSchedule(ScheduleDto schedule) throws SQLException, ClassNotFoundException {
        /*Connection connection = Dbconnection.getInstance().getConnection();;
        String sql = "INSERT INTO schedule VALUES(?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,dto.getId());
        pstm.setTimestamp(2, Timestamp.valueOf(String.valueOf(dto.getEventDateTime())));
        pstm.setString(3,dto.getB_id());
        pstm.setString(4,dto.getIns_id());

        return pstm.executeUpdate()>0;*/
        return SQLUtil.execute("INSERT INTO schedule VALUES(?,?,?,?)",schedule.getId(),schedule.getEventDateTime(),schedule.getB_id(),schedule.getIns_id());
    }
}
