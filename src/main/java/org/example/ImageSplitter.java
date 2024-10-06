package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ImageSplitter {


    private final List<String> image;
    private final int sectorHeight;
    private final int sectorWeight;


    public ImageSplitter(List<String> image, int sectorHeight, int sectorWeight) {
        this.image = image;
        this.sectorHeight = sectorHeight;
        this.sectorWeight = sectorWeight;
    }

    public List<Sector> convertToSectors() {
        LinkedList<Sector> sectorList = new LinkedList<>();
        for (int i = 0; i < image.size(); i += sectorHeight) {
            for (int col = 0; col < image.get(i).length(); col += sectorWeight) {
                Sector sector = new Sector(sectorHeight,sectorWeight);
               // int countRow=0;
                for (int row = i; row < i + sectorHeight; row++) {
                  //  if (countRow<sectorHeight) {
                        String line = image.get(row).substring(col, Math.min(col + sectorWeight, image.get(i).length()));
                        sector.addRowToSector(line);
                 //       countRow++;
                   // }
                }
                sectorList.add(sector);
            }
        }

        return sectorList;
    }


}



