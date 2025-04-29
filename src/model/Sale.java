package model;

import integration.ItemInformation;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 * One single sale made by one single customer and payed with one payment.
 */
public class Sale {
    private LocalTime saleTime;
    private Receipt receipt;
    private int price;
    private ArrayList<ItemInformation> soldItems;

    /**
     * Creates a new instance and saves the time of the sale.
     */
    public Sale(){
        setTimeOfSale();
        receipt = new Receipt();
    }

    /**
     * Sets the time of the sale.
     */
    private void setTimeOfSale(){
        saleTime = LocalTime.now();
    }

    /**
     * Adds scanned item to the list of sold items.
     * @param itemInformation Informationen about the scanned item.
     */
    public void addItem(ItemInformation itemInformation){
        soldItems.add(itemInformation);
    }

    public void endSale(){

    }





}
