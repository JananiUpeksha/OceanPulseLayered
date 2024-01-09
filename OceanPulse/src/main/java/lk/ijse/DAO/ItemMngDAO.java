package lk.ijse.DAO;

import lk.ijse.dto.ItemDto;
import lk.ijse.dto.tm.AddTm;

import java.sql.SQLException;
import java.util.List;

public interface ItemMngDAO extends CrudDAO<ItemDto>{
    boolean UpdateItem(int qty, List<AddTm> list) throws SQLException, ClassNotFoundException;

    boolean updateQty(String code, int qty) throws SQLException, ClassNotFoundException;

    public boolean save(ItemDto dto) throws SQLException, ClassNotFoundException;

    public boolean update(ItemDto dto) throws SQLException, ClassNotFoundException;

    ItemDto searchAll(String id) throws SQLException, ClassNotFoundException;

    public boolean delete(String id) throws SQLException, ClassNotFoundException;

    List<ItemDto> getAll() throws SQLException, ClassNotFoundException;

}