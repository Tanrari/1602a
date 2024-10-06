package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class ImageConverter {


    int imageHeight = 0;
    int imageWeight = 0;
    private  final String filename;
    private final int sectorHeight;
    private final int sectorWeight;
    int sectorCount = 0;

    public ImageConverter(int sectorHeight, int sectorWeight, String filename) {
        this.sectorHeight = sectorHeight;
        this.sectorWeight = sectorWeight;
        this.filename = filename;
    }

    public LinkedList<String> convertToStringList () throws IOException {
      InputStream inputStream = ImageConverter.class.getClassLoader().getResourceAsStream(filename);
      LinkedList<String> image = new LinkedList<>();

      String line;
      try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))){
                  while ((line = reader.readLine())!=null){
                               image.add(fillEmptySlotsInLine(line));
                              }
       }
        while (image.size()%sectorHeight!=0){
            image.add(fillByHeight(image.get(0).length()));
        }
        imageWeight = image.get(0).length();
        imageHeight= image.size();

        int sectorSquare= sectorHeight*sectorWeight;

        sectorCount = (imageHeight*imageWeight)/sectorSquare;

        System.out.println(imageHeight+" Высота картинки");
        System.out.println(imageWeight+" Ширина картинки");
        System.out.println(sectorCount+ " Количество секторов");
        System.out.println("=================");

        for (String element: image) {
            System.out.println(element);
        }
        return image;
    }


    public String  fillEmptySlotsInLine (String line){
        StringBuilder builder = new StringBuilder(line);
        while (builder.length()%sectorWeight!=0){
            builder.append('0');
        }
        return builder.toString();
    }

    public String fillByHeight(int imageWeight){
        int count =0;
        StringBuilder builder = new StringBuilder();
        while (count<imageWeight){
            builder.append("0");
            count++;
        }
        return builder.toString();
    }

    public int getImageWeight() {
        return imageWeight;
    }

    public int getImageHeight() {
        return imageHeight;
    }

    public int getSectorCount() {
        return sectorCount;
    }
}
