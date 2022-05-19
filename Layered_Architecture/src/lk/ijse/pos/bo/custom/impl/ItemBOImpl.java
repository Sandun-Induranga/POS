package lk.ijse.pos.bo.custom.impl;

import lk.ijse.pos.bo.custom.ItemBO;
import lk.ijse.pos.bo.SuperBO;
import lk.ijse.pos.dao.DAOFactory;
import lk.ijse.pos.dao.custom.ItemDAO;
import lk.ijse.pos.dto.ItemDTO;
import lk.ijse.pos.entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO , SuperBO {
    private final ItemDAO itemDAO = (ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);

    @Override
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        ArrayList<Item> all = itemDAO.getAll();
        ArrayList<ItemDTO> allItems = new ArrayList<>();
        for (Item item:
             all) {
            allItems.add(new ItemDTO(item.getCode(),item.getDescription(),item.getUnitPrice(),item.getQtyOnHand()));
        }
        return allItems;
    }

    @Override
    public void deleteItems(String id) throws SQLException, ClassNotFoundException {
        itemDAO.delete(id);
    }

    @Override
    public void saveItem(ItemDTO item) throws SQLException, ClassNotFoundException {
        itemDAO.save(new Item(item.getCode(),item.getDescription(),item.getQtyOnHand(),item.getUnitPrice()));
    }

    @Override
    public void updateItem(ItemDTO item) throws SQLException, ClassNotFoundException {
        itemDAO.save(new Item(item.getCode(),item.getDescription(),item.getQtyOnHand(),item.getUnitPrice()));
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
