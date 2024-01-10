package lk.ijse.DAO.custom;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import lk.ijse.DAO.SuperDAO;
import lk.ijse.db.Dbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface DashboardDAO extends SuperDAO {
    public String getLastCustomerNameFromDatabase() throws SQLException, ClassNotFoundException;
    public ObservableList<PieChart.Data> getScheduleDataFromDatabase() throws SQLException, ClassNotFoundException;
}
