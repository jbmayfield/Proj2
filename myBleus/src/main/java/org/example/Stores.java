package org.example;

import org.example.StoreDistMilesArr;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Stores {

    private List<Double> storeLatArr;
    private List<Double> storeLongArr;
    private List<String> storeNameArr;
    private List<String> storeAddressArr;
    private List<String> storeCityArr;
    private List<String> storeStateArr;
    private List<String> storeZipArr;

    private double[] queryLatArr;
    private double[] queryLongArr;
    private String[] queryStoresArr;

    public Stores(String filename) {
        storeLatArr = new ArrayList<>();
        storeLongArr = new ArrayList<>();
        storeNameArr = new ArrayList<>();
        storeAddressArr = new ArrayList<>();
        storeCityArr = new ArrayList<>();
        storeStateArr = new ArrayList<>();
        storeZipArr = new ArrayList<>();

        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                double lat = Double.parseDouble(parts[0]);
                double lng = Double.parseDouble(parts[1]);
                String name = parts[2];
                String address = parts[3];
                String city = parts[4];
                String state = parts[5];
                String zip = parts[6];

                storeLatArr.add(lat);
                storeLongArr.add(lng);
                storeNameArr.add(name);
                storeAddressArr.add(address);
                storeCityArr.add(city);
                storeStateArr.add(state);
                storeZipArr.add(zip);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < storeLatArr.size(); i++) {
            sb.append(storeNameArr.get(i)).append("\t")
                    .append(storeLatArr.get(i)).append("\t")
                    .append(storeLongArr.get(i)).append("\t")
                    .append(storeAddressArr.get(i)).append("\t")
                    .append(storeCityArr.get(i)).append("\t")
                    .append(storeStateArr.get(i)).append("\t")
                    .append(storeZipArr.get(i)).append("\n");
        }
        return sb.toString();
    }
}