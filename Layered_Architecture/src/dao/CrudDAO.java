package dao;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.CustomerDTO;
import view.tdm.CustomerTM;

import java.sql.*;

public interface CrudDAO<T,ID,I> {
    ObservableList<T> getAll() throws SQLException, ClassNotFoundException;

    ObservableList<T> save(I customer) throws SQLException, ClassNotFoundException;

    ObservableList<T> update(I customer) throws SQLException, ClassNotFoundException;

    boolean exist(ID id) throws SQLException, ClassNotFoundException;

    ObservableList<T> delete(ID id) throws SQLException, ClassNotFoundException;

    String generateNewId() throws SQLException, ClassNotFoundException;
}
