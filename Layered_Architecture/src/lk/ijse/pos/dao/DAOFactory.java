package lk.ijse.pos.dao;

import dao.custom.impl.*;
import lk.ijse.pos.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return daoFactory == null ? new DAOFactory() : daoFactory;
    }

    public enum DAOTypes {
        CUSTOMER, ITEM, ORDER, ORDERDETAILS, QUERYDAO
    }

    public SuperDAO getDAO(DAOTypes types) {
        switch (types) {
            case CUSTOMER:
                return new CustomerDAOImpl();
            case ITEM:
                return new ItemDaoImpl();
            case ORDER:
                return new OrderDaoImpl();
            case ORDERDETAILS:
                return new OrderDetailImpl();
            case QUERYDAO:
                return new QueryDAOImpl();
            default:
                return null;
        }
    }
}
