package bo;

import model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO {
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException ;

    public void deleteItems(String id) throws SQLException, ClassNotFoundException ;

    public void saveItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException ;

    public void updateItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException ;

    public boolean exitsItem(String id) throws SQLException, ClassNotFoundException ;

    public String generateNewItemCode() throws SQLException, ClassNotFoundException ;
}
