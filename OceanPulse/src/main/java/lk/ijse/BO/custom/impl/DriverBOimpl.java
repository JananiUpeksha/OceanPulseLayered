package lk.ijse.BO.custom.impl;

import lk.ijse.BO.custom.DriverBO;
import lk.ijse.DAO.DAOFactory;
import lk.ijse.DAO.custom.DriverDAO;
import lk.ijse.DAO.SQLUtil;
import lk.ijse.dto.DriverDto;
import lk.ijse.entity.Driver;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DriverBOimpl implements DriverBO {
    DriverDAO driverDAO = (DriverDAO) DAOFactory.getDAO(DAOFactory.DAOTypes.DRIVER);
    public boolean save(DriverDto driver) throws SQLException, ClassNotFoundException {
        return driverDAO.save(new Driver(driver.getId(),driver.getName(),driver.getAddress(),driver.getContact(),driver.getExperience()));
    }
    @Override
    public boolean update(DriverDto driver) throws SQLException, ClassNotFoundException {
       return driverDAO.update(new Driver(driver.getName(),driver.getAddress(),driver.getContact(),driver.getExperience(),driver.getId()));
    }
    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return driverDAO.delete(id);
    }
    @Override
    public DriverDto searchAll(String id) throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.execute("SELECT * FROM driver WHERE d_id = ?",id);
        DriverDto driver = null;

        if (rs.next()) {
            driver = new DriverDto(rs.getString("d_id"), rs.getString("name"), rs.getString("address"), rs.getString("contact"),rs.getString("experience"));
        }

        return driver;
    }
    @Override
    public List<DriverDto> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.execute("SELECT * FROM driver");
        ArrayList<DriverDto> getAllDriver = new ArrayList<>();
        while (rs.next()){
            DriverDto driver = new DriverDto(rs.getString("d_id"), rs.getString("name"),rs.getString("address"),rs.getString("contact"),rs.getString("experience"));
            getAllDriver.add(driver);
        }
        return getAllDriver;
    }
}
