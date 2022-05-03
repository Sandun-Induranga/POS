package dao;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.CustomerDTO;
import view.tdm.CustomerTM;

import java.sql.*;

public interface CustomerDAO {
    public ObservableList<CustomerTM> getAllCustomer() throws SQLException, ClassNotFoundException;

    public ObservableList<CustomerTM> saveCustomer(CustomerDTO customer) throws SQLException, ClassNotFoundException;

    public ObservableList<CustomerTM> updateCustomer(CustomerDTO customer) throws SQLException, ClassNotFoundException;

    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException;

    public ObservableList<CustomerTM> deleteCustomer(String id) throws SQLException, ClassNotFoundException;

    public String generateCustomerId() throws SQLException, ClassNotFoundException;
}
