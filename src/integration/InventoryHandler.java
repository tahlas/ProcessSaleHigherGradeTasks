package integration;

import java.util.ArrayList;

/**
 * This handles the store's inventory.
 */
public class InventoryHandler {
    private final ArrayList<ItemDTO> inventory = new ArrayList<ItemDTO>();

    /**
     * Checks if there is an item with the parsed item ID.
     * @param itemID The ID of the item to search for in the inventory.
     * @return If there exists an item with the parsed ID then that item will be returned.
     * If there does not exist an item with that ID then it returns {@code null}.
     */
    public ItemDTO getItemDTO(String itemID){
        String inventoryItemID;
        for(ItemDTO item : inventory){
            inventoryItemID = item.getID();
            if(itemID.equals(inventoryItemID)){
                return item;
            }
        }
        return invalidItem();
    }

    /**
     * Returns a value that represents an invalid item.
     * @return An invalid item.
     */
    private ItemDTO invalidItem(){
        return null;
    }

    private void addItems(){
        inventory.add(new ItemDTO("abc123", "BigWheel Oatmeal", 29,6, "BigWheel Oatmeal 500 g, whole grain oats, high fiber, gluten free", 1));
        inventory.add(new ItemDTO("abc123", "BigWheel Oatmeal", 29,6, "BigWheel Oatmeal 500 g, whole grain oats, high fiber, gluten free", 1));
        inventory.add(new ItemDTO("def456", "YouGoGo Blueberry", 14,6, "YouGoGo Blueberry 240 g, low sugar youghurt, blueberry flavour", 1));


    }
}
