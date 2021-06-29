package com.codegym;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void writeToFile(String path, List<SinhVien> list) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<SinhVien> list = new ArrayList<>();
        list.add(new SinhVien(1, "hung", "hung yen"));
        list.add(new SinhVien(2, "hai", "hung yen"));
        list.add(new SinhVien(3, "thao", "hung yen"));
        list.add(new SinhVien(4, "the", "hung yen"));
        writeToFile("sinhVien.txt", list);
        List<SinhVien> listDataFromFile = readDataFromList("sinhVien.txt");
        for(SinhVien sv:listDataFromFile){
            System.out.println(sv);
        }
    }

    public static List<SinhVien> readDataFromList(String path) {
        List<SinhVien> list = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (List<SinhVien>) ois.readObject();
            fis.close();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
