package lk.ijse.pos.bo.custom;

import lk.ijse.pos.dto.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO {
    ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException ;

    boolean saveCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException ;

    boolean updateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException ;

    boolean exitsCustomer(String id) throws SQLException, ClassNotFoundException ;

    void deleteCustomer(String id) throws SQLException, ClassNotFoundException ;

    String generateNewCustomerId() throws SQLException, ClassNotFoundException ;
}
