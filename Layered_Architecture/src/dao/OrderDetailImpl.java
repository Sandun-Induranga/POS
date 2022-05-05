package dao;

import javafx.collections.ObservableList;
import model.OrderDetailDTO;
import view.tdm.OrderDetailTM;

import java.sql.SQLException;

public class OrderDetailImpl implements CrudDAO<OrderDetailTM,String, OrderDetailDTO>{
    @Override
    public ObservableList<OrderDetailTM> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ObservableList<OrderDetailTM> save(OrderDetailDTO customer) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ObservableList<OrderDetailTM> update(OrderDetailDTO customer) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ObservableList<OrderDetailTM> delete(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        return null;
    }
}
