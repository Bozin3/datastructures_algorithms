package com.bozin3.datastructuresalgorithms.datastructures.hashtables;

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
        if(entries[hashedKey] != null && !entries[hashedKey].getKey().equals(key)){
            int stopIndex = hashedKey;
            boolean fromStart = false; // to prevent looping twice the entire array
            if(hashedKey == entries.length - 1){
                fromStart = true;
                hashedKey = 0;
            }else{
                hashedKey ++;
            }
            while (hashedKey < entries.length
                    && hashedKey != stopIndex
                    && entries[hashedKey] != null){

                // example: if stopIndex is 5, we want to loop from 6 to 10, and from 0 to 4
                if(!fromStart && hashedKey == entries.length - 1){
                    hashedKey = 0;
                }else{
                    hashedKey ++;
                }
            }
        }

        if(entries[hashedKey] != null && !entries[hashedKey].getKey().equals(key)){
            System.out.println("There is no space left");
        }else{
            entries[hashedKey] = new StoredObject(key, data);
        }
    }

    public String get(String key){
        if(key == null){
            throw new IllegalArgumentException("Key must be provided");
        }

        int hashedKey = hashKey(key);
        int stopIndex = hashedKey;
        boolean fromStart = false;
        if(hashedKey == entries.length - 1){
            fromStart = true;
            hashedKey = 0;
        }else{
            hashedKey++;
        }
        // loop from calculated index to end
        StoredObject foundObj = null;
        while (hashedKey < entries.length && hashedKey != stopIndex && entries[hashedKey] != null){
            if(entries[hashedKey].getKey().equals(key)){
                foundObj = entries[hashedKey];
                break;
            }
            if(!fromStart && hashedKey == entries.length - 1){
                hashedKey = 0;
            }else{
                hashedKey++;
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
        int stopIndex = hashedKey;
        boolean fromStart = false;
        if(hashedKey == entries.length - 1){
            fromStart = true;
            hashedKey = 0;
        }else{
            hashedKey++;
        }
        // loop from calculated index to end
        int foundObjIndex = -1;
        while (hashedKey < entries.length && hashedKey != stopIndex && entries[hashedKey] != null){
            if(entries[hashedKey].getKey().equals(key)){
                foundObjIndex = hashedKey;
                break;
            }
            if(!fromStart && hashedKey == entries.length - 1){
                // start again from 0 index to stop index
                hashedKey = 0;
            }else{
                hashedKey++;
            }
        }

        if(foundObjIndex != -1){
            StoredObject removedItem = entries[foundObjIndex];
            entries[foundObjIndex] = null;
            rehash();
            return removedItem.getData();
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
