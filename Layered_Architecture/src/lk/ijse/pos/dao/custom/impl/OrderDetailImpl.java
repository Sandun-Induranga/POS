package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.SQLUtil;
import lk.ijse.pos.dao.custom.OrderDetailsDAO;
import lk.ijse.pos.entity.OrderDetails;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
public class OrderDetailImpl implements OrderDetailsDAO {

    @Override
    public ArrayList<OrderDetails> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(OrderDetails dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)", dto.getOid(), dto.getItemCode(), dto.getUnitPrice(), dto.getQty());
    }

    @Override
    public boolean update(OrderDetails dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public OrderDetails search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }
}