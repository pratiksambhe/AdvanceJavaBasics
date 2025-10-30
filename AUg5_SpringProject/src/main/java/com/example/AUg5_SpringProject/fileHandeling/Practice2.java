package com.example.AUg5_SpringProject.fileHandeling;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Practice2 {
    public static void main(String[] args) {
        Practice2 practice2 = new Practice2();
//        practice2.createDir();
        practice2.createDirByNio();
    }

    //io

    public void createDir() {
        File file = new File("C:\\Users\\Sreenivas Bandaru\\Downloads\\AUg5_SpringProject\\AUg5_SpringProject\\src\\main\\resources\\files");
        if (!file.exists()) {
            file.mkdir();
        } else {
            System.out.println("Directory already exists");
        }
        createFile(file.getAbsolutePath());
    }

    public void createFile(String path) {
        File file = new File(path + "\\file.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("file is already created");
        }
        writeFile(file);
    }

    public void writeFile(File file) {
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write("hey buddy");
            fileWriter.write(System.lineSeparator());
            fileWriter.write("Light WEIGHT");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        readFile(file);
    }

    public void readFile(File file) {
        try (FileReader fileReader = new FileReader(file)) {
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        writeByBuffer(file);
    }

    //Buffer
    public void writeByBuffer(File file) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            bufferedWriter.write(System.lineSeparator());
            bufferedWriter.write("No Pain No Gain");
        } catch (IOException e) {
            throw new RuntimeException();
        }
        readByBuffer(file);
    }

    public void readByBuffer(File file) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String l;
            while ((l = bufferedReader.readLine()) != null) {
                System.out.println(l);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //file by Nio
    public void createDirByNio() {
        Path path = Paths.get("C:\\Users\\Sreenivas Bandaru\\Downloads\\AUg5_SpringProject\\AUg5_SpringProject\\src\\main\\resources\\fileByNio");
        if (!Files.exists(path)) {
            try {
                Files.createDirectory(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Directory already exists");
        }
        createFileByNio(path);
    }

    public void createFileByNio(Path path) {
        Path resolve = path.resolve("fileByNio.txt");
        if(!Files.exists(resolve)){
            try{
            Files.createFile(resolve);
        } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else {
            System.out.println("file alreay created");
        }
    }
}
