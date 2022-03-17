package com.example.twoactivitieslifecycle;
//import required library
import java.util.HashMap;
//class ShopList
public class ShopList {
    //creating object
    public HashMap<String,Integer> list=new HashMap<>();

    /**
     * function addItem
     * @param item
     */
    public void addItem(String item){
        //if list contain key
        if(list.containsKey(item)){
            //add the items
            list.put(item, list.get(item)+1);
        }else{
            //set the item to 1
            list.put(item,1);
        }
    }
    //function getItems
    public HashMap<String,Integer> getItems(){
        //return list
        return list;
    }
}
