package lk.ijse.pos.dao.custom;

import lk.ijse.pos.dao.CrudDAO;
import lk.ijse.pos.entity.Customer;

import java.util.ArrayList;

public interface CustomerDAO extends CrudDAO<Customer,String> {
    ArrayList<Customer> getAllCustomersByAddress(String address);
}
