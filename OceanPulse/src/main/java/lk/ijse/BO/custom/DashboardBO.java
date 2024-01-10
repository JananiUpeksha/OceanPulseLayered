package lk.ijse.BO.custom;

import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import lk.ijse.BO.SuperBO;

import java.sql.SQLException;

public interface DashboardBO extends SuperBO {
    public String getLastCustomerNameFromDatabase() throws SQLException, ClassNotFoundException;
    public ObservableList<PieChart.Data> getScheduleDataFromDatabase() throws SQLException, ClassNotFoundException;
}
