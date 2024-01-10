package lk.ijse.BO.custom.impl;

import lk.ijse.BO.custom.ReservationBO;
import lk.ijse.DAO.DAOFactory;
import lk.ijse.DAO.custom.ItemMngDAO;
import lk.ijse.DAO.custom.OrderDAO;
import lk.ijse.db.Dbconnection;
import lk.ijse.dto.tm.ReservationDto;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class ReservationBOimpl implements ReservationBO {
    ItemMngDAO itemMngDao = (ItemMngDAO) DAOFactory.getDAO(DAOFactory.DAOTypes.ITEM);
    OrderDAO orderDao = (OrderDAO) DAOFactory.getDAO(DAOFactory.DAOTypes.ORDERS);
    @Override
    public  boolean reservation(ReservationDto dto, String i_id) throws SQLException, ClassNotFoundException {
        String id = dto.getId();
        LocalDate date = dto.getDate();
        int qty = dto.getQty();
        String c_id = dto.getC_id();
        String s_id = dto.getS_id();
        String o_id = dto.getO_id();

        Connection connection = null;
        try {
            connection = Dbconnection.getInstance().getConnection();
            connection.setAutoCommit(false);

            boolean isOrderSaved = orderDao.saveOrder(o_id, date, c_id, s_id);
            if (isOrderSaved) {
                boolean isUpdated = itemMngDao.UpdateItem(dto.getQty(), dto.getList());
                if (isUpdated) {
                    boolean isOrderDetailSaved = orderDao.saveOrderDetails(dto.getList(), o_id);
                    if (isOrderDetailSaved) {
                        connection.commit();
                    }
                }
            }
            connection.rollback();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connection.setAutoCommit(true);
        }
        return true;
    }
}
