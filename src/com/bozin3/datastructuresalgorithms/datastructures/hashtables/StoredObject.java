package com.bozin3.datastructuresalgorithms.datastructures.hashtables;

public class StoredObject {

    private String key;
    private String data;

    public StoredObject() {
    }

    public StoredObject(String key, String data) {
        this.key = key;
        this.data = data;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
