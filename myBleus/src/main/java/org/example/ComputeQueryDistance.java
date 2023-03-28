package org.example;

import java.util.*;
import java.util.Random;

public class ComputeQueryDistance {

    public ComputeQueryDistance() {
    }
    public static int randomSelect(ArrayList<StoreDistMilesArr> storesDistArr, int storeNum) {
        int randomPivot = randomSelectHelper(storesDistArr, 0, storesDistArr.size() - 1, storeNum);
        return randomPivot;
    }

    private static int randomSelectHelper(ArrayList<StoreDistMilesArr> storesDistArr, int left, int right, int storeNum) {
        if (left == right) {
            return storesDistArr.get(left).getStoreNum();
        }

        Random rand = new Random();
        int pivotIndex = rand.nextInt(right - left + 1) + left;

        int storeIndex = partition(storesDistArr, left, right, pivotIndex);

        if (storeNum == storeIndex) {
            return storesDistArr.get(storeIndex).getStoreNum();
        } else if (storeNum < storeIndex) {
            return randomSelectHelper(storesDistArr, left, storeIndex - 1, storeNum);
        } else {
            return randomSelectHelper(storesDistArr, storeIndex + 1, right, storeNum);
        }
    }

    private static int partition(List<StoreDistMilesArr> arr, int left, int right, int pivotIndex) {
        StoreDistMilesArr pivotValue = arr.get(pivotIndex);
        swap(arr, pivotIndex, right);
        int storeIndex = left;
        for (int i = left; i < right; i++) {
            if (arr.get(i).getDistMiles() < pivotValue.getDistMiles()) {
                swap(arr, i, storeIndex);
                storeIndex++;
            }
        }
        swap(arr, storeIndex, right);
        return storeIndex;
    }

    private static void swap(List<StoreDistMilesArr> arr, int i, int j) {
        StoreDistMilesArr temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }



    static class StoreDistMilesArr {
        int storeNum;
        double distMiles;

        public StoreDistMilesArr(int storeNum, double distMiles) {
            this.storeNum = storeNum;
            this.distMiles = distMiles;
        }

        public int getStoreNum() {
            return storeNum;
        }
        public double getDistMiles() {
            return distMiles;
        }


        public static void main(String[] args) {

            ArrayList<StoreDistMilesArr> storesDistArr = new ArrayList<>();
            storesDistArr.add(new StoreDistMilesArr(1, 10.5));
            storesDistArr.add(new StoreDistMilesArr(2, 5.3));
            storesDistArr.add(new StoreDistMilesArr(3, 7.8));
            storesDistArr.add(new StoreDistMilesArr(4, 3.2));
            storesDistArr.add(new StoreDistMilesArr(5, 9.6));

            int storeNum = 2;
            int result = randomSelect(storesDistArr, storeNum);
            System.out.println("The " + (storeNum + 1) + "th closest store is store number: " + result);
        }
    }
}