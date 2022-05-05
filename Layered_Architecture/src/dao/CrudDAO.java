package dao;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.CustomerDTO;
import view.tdm.CustomerTM;

import java.sql.*;

public interface CrudDAO {
    public ObservableList<CustomerTM> getAll() throws SQLException, ClassNotFoundException;

    public ObservableList<CustomerTM> save(CustomerDTO customer) throws SQLException, ClassNotFoundException;

    public ObservableList<CustomerTM> update(CustomerDTO customer) throws SQLException, ClassNotFoundException;

    public boolean exist(String id) throws SQLException, ClassNotFoundException;

    public ObservableList<CustomerTM> delete(String id) throws SQLException, ClassNotFoundException;

    public String generateNewId() throws SQLException, ClassNotFoundException;
}
