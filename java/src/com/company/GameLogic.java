package com.company;

import com.sun.org.apache.xalan.internal.xsltc.dom.SimpleResultTreeImpl;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class GameLogic {
//    int[] arrayIgroka = new int[4];
//    int[] arrayPC = new int[4];
//
//    public void startGame(){
//        this.randomChisla();
//        this.vvodIgroka();
//
//
//    }




    public int[] randomChisla(){
        int[] arrayPC = new int[4];
            do {
                for (int i = 0; i < arrayPC.length; i++){
                    arrayPC[i] = (int) Math.round(Math.random() * 9);
                }
            } while (arrayPC[0]==arrayPC[1] || arrayPC[0]==arrayPC[2] || arrayPC[0]==arrayPC[3] || arrayPC[1]==arrayPC[2] || arrayPC[1]==arrayPC[3] || arrayPC[2]==arrayPC[3]);
       /* for (int i = 0; i < arrayPC.length; i++) {
            System.out.println(arrayPC[i]);
        }*/
        System.out.println(Arrays.toString(arrayPC));
        return arrayPC;
    }


    public int[] vvodIgroka(){
        String chisla;
        boolean ok;
        int[] arrayIgroka = new int[4];
        do {
            System.out.println("Введите 4 числа");
            Scanner scanner = new Scanner(System.in);
            chisla = scanner.nextLine();
            String regexp = "[0-9]*";
            ok = Pattern.matches(regexp, chisla);//сравниваем
        } while (chisla.length() != 4 || !ok);
        String[] ary = chisla.split("");
        for (int i = 0; i < ary.length; i++) {
            arrayIgroka[i] = Integer.parseInt(ary[i]);
            //System.out.println(arrayPCIgroka[i]);
        }
        return arrayIgroka;
    }


    public void writeFile(){

    }

    public int gameCountBulls(int[] arrayIgroka, int[] arrayPC){
        int countBulls = 0;
        for (int i = 0; i<arrayPC.length; i++) {
            if (arrayPC[i] == arrayIgroka[i]) {
                countBulls++;
            }
        }
        //System.out.println(countBulls);
        return countBulls;
    }
    public int gameCointCows(int[] arrayIgroka, int[] arrayPC){
       int countCows = 0;
        for (int i = 0; i < arrayPC.length; i++) {
            int n;
            for (n=0; n< arrayIgroka.length; n++) {
                if (n != i && arrayIgroka[n] == arrayPC[i]) {
                    countCows++;
                    break;
                }
            }
        }
        return countCows;
    }
    public String grammatikaBulls(int countBulls){
        if (countBulls==0)
            return "быков";
        else if (countBulls==1)
            return "бык";
        else
            return "быка";

    }
    public String grammatikaCows(int countCows){
        if (countCows==0)
            return "коров";
        else if (countCows==1)
            return "корова";
        else
            return "коровы";
    }
    public String tryes(int truesCount){
        if (truesCount==1)
            return "попытку";
        else if (truesCount==2 || truesCount==3 || truesCount==4)
            return "попытки";
        else
            return "попыток";
    }


}

