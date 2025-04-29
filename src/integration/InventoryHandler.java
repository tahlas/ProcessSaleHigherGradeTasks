package integration;

import java.util.ArrayList;

/**
 * This handles the store's inventory.
 */
public class InventoryHandler {
    private ArrayList<ItemDTO> inventory = new ArrayList<ItemDTO>();

    public ItemDTO getItemDTO(String itemID){
        String inventoryItemID;
        for(ItemDTO item : inventory){
            inventoryItemID = item.getID();
            if(itemID.equals(inventoryItemID)){
                return item;
            }
        }
        return invalidItemID();
    }

    private ItemDTO invalidItemID(){
        return null;
    }


}
