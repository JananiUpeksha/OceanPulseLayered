package lk.ijse.BO.custom.impl;

import lk.ijse.BO.custom.BoatBO;
import lk.ijse.DAO.custom.BoatDAO;
import lk.ijse.DAO.DAOFactory;
import lk.ijse.DAO.SQLUtil;
import lk.ijse.dto.BoatDto;
import lk.ijse.entity.Boat;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

 public class BoatBOimpl implements BoatBO {
    BoatDAO boatDAO = (BoatDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.BOAT);
    @Override
    public  boolean save(BoatDto boat) throws SQLException, ClassNotFoundException {
        return boatDAO.save(new BoatDto(boat.getId(),boat.getCapacity(),boat.getStatus(),boat.getModel()));
    }

    @Override
    public Boat searchAll(String id) throws SQLException, ClassNotFoundException {
       /* ResultSet rs = SQLUtil.execute("SELECT * FROM boat WHERE b_id = ?",id);
        BoatDto boat = null;

        if (rs.next()) {
            boat = new BoatDto(rs.getString("b_id"), rs.getString("capacity"), rs.getString("status"), rs.getString("model"));
        }

        return boat;*/
        return boatDAO.searchAll(id);
    }
    @Override
    public boolean update(BoatDto boat) throws SQLException, ClassNotFoundException {
        return boatDAO.update(new BoatDto(boat.getCapacity(),boat.getStatus(),boat.getModel(),boat.getId()));
    }
    @Override
    public  boolean delete(String id) throws SQLException, ClassNotFoundException {
        return boatDAO.delete(id);
    }
    @Override
    public List<BoatDto> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.execute("SELECT * FROM boat");
        ArrayList<BoatDto> getAllBoat = new ArrayList<>();
        while (rs.next()){
            BoatDto boat = new BoatDto(rs.getString("b_id"), rs.getString("capacity"),rs.getString("status"),rs.getString("model"));
            getAllBoat.add(boat);
        }
        return getAllBoat;
    }

}
