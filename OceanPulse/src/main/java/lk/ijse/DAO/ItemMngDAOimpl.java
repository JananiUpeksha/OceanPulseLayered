package lk.ijse.DAO;

import lk.ijse.dto.ItemDto;
import lk.ijse.dto.tm.AddTm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemMngDAOimpl implements ItemMngDAO{
    @Override
    public boolean UpdateItem(int qty, List<AddTm> list) throws SQLException, ClassNotFoundException {
        for(AddTm tm : list) {
            System.out.println("Item: " + tm);
            if(!updateQty(tm.getId(), tm.getQty())) {
                return false;
            }
        }
        return true;
    }
    @Override
    public boolean updateQty(String code, int qty) throws SQLException, ClassNotFoundException {
        /*Connection connection = Dbconnection.getInstance().getConnection();

        String sql = "UPDATE item SET qtyOnHand= qtyOnHand -? WHERE i_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setInt(1, qty);
        pstm.setString(2, code);

        return pstm.executeUpdate() > 0;*/
        return SQLUtil.execute("UPDATE item SET qtyOnHand= qtyOnHand -? WHERE i_id = ?",qty, code);
    }
    @Override
    public boolean save(ItemDto item) throws SQLException, ClassNotFoundException {
        /*Connection connection = Dbconnection.getInstance().getConnection();;
        String sql = "INSERT INTO item VALUES(?,?,?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,dto.getId());
        pstm.setString(2,dto.getName());
        pstm.setString(3,dto.getBrand());
        pstm.setString(4,dto.getSize());
        pstm.setDouble(5,dto.getPrice());
        pstm.setInt(6,dto.getQty());
        return pstm.executeUpdate()>0;*/
        return SQLUtil.execute("INSERT INTO item VALUES(?,?,?,?,?,?)",item.getId(),item.getName(),item.getBrand(),item.getSize(),item.getPrice(),item.getQty());
    }
    @Override
    public boolean update(ItemDto item) throws SQLException, ClassNotFoundException {
        /*Connection connection = Dbconnection.getInstance().getConnection();
        String sql = "UPDATE item SET name = ? , brand = ? , size = ?, price = ? ,qtyOnHand = ? WHERE i_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, dto.getName());
        pstm.setString(2, dto.getBrand());
        pstm.setString(3, dto.getSize());
        pstm.setDouble(4, dto.getPrice());
        pstm.setInt(5, dto.getQty());
        pstm.setString(6, dto.getId());
        return pstm.executeUpdate() > 0;*/
        return SQLUtil.execute("UPDATE item SET name = ? , brand = ? , size = ?, price = ? ,qtyOnHand = ? WHERE i_id = ?",item.getName(),item.getBrand(),item.getSize(),item.getPrice(),item.getQty(),item.getId());
    }
    @Override
    public ItemDto searchAll(String id) throws SQLException, ClassNotFoundException {
        /*Connection connection = Dbconnection.getInstance().getConnection();
        String sql = "SELECT * FROM item WHERE i_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,id);
        ResultSet rs = pstm.executeQuery();
        ItemDto dto = null;
        if (rs.next()){
            String i_id = rs.getString(1);
            String i_name = rs.getString(2);
            String i_brand = rs.getString(3);
            String i_size = rs.getString(4);
            String i_price = rs.getString(5);
            String i_qty = rs.getString(6);

            dto = new ItemDto(i_id,i_name,i_brand,i_size, Double.parseDouble(i_price), Integer.parseInt(i_qty));
        }
        return  dto;*/
        ResultSet rs = SQLUtil.execute("SELECT * FROM item WHERE i_id = ?",id);
        ItemDto item = null;

        if (rs.next()) {
            item = new ItemDto(rs.getString("i_id"), rs.getString("name"), rs.getString("brand"), rs.getString("size"),rs.getDouble("price"),rs.getInt("qtyOnHand"));
        }

        return item;
    }
    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        /*Connection connection = Dbconnection.getInstance().getConnection();
        String sql = "DELETE FROM item WHERE i_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,id);
        return pstm.executeUpdate()>0;*/
        return SQLUtil.execute("DELETE FROM item WHERE i_id = ?",id);
    }
    @Override
    public List<ItemDto> getAll() throws SQLException, ClassNotFoundException {
        /*Connection connection = Dbconnection.getInstance().getConnection();
        String sql = "SELECT * FROM item";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        List<ItemDto> dtoList = new ArrayList<>();

        while (rs.next()){
            String i_id = rs.getString(1);
            String i_name = rs.getString(2);
            String i_brand = rs.getString(3);
            String i_size = rs.getString(4);
            String i_price = rs.getString(5);
            String i_qty = rs.getString(6);

            dtoList.add(new ItemDto(i_id,i_name,i_brand,i_size, Double.parseDouble(i_price), Integer.parseInt(i_qty)));
        }
        return dtoList;*/
        ResultSet rs = SQLUtil.execute("SELECT * FROM item");
        ArrayList<ItemDto> getAllItem = new ArrayList<>();
        while (rs.next()){
            ItemDto item = new ItemDto(rs.getString("i_id"), rs.getString("name"),rs.getString("brand"),rs.getString("size"),rs.getDouble("price"),rs.getInt("qtyOnHand"));
            getAllItem.add(item);
        }
        return getAllItem;
    }
}
