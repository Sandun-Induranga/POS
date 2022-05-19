package dao.custom;

import dao.SuperDAO;
import dto.CustomDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QueryDAO extends SuperDAO {
    public ArrayList<CustomDTO> searchOrderByOrderId(String id) throws SQLException, ClassNotFoundException;
}
