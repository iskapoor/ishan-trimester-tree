package com.ishan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.RunnableFuture;

public class Menu {
    String title;
    Runnable action;
    private static Boolean done = false;

    public Menu(String title, Runnable action) {
        this.title = title;
        this.action = action;
    }

    public String getTitle() {
        return this.title;
    }

    public Runnable getAction() {
        return this.action;
    }

    public static void exit() {
        done = true;
    }

    public static void main(String[] args) {
        do {
            Scanner sc = new Scanner(System.in);

            Map<Integer, Menu> menu = new HashMap<>();

            menu.put(0, new Menu("Exit", () -> Menu.exit() ) );
            menu.put(1, new Menu("Matrix", () -> Matrix.main(null) ) );
            menu.put(2, new Menu("Calculator", () -> Calculator.main(null) ) );
            menu.put(3, new Menu("IntByReference", () -> IntByReference.main(null) ) );
            menu.put(4, new Menu("Queue", () -> Q.menu(null) ) );
            menu.put(5, new Menu("Sorts", () -> Sorts.main(null) ) );

          
            System.out.println("Menu:");
            for (Map.Entry<Integer, Menu> pair : menu.entrySet()) {
                System.out.println(pair.getKey() + " ==> " + pair.getValue().getTitle());
            }

            if (sc.hasNextInt()) {
                int input = sc.nextInt();
                if ( input >= 0 && menu.size() > input ) {
                    Menu m = menu.get(input);
                    m.getAction().run();
                    System.out.println();
                } else {
                    System.out.println("Error: Expecting an Integer from 0 to " + (menu.size()-1) );
                }
            } else {
                System.out.println("Error: Expecting an Integer from 0 to " + (menu.size()-1) );
            }
            System.out.println();
        } while(!done);
    }
}