package integration;

import model.Amount;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * This handles the store's inventory.
 */
public class InventoryHandler {
    private final ArrayList<ItemDTO> inventory = new ArrayList<>();

    /**
     * Creates a new instance and adds the items to the inventory.
     */
    InventoryHandler(){
        addItems();
    }

    /**
     * Checks if there is an item with the parsed item ID.
     * @param itemID The ID of the item to search for in the inventory.
     * @return If there exists an item with the parsed ID then that item will be returned.
     * If there does not exist an item with that ID then it returns {@code null}.
     * @throws ItemNotFoundException If there does not exist an item with the parsed ID.
     */
    public ItemDTO getItemDTO(String itemID) throws ItemNotFoundException, SQLException {
        String inventoryItemID;
        for(ItemDTO item : inventory){
            inventoryItemID = item.getID();
            if(itemID.equals(inventoryItemID)){
                return item;
            }
            if(itemID.equals("databaseFailureID")){
                throw new SQLException();
                //throw new DatabaseFailureException("databaseFailureID");
            }
        }
        throw new ItemNotFoundException(itemID);

        //return invalidItem();
    }

    /**
     * Returns a value that represents an invalid item.
     * @return An invalid item.
     */
    private ItemDTO invalidItem(){
        return new ItemDTO("INVALID ITEM ID", "INVALID ITEM NAME",new Amount(0), 0, "INVALID ITEM DESCRIPTION");
    }

    /**
     * Adds items to the inventory.
     */
    private void addItems(){
        inventory.add(new ItemDTO("abc123",
                "BigWheel Oatmeal",
                new Amount(29.9),
                6,
                "BigWheel Oatmeal 500 g, whole grain oats, high fiber, gluten free"));
        inventory.add(new ItemDTO("abc123",
                "BigWheel Oatmeal",
                new Amount(29.9),
                6,
                "BigWheel Oatmeal 500 g,whole grain oats, high fiber, gluten free"));
        inventory.add(new ItemDTO("def456",
                "YouGoGo Blueberry",
                new Amount(14.9),
                6,
                "YouGoGo Blueberry 240 g, low sugar youghurt, blueberry flavour"));
    }
}
