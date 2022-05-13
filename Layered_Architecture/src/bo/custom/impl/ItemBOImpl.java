package bo.custom.impl;

import bo.custom.ItemBO;
import dao.custom.ItemDAO;
import dao.custom.impl.ItemDaoImpl;
import model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {
    private final ItemDAO itemDAO = new ItemDaoImpl();

    @Override
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        return itemDAO.getAll();
    }

    @Override
    public void deleteItems(String id) throws SQLException, ClassNotFoundException {
        itemDAO.delete(id);
    }

    @Override
    public void saveItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        itemDAO.save(itemDTO);
    }

    @Override
    public void updateItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        itemDAO.save(itemDTO);
    }

    @Override
    public boolean exitsItem(String id) throws SQLException, ClassNotFoundException {
        return itemDAO.exist(id);
    }

    @Override
    public String generateNewItemCode() throws SQLException, ClassNotFoundException {
        return itemDAO.generateNewID();
    }
}
