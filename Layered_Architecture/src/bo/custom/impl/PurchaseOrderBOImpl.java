package bo.custom.impl;

import bo.custom.PurchaseOrderBO;
import bo.SuperBO;
import dao.DAOFactory;
import dao.custom.*;
import db.DBConnection;
import dto.CustomerDTO;
import dto.ItemDTO;
import dto.OrderDTO;
import dto.OrderDetailDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
public class PurchaseOrderBOImpl implements PurchaseOrderBO, SuperBO {

    private final CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    private final ItemDAO itemDAO = (ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);
    private final OrderDAO orderDAO = (OrderDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDER);
    private final OrderDetailsDAO orderDetailsDAO = (OrderDetailsDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDERDETAILS);
    private final QueryDAO queryDAO = (QueryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.QUERYDAO);

    @Override
    public boolean purchaseOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException {
        /*Transaction*/
        Connection connection = DBConnection.getDbConnection().getConnection();
        /*if order id already exist*/
        if (orderDAO.exist(orderId)) {

        }
        connection.setAutoCommit(false);
        boolean save = orderDAO.save(new OrderDTO(orderId, orderDate, customerId));

        if (!save) {
            connection.rollback();
            connection.setAutoCommit(true);
            return false;
        }
        for (OrderDetailDTO detail : orderDetails) {
            boolean save1 = orderDetailsDAO.save(detail);
            if (!save1) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }
            //Search & Update Item
//                ItemDTO item = findItem(detail.getItemCode());
            ItemDTO item = null;
            item.setQtyOnHand(item.getQtyOnHand() - detail.getQty());

            //update item
            System.out.println(item);
            boolean update = itemDAO.update(item);

            if (!update) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }
        }
        connection.commit();
        connection.setAutoCommit(true);
        return true;
    }

    @Override
    public CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.search(id);
    }

    @Override
    public ItemDTO searchItem(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.search(code);
    }

    @Override
    public boolean checkItemIsAvailable(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.exist(code);
    }

    @Override
    public boolean checkCustomerIsAvailable(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.exist(id);
    }

    @Override
    public String generateNewOrderID() throws SQLException, ClassNotFoundException {
        return orderDAO.generateNewID();
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {
        return customerDAO.getAll();
    }

    @Override
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        return itemDAO.getAll();
    }
}