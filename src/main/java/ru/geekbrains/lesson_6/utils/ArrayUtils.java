package ru.geekbrains.lesson_6.utils;

import java.util.ArrayList;
import java.util.List;

public final class ArrayUtils {

    private ArrayUtils(){}

    public static int[] createArrayOfIntsAfterLastFour(int[] array){
        List<Integer> list = new ArrayList<>();
        int point = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 4){
                point = i + 1;
            }
        }

        if (point == 0){
            throw new RuntimeException("There is no '4' digits found in array...");
        }

        for (int i = point; i < array.length; i++) {
            list.add(array[i]);
        }

        int[] newArray = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            newArray[i] = list.get(i);
        }

        return newArray;
    }

    public static boolean searchArrayForOneAndFour(int[] array){
        for(int i : array){
            if (i == 1 || i == 4){
                return true;
            }
        }
        return false;
    }
}
