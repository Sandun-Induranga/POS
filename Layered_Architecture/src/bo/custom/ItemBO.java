package bo.custom;

import model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO {
    ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException;

    void deleteItems(String id) throws SQLException, ClassNotFoundException;

    void saveItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;

    void updateItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;

    boolean exitsItem(String id) throws SQLException, ClassNotFoundException;

    String generateNewItemCode() throws SQLException, ClassNotFoundException;
}
