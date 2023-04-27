package com.mio.models.btree;

import com.mio.models.table.Row;

public class DictionaryPair implements Comparable<DictionaryPair>{

    public String key;
    public Row value;


    public DictionaryPair(String key, Row value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(DictionaryPair dictionaryPair) {
        if (key.equals(dictionaryPair.key)) {
            return 0;
        } else if (key.compareTo(dictionaryPair.key) > 0) {
            return 1;
        }
        return -1;
    }
}
