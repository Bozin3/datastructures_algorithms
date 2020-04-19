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
        int stopIndex = hashedKey;
        if(hashedKey == entries.length - 1){
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
            if(hashedKey == entries.length - 1){
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
        if(hashedKey == entries.length - 1){
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
            if(hashedKey == entries.length - 1){
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
