package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.BO.BOFactory;
import lk.ijse.BO.BoatBO;
import lk.ijse.BO.InstructorBO;
import lk.ijse.BO.SheduleBO;
import lk.ijse.dto.BoatDto;
import lk.ijse.dto.InsructorDto;
import lk.ijse.dto.ScheduleDto;
import lk.ijse.dto.tm.SheduleTm;
import lk.ijse.DAO.BoatDAOimpl;
import lk.ijse.DAO.InstructorDAOimpl;
import lk.ijse.DAO.SheduleDAOimpl;
import lk.ijse.entity.Boat;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class SheduleController {
    public AnchorPane rootNode;
    public ComboBox comboInsId;
    public ComboBox comboBoatId;

    public TableColumn colDateTime;
    @FXML
    private TableColumn<?, ?> colBoatId;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colInsId;

    @FXML
    private Button customerbtn;

    @FXML
    private Button itembtn;

    @FXML
    private Button logoutbtn;

    @FXML
    private Button reservationbtn;

    @FXML
    private Button shedulebtn;

    @FXML
    private Button staffbtn;

    @FXML
    private TableView<SheduleTm> tblSchedule;

    @FXML
    private TextField txtBoatCapacity;

    @FXML
    private TextField txtDate;

    @FXML
    private TextField txtInsName;

    @FXML
    private TextField txtInsQualidication;

    @FXML
    private TextField txtScheduleId;

    @FXML
    private TextField txtStatus;

    @FXML
    private TextField txtTime;

    public SheduleDAOimpl model = new SheduleDAOimpl();
    public BoatDAOimpl BoatDao = new BoatDAOimpl();
    public InstructorDAOimpl instructorDao = new InstructorDAOimpl();
    SheduleBO sheduleBO = (SheduleBO) BOFactory.getBO(BOFactory.BOTypes.SCHEDULE);
    BoatBO boatBO = (BoatBO) BOFactory.getBO(BOFactory.BOTypes.BOAT);
    InstructorBO instructorBO = (InstructorBO) BOFactory.getBO(BOFactory.BOTypes.INSTRUCTOR);

    public void logoutbtnOnAction(ActionEvent actionEvent) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/login.fxml"));
        Scene scene = new Scene(rootNode);
        Stage Stage = (Stage)this.rootNode.getScene().getWindow();
        Stage.setScene(scene);
        Stage.setTitle("Login Form");
        Stage.centerOnScreen();
        Stage.show();
    }

    public void btnBackOnACtion(ActionEvent actionEvent) {
    }

    public void btnAddOnAction(ActionEvent actionEvent) {
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        clearFields();
    }

    private void clearFields() {
        txtScheduleId.setText(" ");
        txtTime.setText(" ");
        txtDate.setText(" ");
        txtStatus.setText(" ");
        txtBoatCapacity.setText(" ");
        txtInsName.setText(" ");
        txtInsQualidication.setText(" ");
    }

    public void initialize() throws SQLException, ClassNotFoundException {
        loadInsId();
        loadBoatId();
        setCellValueFactory();
        loadAllCustomer();
    }

    private void loadBoatId() throws ClassNotFoundException {
        ObservableList<String> obList = FXCollections.observableArrayList();
        try {
            List<BoatDto> idList = boatBO.getAll();

            for (Boat dto : idList) {
                obList.add(dto.getId());
            }

            comboBoatId.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadInsId() throws ClassNotFoundException {
        ObservableList<String> obList = FXCollections.observableArrayList();
        try {
            List<InsructorDto> idList = instructorBO.getAll();

            for (InsructorDto dto : idList) {
                obList.add(dto.getId());
            }

            comboInsId.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void comboInsIdOnAction(ActionEvent actionEvent) throws ClassNotFoundException {
        String ins_id = (String) comboInsId.getValue();
//        CustomerModel customerModel = new CustomerModel();
        try {
            InsructorDto insructorDto = instructorBO.searchAll(ins_id);
            txtInsName.setText(insructorDto.getName());
            txtInsQualidication.setText(insructorDto.getQualification());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void comboBoatIdOnACtion(ActionEvent actionEvent) throws ClassNotFoundException {
        String b_id = (String) comboBoatId.getValue();
//        CustomerModel customerModel = new CustomerModel();
        try {
            Boat boatDto = boatBO.searchAll(b_id);
            txtBoatCapacity.setText(boatDto.getCapacity());
            txtStatus.setText(boatDto.getStatus());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnSaveOnACtion(ActionEvent actionEvent) throws ClassNotFoundException {
       /* String id = txtScheduleId.getText();
        String date = txtDate.getText();
        //String time = txtTime.getText();
        //String ins_id = String.valueOf(comboInsId.getItems());
        //String b_id = String.valueOf(comboBoatId.getItems());
        String b_id = (String) comboBoatId.getValue();
        String ins_id = (String) comboInsId.getValue();

        var dto = new ScheduleDto(id, date,b_id, ins_id);

        try {
            boolean isSaved = model.saveSchedule(dto);
            if (isSaved){
                new Alert(Alert.AlertType.CONFIRMATION, "Saved!").show();
                System.out.println("Done");
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }*/
       /* String id = txtScheduleId.getText();
        Timestamp date = Timestamp.valueOf(txtDate.getText());
        // String time = txtTime.getText(); // If you have a separate time field
        String b_id = (String) comboBoatId.getValue();
        String ins_id = (String) comboInsId.getValue();

        var dto = new ScheduleDto(id,date, b_id, ins_id);

        try {
            boolean isSaved = model.saveSchedule(dto);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Saved!").show();
                System.out.println("Done");
                loadAllCustomer(); // Reload the table after saving
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }*/
        String id = txtScheduleId.getText();
        String dateString = txtDate.getText();

        try {
            Timestamp date = Timestamp.valueOf(LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            String b_id = (String) comboBoatId.getValue();
            String ins_id = (String) comboInsId.getValue();

            var dto = new ScheduleDto(id, date, b_id, ins_id);

            boolean isSaved = sheduleBO.saveSchedule(dto);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Saved!").show();
                System.out.println("Done");
                loadAllCustomer(); // Reload the table after saving
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (DateTimeParseException e) {
            new Alert(Alert.AlertType.ERROR, "Invalid date format. Please enter the date in the format yyyy-MM-dd HH:mm:ss").show();
        }
    }


    private void loadAllCustomer() throws SQLException, ClassNotFoundException {
        ObservableList<SheduleTm> oblist = FXCollections.observableArrayList();
        try {
            List<ScheduleDto> dtoList = sheduleBO.getAllShedule();
            for (ScheduleDto dto : dtoList) {
                oblist.add(new SheduleTm(dto.getId(),dto.getEventDateTime(),dto.getB_id(),dto.getIns_id()));
            }
            tblSchedule.setItems(oblist);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colDateTime.setCellValueFactory(new PropertyValueFactory<>("eventDateTime")); // Corrected property name
        colBoatId.setCellValueFactory(new PropertyValueFactory<>("b_id"));
        colInsId.setCellValueFactory(new PropertyValueFactory<>("ins_id"));
    }

    public void reservationbtnOnAction(ActionEvent actionEvent) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/reservation.fxml"));
        Scene scene = new Scene(rootNode);
        Stage Stage = (Stage)this.rootNode.getScene().getWindow();
        Stage.setScene(scene);
        Stage.setTitle("reservation Form");
        Stage.centerOnScreen();
        Stage.show();
    }

    public void shedulebtnOnAction(ActionEvent actionEvent) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/shedule.fxml"));
        Scene scene = new Scene(rootNode);
        Stage Stage = (Stage)this.rootNode.getScene().getWindow();
        Stage.setScene(scene);
        Stage.setTitle("Shedule Form");
        Stage.centerOnScreen();
        Stage.show();
    }

    public void staffbtnOnAction(ActionEvent actionEvent) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/staff&others.fxml"));
        Scene scene = new Scene(rootNode);
        Stage Stage = (Stage)this.rootNode.getScene().getWindow();
        Stage.setScene(scene);
        Stage.setTitle("Staff & Others Manage Form");
        Stage.centerOnScreen();
        Stage.show();
    }

    public void itembtnOnAction(ActionEvent actionEvent) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/itemMng.fxml"));
        Scene scene = new Scene(rootNode);
        Stage Stage = (Stage)this.rootNode.getScene().getWindow();
        Stage.setScene(scene);
        Stage.centerOnScreen();
        Stage.show();
    }

    public void customerbtnOnAction(ActionEvent actionEvent) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/customerMng.fxml"));
        Scene scene = new Scene(rootNode);
        Stage Stage = (Stage)this.rootNode.getScene().getWindow();
        Stage.setScene(scene);
        Stage.centerOnScreen();
        Stage.show();
    }

    public void dashboardbtnOnAction(ActionEvent actionEvent) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/dashboard.fxml"));
        Scene scene = new Scene(rootNode);
        Stage Stage = (Stage)this.rootNode.getScene().getWindow();
        Stage.setScene(scene);
        Stage.centerOnScreen();
        Stage.show();
    }
}
