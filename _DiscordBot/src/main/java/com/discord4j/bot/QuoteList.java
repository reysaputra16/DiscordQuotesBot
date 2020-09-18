package com.discord4j.bot;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class QuoteList {
    private Random rand;
    private List<String> quotes = new LinkedList<>();
    private List<Integer> numbers = new LinkedList<>();

    public QuoteList(){
        rand = new Random();
        try {
            File file = new File("resources/quotes.txt");
            Scanner scanner = new Scanner(file);
            int mark = 0;
            while(scanner.hasNextLine()) {
                String next = scanner.next();
                if(next.equals("-")) {
                    quotes.set(mark, quotes.get(mark) + "\n- " + scanner.nextLine());
                    mark++;
                } else {
                    quotes.add(next + scanner.nextLine());
                }
            }
        } catch(Exception e) {
            if(e instanceof FileNotFoundException) {
                System.out.println("File is not found.");
            } else {
                System.out.println("No line is left to be parsed.");
            }
        }
    }

    public String getRandomQuote() {
        int temp = rand.nextInt();
        if(temp < 0) {
            temp *= -1;
        }
        temp = temp % quotes.size();
        return quotes.get(temp);
    }
}
