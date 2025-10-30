package com.example.AUg5_SpringProject.fileHandeling;



import java.io.*;
import java.util.Scanner;

public class File1 {
    public static void main(String[] args) throws IOException {
        File1 file = new File1();
        file.makeDrirectory();
    }

    public void makeDrirectory() throws IOException {
        File file = new File("C:\\Users\\Sreenivas Bandaru\\Downloads\\Aug7_SpringPractice\\Files");
        if (!file.exists()) {
            file.mkdir();
        } else {
            System.out.println("file exist");
        }
        makeFile(file.getAbsolutePath());
    }

    public void makeFile(String path) throws IOException {
        File file = new File(path + "//file.txt");
        if (!file.exists()) {
            file.createNewFile();
        } else {
            System.out.println("file exists");
        }
        writeFile(file);
    }

    public void writeFile(File file) throws IOException {
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write("hey Buddy");
            fileWriter.write("hey Buddy");
            fileWriter.append("Light Weight");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        readFile(file);
    }
    public void readFile(File file){
        try(FileReader fileReader=new FileReader(file)){
            Scanner scanner=new Scanner(fileReader);
            while(scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
        }catch (IOException e){
            throw  new RuntimeException();
        }
        writeByBuffer(file);
    }
    //write by buffer
    public void writeByBuffer(File file){
        try(BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(file,true))){
            bufferedWriter.write("hello world");
            bufferedWriter.write(System.lineSeparator());
            bufferedWriter.write("hey boss");

        }catch (IOException e){
            throw new RuntimeException();
        }
        readByBuffer(file);
    }
    public void readByBuffer(File file){
        try(BufferedReader bufferedReader =new BufferedReader(new FileReader(file))){
            String l;
            while((l=bufferedReader.readLine())!=null){
                System.out.println(l);
            }
        }catch (IOException e){
            throw  new RuntimeException();
        }
    }
}
