package com.company;
import javax.annotation.processing.Filer;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.File;

public class Game {

    public static void main(String[] args) throws FileNotFoundException {
        GameLogic gl = new GameLogic();
        int[] arrayPC = gl.randomChisla();
        int[] arrayIgroka;
        int countbl, countcw;
        int truesCount = 0;
        int gameCount = 1;
        String matches;
        File file = new File("log.txt");
        String regex = "(?<=#)[0-9]*";
        Pattern pattern = Pattern.compile(regex);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            scanner.nextLine();
            matches = scanner.findInLine(pattern);
            if (matches != null) {
                gameCount = Integer.parseInt(matches) + 1;
            }
        }
        try(FileWriter writer = new FileWriter("log.txt", true))
        {
            Date date = new Date ();
            SimpleDateFormat formatDate = new SimpleDateFormat("dd.MM.yyyy HH:mm");
            String textIgri = "\nGame #" + gameCount + " " + formatDate.format(date) + " Загаданная строка - " + Arrays.toString(arrayPC) + "\n";
            writer.write(textIgri);
            writer.flush();
            do {
                arrayIgroka = gl.vvodIgroka();
                countcw = gl.gameCointCows(arrayIgroka, arrayPC);
                countbl = gl.gameCountBulls(arrayIgroka, arrayPC);
                truesCount++;
                String textZaprosa = ("\tЗапрос: " + Arrays.toString(arrayIgroka) + " " + countbl + " " + gl.grammatikaBulls(countbl) + " и " +countcw + " " + gl.grammatikaCows(countcw))+ "\n";
                writer.write(textZaprosa);
                System.out.println(textZaprosa);
            } while (countbl != 4);
            String tryess = ("\tСтрока была угадана за " + truesCount + " " + gl.tryes(truesCount))+ "\n";
            System.out.println(tryess);
            writer.write(tryess);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}

