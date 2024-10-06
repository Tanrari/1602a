package org.example;

import java.io.IOException;
import java.util.*;

public class Main {

    static int sectorHeight = 0;
    static int sectorWeight = 0;

    public static void main(String[] args) throws IOException {
        sectorHeight = 8;
        sectorWeight = 5;
        ImageConverter imageConverter = new ImageConverter(sectorHeight, sectorWeight, "1.txt");
        ImageSplitter splitter = new ImageSplitter(imageConverter.convertToStringList(), sectorHeight, sectorWeight);
        System.out.println("=============================================================");
        List<Sector> collection = splitter.convertToSectors();
        System.out.println("Получаем результат...." + "\n");
        for (Sector element : collection) {
            for (int i = 0; i < element.getSectorData().size(); i++) {
                System.out.println(element.getSectorData().get(i));
            }
            System.out.println();
        }
        System.out.println("Преобразовываем в байты...." + "\n");

        List<byte[]> list = new ArrayList<>();

        for (int i = 0; i < collection.size(); i++) {
            byte[] bytes = new byte[sectorHeight];
            for (int j = 0; j < collection.get(i).getSectorData().size(); j++) {
                long decimalNumber = Long.parseLong(collection.get(i).getSectorData().get(j), 2);
                bytes[j] = Byte.parseByte(String.valueOf(decimalNumber));
            }
            list.add(bytes);
        }

        System.out.println("Получаем результат в байтах....");
        for (byte[] element: list) {
            System.out.println(Arrays.toString(element));
        }


    }
}


