package lk.ijse.BO.custom.impl;

import lk.ijse.BO.custom.ItemBO;
import lk.ijse.DAO.DAOFactory;
import lk.ijse.DAO.custom.ItemMngDAO;
import lk.ijse.dto.ItemDto;
import lk.ijse.dto.tm.AddTm;

import java.sql.SQLException;
import java.util.List;

public class ItemBOimpl implements ItemBO {
    ItemMngDAO itemMngDAO = (ItemMngDAO) DAOFactory.getDAO(DAOFactory.DAOTypes.ITEM);
    @Override
    public boolean UpdateItem(int qty, List<AddTm> list) throws SQLException, ClassNotFoundException {
        /*for(AddTm tm : list) {
            System.out.println("Item: " + tm);
            if(!updateQty(tm.getId(), tm.getQty())) {
                return false;
            }
        }
        return true;*/
        return itemMngDAO.UpdateItem(qty, list);
    }
    @Override
    public boolean updateQty(String code, int qty) throws SQLException, ClassNotFoundException {
        return itemMngDAO.updateQty(code, qty);
    }
    @Override
    public boolean save(ItemDto item) throws SQLException, ClassNotFoundException {
        return itemMngDAO.save(new ItemDto(item.getId(),item.getName(),item.getBrand(),item.getSize(),item.getPrice(),item.getQty()));
    }
    @Override
    public boolean update(ItemDto item) throws SQLException, ClassNotFoundException {
        return itemMngDAO.update(new ItemDto(item.getId(),item.getName(),item.getBrand(),item.getSize(),item.getPrice(),item.getQty()));
    }
    @Override
    public ItemDto searchAll(String id) throws SQLException, ClassNotFoundException {
        return itemMngDAO.searchAll(id);
    }
    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return itemMngDAO.delete(id);
    }
    @Override
    public  List<ItemDto> getAll() throws SQLException, ClassNotFoundException {
        return itemMngDAO.getAll();
    }
}
