package ru.arsen.oop32;

import java.io.*;

public class Model {

    private int a;
    private int b;
    private int c;


    public Model() {
        load();
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        if (0<=a && a<=100) {
            this.a = a;
        }
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {

        this.b = b;

    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public void save(){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("model.txt"))){
            bufferedWriter.write(a + " " + b + " " + c);
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public void load(){
        File file = new File("model.txt");
        if (file.exists()) {
            try (BufferedReader bufferedReader =new BufferedReader(new FileReader(file))){
                String[] values = bufferedReader.readLine().split(" ");
                a = Integer.parseInt(values[0]);
                b = Integer.parseInt(values[1]);
                c = Integer.parseInt(values[2]);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
