package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sector {

    private  List<String> sectorData;
    private final int sectorHeight;

    public List<String> getSectorData() {
        return sectorData;
    }

    private final int sectorWeight;

    public Sector(int sectorHeight, int sectorWeight) {
        this.sectorHeight = sectorHeight;
        this.sectorWeight = sectorWeight;
        this.sectorData = new ArrayList<>();
    }

    public void addRowToSector(String row){
        if (sectorData.size()<=sectorHeight) {
            sectorData.add(row);
        }
    }

    @Override
    public String toString() {

        return sectorData.toString();
    }


    public void printSector(){
        for (String element: sectorData) {
            System.out.println(element);
        }
    }
}
