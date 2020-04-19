package com.bozin3.datastructuresalgorithms.datastructures;
import java.util.LinkedList;

public class LinkedHashTable {

    private LinkedList<StoredObject>[] entries;

    public LinkedHashTable(){
        entries = new LinkedList[10];
        for(int x = 0; x < 10; x++){
            entries[x] = new LinkedList<>();
        }
    }

    public void put(String key, String data){
        int hashedKey = hashKey(key);
        StoredObject objExists = null;
        for(StoredObject storedItem: entries[hashedKey])
        {
            if(storedItem.getKey().equals(key)){
                objExists = storedItem;
                break;
            }
        }
        if(objExists != null){
            objExists.setData(data); //update
        }else{
            entries[hashedKey].add(new StoredObject(key, data));
        }
    }

    public String get(String key){
        int hashedKey = hashKey(key);
        String result = null;

        for(StoredObject storedItem: entries[hashedKey])
        {
            if(storedItem.getKey().equals(key)){
                result = storedItem.getData();
                break;
            }
        }

        return result;
    }

    public String removeItem(String key){
        int hashedKey = hashKey(key);
        StoredObject object= null;

        for(StoredObject storedItem: entries[hashedKey])
        {
            if(storedItem.getKey().equals(key)){
                object = storedItem;
                break;
            }
        }

        if(object != null) {
            entries[hashedKey].remove(object);
            return object.getData();
        }else{
            return null;
        }
    }

    public void printTable(){
        StringBuilder stringBuilder = new StringBuilder();
        for(int x = 0; x < entries.length; x++){
            for(StoredObject object : entries[x]){
                stringBuilder.append(object.toString());
                stringBuilder.append("\n");
            }
        }
        System.out.println(stringBuilder.toString());
    }

    private int hashKey(String key){
        return Math.abs(key.hashCode() % entries.length);
    }
}
