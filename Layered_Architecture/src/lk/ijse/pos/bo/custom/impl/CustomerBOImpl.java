package lk.ijse.pos.bo.custom.impl;

import lk.ijse.pos.bo.custom.CustomerBO;
import lk.ijse.pos.bo.SuperBO;
import lk.ijse.pos.dao.DAOFactory;
import lk.ijse.pos.dao.custom.CustomerDAO;
import lk.ijse.pos.dto.CustomerDTO;
import lk.ijse.pos.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO, SuperBO {
    private final CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        ArrayList<CustomerDTO> allCustomers = new ArrayList<>();
         ArrayList<Customer> all =  customerDAO.getAll();
        for (Customer customer: all
             ) {
            allCustomers.add(new CustomerDTO(customer.getId(),customer.getName(),customer.getAddress()));
        }
        return allCustomers;
    }

    @Override
    public boolean saveCustomer(CustomerDTO customer) throws SQLException, ClassNotFoundException {
        return customerDAO.save(new Customer(customer.getId(),customer.getName(),customer.getAddress()));
    }

    @Override
    public boolean updateCustomer(CustomerDTO customer) throws SQLException, ClassNotFoundException {
        return customerDAO.update(new Customer(customer.getId(),customer.getName(),customer.getAddress()));
    }

    @Override
    public boolean exitsCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.exist(id);
    }

    @Override
    public void deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        customerDAO.delete(id);
    }

    @Override
    public String generateNewCustomerId() throws SQLException, ClassNotFoundException {
        return customerDAO.generateNewID();
    }
}
