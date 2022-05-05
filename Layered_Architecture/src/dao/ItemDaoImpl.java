package dao;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.ItemDTO;
import view.tdm.ItemTM;

import java.sql.*;

public class ItemDaoImpl implements CrudDAO<ItemTM, String, ItemDTO> {
    public ObservableList<ItemTM> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT * FROM Item");
        ObservableList<ItemTM> allItems = FXCollections.observableArrayList();
        while (rst.next()) {
            allItems.add(new ItemTM(rst.getString(1), rst.getString(2), rst.getBigDecimal(3), rst.getInt(4)));
        }
        return allItems;
    }

    public ObservableList<ItemTM> delete(String id) throws SQLException, ClassNotFoundException {
        SQLUtil.executeUpdate("DELETE FROM Item WHERE code=?", id);
        return getAll();
    }

    public ObservableList<ItemTM> save(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        SQLUtil.executeUpdate("INSERT INTO Customer (id,name, address) VALUES (?,?,?)", itemDTO.getCode(), itemDTO.getDescription(), itemDTO.getUnitPrice(), itemDTO.getQtyOnHand());
        return getAll();
    }

    public ObservableList<ItemTM> update(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        SQLUtil.executeUpdate("INSERT INTO Customer (id,name, address) VALUES (?,?,?)", itemDTO.getDescription(), itemDTO.getUnitPrice(), itemDTO.getQtyOnHand(), itemDTO.getCode());
        return getAll();
    }

    public boolean exist(String code) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeQuery("SELECT code FROM Item WHERE code=?", code).next();
    }

    public String generateNewId() throws SQLException, ClassNotFoundException {
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
