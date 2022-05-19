package lk.ijse.pos.dao.custom;

import lk.ijse.pos.dao.SuperDAO;
import lk.ijse.pos.dto.CustomDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QueryDAO extends SuperDAO {
    public ArrayList<CustomDTO> searchOrderByOrderId(String id) throws SQLException, ClassNotFoundException;
}
