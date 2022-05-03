package dao;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.ItemDTO;
import view.tdm.ItemTM;

import java.math.BigDecimal;
import java.sql.*;

public interface ItemDAO {
    public ObservableList<ItemTM> getAllItems() throws SQLException, ClassNotFoundException;

    public ObservableList<ItemTM> deleteItem(String id) throws SQLException, ClassNotFoundException ;

    public ObservableList<ItemTM> saveItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException ;

    public ObservableList<ItemTM> updateItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException ;

    public boolean isExists(String code) throws SQLException, ClassNotFoundException ;

    public String generateId() throws SQLException, ClassNotFoundException ;
}
