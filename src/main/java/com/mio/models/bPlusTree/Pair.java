package com.mio.models.bPlusTree;

import com.mio.models.table.PropertyType;
import com.mio.models.table.Row;

public class Pair implements Comparable<Pair> {

    public String key;
    public Row value;
    public PropertyType primaryType;

    public Pair(String key, Row value, PropertyType primaryType){
        this.key = key;
        this.value = value;
        this.primaryType = primaryType;
    }

    @Override
    public int compareTo(Pair pair) {
        if(key.equals(pair.key)){
            return 0;
        } else if(key.compareTo(pair.key) > 0){
            return 1;
        }
        return -1;
    }
}
