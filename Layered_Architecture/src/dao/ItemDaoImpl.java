package dao;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.CustomerDTO;
import model.ItemDTO;
import view.tdm.CustomerTM;
import view.tdm.ItemTM;

import java.math.BigDecimal;
import java.sql.*;

public class ItemDaoImpl implements ItemDAO{
    public ObservableList<ItemTM> getAllItems() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM Item");
        ObservableList<ItemTM> allItems = FXCollections.observableArrayList();
        while (rst.next()) {
            String code = rst.getString(1);
            String description = rst.getString(2);
            BigDecimal unitPrice = rst.getBigDecimal(3);
            int qtyOnHand = rst.getInt(4);
            allItems.add(new ItemTM(code, description, unitPrice,qtyOnHand));
        }
        return allItems;
    }

    public ObservableList<ItemTM> deleteItem(String id) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Item WHERE code=?");
        pstm.setString(1, id);
        pstm.executeUpdate();
        return getAllItems();
    }

    public ObservableList<ItemTM> saveItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {

        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)");
        pstm.setString(1, itemDTO.getCode());
        pstm.setString(2, itemDTO.getDescription());
        pstm.setBigDecimal(3, itemDTO.getUnitPrice());
        pstm.setInt(4, itemDTO.getQtyOnHand());
        pstm.executeUpdate();
        return getAllItems();
    }

    public ObservableList<ItemTM> updateItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {

        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?");
        pstm.setString(1, itemDTO.getDescription());
        pstm.setBigDecimal(2, itemDTO.getUnitPrice());
        pstm.setInt(3, itemDTO.getQtyOnHand());
        pstm.setString(4, itemDTO.getCode());
        pstm.executeUpdate();
        return getAllItems();
    }

    public boolean isExists(String code) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT code FROM Item WHERE code=?");
        pstm.setString(1, code);
        return pstm.executeQuery().next();
    }

    public String generateId() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        ResultSet rst = connection.createStatement().executeQuery("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("code");
            int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newItemId);
        } else {
            return "I00-001";
        }
    }
}
