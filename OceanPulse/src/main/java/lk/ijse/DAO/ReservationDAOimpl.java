package lk.ijse.DAO;

import lk.ijse.db.Dbconnection;
import lk.ijse.dto.tm.AddTm;
import lk.ijse.dto.tm.ReservationDto;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAOimpl implements ReservationDAO {
    private static OrderDAOimpl orderDao = new OrderDAOimpl();
    private ItemMngDAOimpl itemMngDao = new ItemMngDAOimpl();
    @Override
    public  boolean reservation(ReservationDto dto, String i_id) throws SQLException, ClassNotFoundException {

        Connection connection = null;
        try {
            connection = Dbconnection.getInstance().getConnection();
            connection.setAutoCommit(false);

            boolean isOrderSaved = orderDao.saveOrder(dto.getO_id(),dto.getDate(),dto.getC_id(), dto.getS_id());
            if (isOrderSaved){
                boolean isUpdated = itemMngDao.UpdateItem(dto.getQty(),dto.getList());
                if (isUpdated){
                    boolean isOrderDetailSaved = orderDao.saveOrderDetails(dto.getList(), dto.getO_id());
                    if (isOrderDetailSaved){
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
