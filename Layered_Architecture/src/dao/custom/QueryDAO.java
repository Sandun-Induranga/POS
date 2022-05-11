package dao.custom;

import java.sql.SQLException;

public interface QueryDAO {
    public void searchOrderByOrderId(String id) throws SQLException, ClassNotFoundException;
}
