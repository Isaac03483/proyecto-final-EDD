package com.mio.utils;

import com.mio.models.bPlusTree.Pair;
import com.mio.models.table.PropertyType;

public class Sort {

    public static void sort(Pair[] pairs, int from, int to, PropertyType propertyType){
        try{
            for(int i = 0; i < to; i++){
                for(int j = from; j < to - 1; j++){
                    System.out.println("COMPARANDO FROM TO: "+pairs[j+1].key+". CON: "+pairs[j].key+". PROPIEDAD: "+propertyType);
                    System.out.println(compare(pairs[j+1].key, pairs[j].key, propertyType));
                    if(compare(pairs[j+1].key, pairs[j].key, propertyType)){
                        Pair temp = pairs[j];
                        pairs[j] = pairs[j+1];
                        pairs[j+1] = temp;
                        System.out.println("RESULTADOS FROM TO: "+pairs[j+1].key+". CON: "+pairs[j].key);

                    }
                }
            }
        } catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }


    public static void sort(Pair[] pairs, PropertyType propertyType){
        try{
            for(int i = 0; i < pairs.length; i++){
                for(int j = 0; j < pairs.length - 1; j++){
                    System.out.println("COMPARANDO: "+pairs[j+1].key+". CON: "+pairs[j].key+". PROPIEDAD: "+propertyType);
                    System.out.println(compare(pairs[j+1].key, pairs[j].key, propertyType));
                    if(compare(pairs[j+1].key, pairs[j].key, propertyType)){
                        Pair temp = pairs[j];
                        pairs[j] = pairs[j+1];
                        pairs[j+1] = temp;
                    }
                }
            }
        } catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }

    public static void sort(String[] strings, int from, int to, PropertyType propertyType){
        try{
            System.out.println("COMPARANDO LLAVES DESDE: "+from+", HASTA: "+to);
            for(int i = 0; i < to; i++){
                for(int j = from; j < to - 1; j++){

                    System.out.println("COMPARANDO LLAVES: "+strings[j+1]+". CON: "+strings[j]);
                    if(compare(strings[j+1], strings[j], propertyType)){
                        String temp = strings[j];
                        strings[j] = strings[j+1];
                        strings[j+1] = temp;
                    }
                }
            }
        } catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }

    public static boolean compare(String firstVal, String secondVal, PropertyType propertyType){
        return switch (propertyType){
            case STRING -> firstVal.compareTo(secondVal) < 0;
            case INT -> Integer.parseInt(firstVal) < Integer.parseInt(secondVal);
            case DOUBLE -> Double.parseDouble(firstVal) < Double.parseDouble(secondVal);
            case BOOLEAN -> true;
            case CHAR -> firstVal.charAt(0) < secondVal.charAt(0);
        };
    }
}
