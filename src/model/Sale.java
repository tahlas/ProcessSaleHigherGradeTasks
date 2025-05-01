package model;

import integration.ItemDTO;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 * One single sale made by one single customer and payed with one payment.
 */
public class Sale {
    private LocalTime saleTime;
    private Receipt receipt;
    //private ArrayList<ItemDTO> soldItems;//osäker om den behövs

    /**
     * Creates a new instance and saves the time of the sale.
     */
    public Sale(){
        setTimeOfSale();
        receipt = new Receipt(saleTime);
    }

    /**
     * Sets the time of the sale.
     */
    private void setTimeOfSale(){
        saleTime = LocalTime.now();
    }

    /**
     * Adds a scanned item to the list of sold items.
     * @param itemDTO The item to add to the sale.
     */
    public void addItem(ItemDTO itemDTO){
        //soldItems.add(itemDTO);
        receipt.addItemToReceipt(itemDTO);
    }

//    /**
//     * Adds a scanned item multiple times to the list of sold items.
//     * @param itemDTO The item to add to the sale.
//     * @param quantity The amount of items to add to the list of sold items.
//     */
//    public void addItem(ItemDTO itemDTO, int quantity){
//        for(int i = 0; i < quantity; i++){
//            soldItems.add(itemDTO);
//        }
//        receipt.addItemToReceipt(itemDTO, quantity);
//    }

    public Receipt getReceipt(){
        return receipt;
    }





}
