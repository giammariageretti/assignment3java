package com.company;

public class node_class {

    private Integer key;
    private Integer value;
    node_class right;
    node_class left;



    public void node (int key_n,int value_n) {
        key = key_n;
        value = value_n;
    }


    public void setKey(Integer key) {
        this.key = key;
    }
    public void setValue(Integer value) {
        this.value = value;
    }


    public Integer getKey() {
        return key;
    }
    public Integer getValue() {
        return value;
    }


}
