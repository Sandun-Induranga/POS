package dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.CustomerDTO;
import view.tdm.CustomerTM;

import java.sql.*;

public class CustomerDAOImpl implements CrudDAO<CustomerTM, String, CustomerDTO> {
    @Override
    public ObservableList<CustomerTM> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ObservableList<CustomerTM> save(CustomerDTO customer) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ObservableList<CustomerTM> update(CustomerDTO customer) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ObservableList<CustomerTM> delete(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        return null;
    }
//    public ObservableList<CustomerTM> getAllCustomer() throws SQLException, ClassNotFoundException {
//        ResultSet rst = SQLUtil.executeQuery("SELECT * FROM Customer");
//        ObservableList<CustomerTM> allCustomers = FXCollections.observableArrayList();
//        while (rst.next()) {
//            allCustomers.add(new CustomerTM(rst.getString(1), rst.getString(2), rst.getString(3)));
//        }
//        return allCustomers;
//    }
//
//    public ObservableList<CustomerTM> saveCustomer(CustomerDTO customer) throws SQLException, ClassNotFoundException {
//        SQLUtil.executeUpdate("INSERT INTO Customer (id,name, address) VALUES (?,?,?)", customer.getId(), customer.getName(), customer.getAddress());
//        return getAllCustomer();
//    }
//
//    public ObservableList<CustomerTM> updateCustomer(CustomerDTO customer) throws SQLException, ClassNotFoundException {
//        SQLUtil.executeUpdate("INSERT INTO Customer (id,name, address) VALUES (?,?,?)", customer.getName(), customer.getAddress(), customer.getId());
//        return getAllCustomer();
//    }
//
//    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
//        return SQLUtil.executeQuery("SELECT id FROM Customer WHERE id=?", id).next();
//    }
//
//    public ObservableList<CustomerTM> deleteCustomer(String id) throws SQLException, ClassNotFoundException {
//        SQLUtil.executeUpdate("DELETE FROM Customer WHERE id=?", id);
//        return getAllCustomer();
//    }
//
//    public String generateCustomerId() throws SQLException, ClassNotFoundException {
//        ResultSet rst = SQLUtil.executeQuery("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
//
//        if (rst.next()) {
//            String id = rst.getString("id");
//            int newCustomerId = Integer.parseInt(id.replace("C00-", "")) + 1;
//            return String.format("C00-%03d", newCustomerId);
//        } else {
//            return "C00-001";
//        }
//    }
}
