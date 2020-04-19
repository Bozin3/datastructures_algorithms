package com.bozin3.datastructuresalgorithms.datastructures;

public class ArrayHashTable {

    private StoredObject[] entries;

    public ArrayHashTable(){
        entries = new StoredObject[10];
    }

    public void put(String key, String data){
        if(key == null){
            throw new IllegalArgumentException("Key must be provided");
        }
        int hashedKey = hashKey(key);

        int freeIndex = -1;
        for(int x = hashedKey; x < entries.length; x++){
            // usually on the first loop, the hashedKey should be free
            if(entries[x] == null || entries[x].getKey().equals(key)){
                freeIndex = x;
                break;
            }
        }

        if(freeIndex == -1){
            for(int x = 0; x < hashedKey; x++){
                if(entries[x] == null || entries[x].getKey().equals(key)){
                    freeIndex = x;
                    break;
                }
            }
        }

        // if we found free place
        if(freeIndex != -1){
            entries[freeIndex] = new StoredObject(key, data);
        }else{
            System.out.println("No Free Space!");
        }
    }

    public String get(String key){
        if(key == null){
            throw new IllegalArgumentException("Key must be provided");
        }

        int hashedKey = hashKey(key);

        // loop from calculated index to end
        StoredObject foundObj = null;
        for(int x = hashedKey; x < entries.length; x++){
            // usually it should be found on the first loop if there are no hash key collisions
            if(entries[x] != null && entries[x].getKey().equals(key)){
                foundObj = entries[x];
                break;
            }
        }

        // if not found , loop again from start to calculated index
        if(foundObj == null){
            for(int x = 0; x < hashedKey; x++){
                if(entries[x] != null && entries[x].getKey().equals(key)){
                    foundObj = entries[x];
                    break;
                }
            }
        }

        if(foundObj != null){
            return foundObj.getData();
        }else{
            return null;
        }
    }

    public String remove(String key){
        if(key == null){
            throw new IllegalArgumentException("Key must be provided");
        }

        int hashedKey = hashKey(key);

        int foundIndex = -1;
        for(int x = hashedKey; x < entries.length; x++){
            // usually it should be found on the first loop if there are no hash key collisions
            if(entries[x] != null && entries[x].getKey().equals(key)){
                foundIndex = x;
                break;
            }
        }

        if(foundIndex == -1){
            for(int x = 0; x < hashedKey; x++){
                if(entries[x] != null && entries[x].getKey().equals(key)){
                    foundIndex = x;
                    break;
                }
            }
        }

        if(foundIndex != -1){
            String removedItem = entries[foundIndex].getData();
            entries[foundIndex] = null;
            rehash();
            return removedItem;
        }else{
           return null;
        }
    }

    private void rehash(){
        StoredObject[] objects = new StoredObject[entries.length];
        int index = 0;
        for(int x = 0; x < entries.length; x++){
            if(entries[x] != null){
                objects[index++] = entries[x];
                entries[x] = null;
            }
        }

        for(StoredObject object: objects){
            if(object != null){
                put(object.getKey(),object.getData());
            }
        }
    }

    public void printTable(){
        for(int x = 0; x < entries.length; x++){
            String data = entries[x] == null ? "Empty" : entries[x].getData();
            System.out.println(x + ": " + data);
        }
    }

    private int hashKey(String key){
       //return Math.abs(key.hashCode() % entries.length);
        return key.length() % entries.length;
    }
}
