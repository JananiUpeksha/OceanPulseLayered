package lk.ijse.DAO.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import lk.ijse.DAO.SQLUtil;
import lk.ijse.DAO.custom.DashboardDAO;
import lk.ijse.db.Dbconnection;

import java.sql.*;

public class DashboardDAOimpl implements DashboardDAO {
  /* public static String getLastCustomerNameFromDatabase() {
        try (Connection connection = Dbconnection.getInstance().getConnection()) {
            String query = "SELECT name FROM customer ORDER BY c_id DESC LIMIT 1";
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getString("name");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "No Customer Found";

    }*/
  @Override
  public String getLastCustomerNameFromDatabase() throws SQLException, ClassNotFoundException {
      /*Connection connection = Dbconnection.getInstance().getConnection();
      String query = "SELECT name FROM customer ORDER BY c_id DESC LIMIT 1";
      PreparedStatement statement = connection.prepareStatement(query);
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next()) {
          return resultSet.getString("name");
      }

      return "No Customer Found";*/
      String query = "SELECT name FROM customer ORDER BY c_id DESC LIMIT 1";
      ResultSet resultSet = SQLUtil.execute(query);

      if (resultSet.next()) {
          return resultSet.getString("name");
      }

      return "No Customer Found";
  }

    //Connection connection = Dbconnection.getInstance().getConnection();
    /*public static ObservableList<PieChart.Data> getScheduleDataFromDatabase() throws SQLException {
        ObservableList<PieChart.Data> scheduleData = FXCollections.observableArrayList();

        // Replace the following code with your actual database access logic
        try (Connection connection = Dbconnection.getInstance().getConnection()) {
            String query = "SELECT ins_id, COUNT(*) AS count FROM schedule GROUP BY ins_id";
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    String b_id = resultSet.getString("ins_id");
                    int count = resultSet.getInt("count");

                    PieChart.Data data = new PieChart.Data(b_id, count);
                    scheduleData.add(data);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }

        return scheduleData;
    }*/

    // Replace this with your actual database connection provider class/method
    @Override
    public ObservableList<PieChart.Data> getScheduleDataFromDatabase() throws SQLException, ClassNotFoundException {
        /*ObservableList<PieChart.Data> scheduleData = FXCollections.observableArrayList();
        Connection connection = Dbconnection.getInstance().getConnection();
        String sql = "SELECT ins_id, COUNT(*) AS count FROM schedule GROUP BY ins_id";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            String b_id = resultSet.getString("ins_id");
            int count = resultSet.getInt("count");

            PieChart.Data data = new PieChart.Data(b_id, count);
            scheduleData.add(data);
        }


        return scheduleData;*/
        ObservableList<PieChart.Data> scheduleData = FXCollections.observableArrayList();
        String sql = "SELECT ins_id, COUNT(*) AS count FROM schedule GROUP BY ins_id";
        ResultSet resultSet = SQLUtil.execute(sql);

        while (resultSet.next()) {
            String insId = resultSet.getString("ins_id");
            int count = resultSet.getInt("count");

            PieChart.Data data = new PieChart.Data(insId, count);
            scheduleData.add(data);
        }

        return scheduleData;
    }

}
