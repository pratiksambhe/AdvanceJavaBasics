package com.example.AUg5_SpringProject.fileHandeling;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FilePractice  {
    public static void main(String[] args) throws IOException {
    FilePractice practice=new FilePractice();
    practice.nioCreateDir();
    }
    public void makeDr() throws IOException {
        File file=new File("C:\\Users\\Sreenivas Bandaru\\Downloads\\Aug7_SpringPractice\\FilePractice");
        if(!file.exists()){
            file.mkdir();
        }else{
            System.out.println("file Exists");
        }
    makeFile(file.getAbsolutePath());
    }
    public void makeFile(String path) throws IOException {
        File file=new File(path+"//file.txt");
        if(!file.exists()){
        file.createNewFile();}
        else {
            System.out.println("fileExists");
        }
//        writeFile(file);
//        fileRead(file);
        writeByBuffer(file);
          readByBuffer(file);
    }
    public void fileRead(File file){
        try(FileReader fileReader=new FileReader(file)){
            Scanner scanner=new Scanner(fileReader);
            while(scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
        }catch (IOException e){
            throw new RuntimeException();
        }
    }
    public void writeFile(File file){
        try(FileWriter fileWriter=new FileWriter(file)){
            fileWriter.write("kyfhdkjhv uyt");
            fileWriter.write(System.lineSeparator());
            fileWriter.write("xyz");
        }catch(IOException e){
            throw  new RuntimeException();
        }
    }

    public void readByBuffer(File file){
        try(BufferedReader bufferedReader=new BufferedReader(new FileReader(file))){
            String l;
            while((l=bufferedReader.readLine())!=null){
                System.out.println(l);
            }
        }catch (IOException e){
            throw new RuntimeException();
        }
    }
    public void writeByBuffer(File file){
        try(BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(file,true)
        )){
            bufferedWriter.write("pratik");
            bufferedWriter.write(System.lineSeparator());
            bufferedWriter.write("sambhe");
        }catch (IOException e){
            throw new RuntimeException();
        }
    }

    public  void nioCreateDir() throws IOException {
        Path path= Paths.get("C:\\Users\\Sreenivas Bandaru\\Downloads\\Aug7_SpringPractice\\Filess");

        if(!Files.exists(path)){
            Files.createDirectory(path);
        }else {
            System.out.println("already exists");
        }
        nioCreateFile(path);
    }

    public void nioCreateFile(Path path) throws IOException {
        Path resolve = path.resolve("file.txt");
    if(!Files.exists(resolve)){
        Files.createFile(resolve);
    }else{
        System.out.println("exists");
    }
    }
}
