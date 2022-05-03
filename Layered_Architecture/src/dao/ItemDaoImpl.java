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
        ResultSet rst = SQLUtil.executeQuery("SELECT * FROM Item");
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
        SQLUtil.executeUpdate("DELETE FROM Item WHERE code=?",id);
        return getAllItems();
    }

    public ObservableList<ItemTM> saveItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        SQLUtil.executeUpdate("INSERT INTO Customer (id,name, address) VALUES (?,?,?)",itemDTO.getCode(),itemDTO.getDescription(), itemDTO.getUnitPrice(), itemDTO.getQtyOnHand());
        return getAllItems();
    }

    public ObservableList<ItemTM> updateItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        SQLUtil.executeUpdate("INSERT INTO Customer (id,name, address) VALUES (?,?,?)",itemDTO.getDescription(),itemDTO.getUnitPrice(),itemDTO.getQtyOnHand(), itemDTO.getCode());
        return getAllItems();
    }

    public boolean isExists(String code) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeQuery("SELECT code FROM Item WHERE code=?",code).next();
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
