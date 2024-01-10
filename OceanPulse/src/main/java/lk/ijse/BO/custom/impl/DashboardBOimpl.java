package lk.ijse.BO.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import lk.ijse.BO.custom.DashboardBO;
import lk.ijse.DAO.SQLUtil;
import lk.ijse.DAO.custom.DashboardDAO;
import lk.ijse.DAO.custom.impl.DashboardDAOimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DashboardBOimpl implements DashboardBO {
    DashboardDAO dashboardDAO = new DashboardDAOimpl();
    @Override
    public String getLastCustomerNameFromDatabase() throws SQLException, ClassNotFoundException {
        /*String query = "SELECT name FROM customer ORDER BY c_id DESC LIMIT 1";
        ResultSet resultSet = SQLUtil.execute(query);

        if (resultSet.next()) {
            return resultSet.getString("name");
        }

        return "No Customer Found";*/
        return dashboardDAO.getLastCustomerNameFromDatabase();
    }
    @Override
    public ObservableList<PieChart.Data> getScheduleDataFromDatabase() throws SQLException, ClassNotFoundException {
        /*ObservableList<PieChart.Data> scheduleData = FXCollections.observableArrayList();
        String sql = "SELECT ins_id, COUNT(*) AS count FROM schedule GROUP BY ins_id";
        ResultSet resultSet = SQLUtil.execute(sql);

        while (resultSet.next()) {
            String insId = resultSet.getString("ins_id");
            int count = resultSet.getInt("count");

            PieChart.Data data = new PieChart.Data(insId, count);
            scheduleData.add(data);
        }

        return scheduleData;*/
        return dashboardDAO.getScheduleDataFromDatabase();
    }

}
