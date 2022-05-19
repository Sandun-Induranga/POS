package dao.custom;

import dao.CrudDAO;
import dto.CustomerDTO;
import entity.Customer;

import java.util.ArrayList;

public interface CustomerDAO extends CrudDAO<Customer,String> {
    ArrayList<Customer> getAllCustomersByAddress(String address);
}
