package dao.custom;

import dao.CrudDAO;
import model.ItemDTO;

import java.util.ArrayList;

public interface ItemDAO extends CrudDAO<ItemDTO,String> {
    public ArrayList<ItemDTO> getAllItemsByPrice(double price);
}
