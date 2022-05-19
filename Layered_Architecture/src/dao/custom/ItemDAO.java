package dao.custom;

import dao.CrudDAO;
import dto.ItemDTO;
import entity.Item;

import java.util.ArrayList;

public interface ItemDAO extends CrudDAO<Item,String> {
    public ArrayList<Item> getAllItemsByPrice(double price);
}
