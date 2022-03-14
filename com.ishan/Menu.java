package com.ishan;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.RunnableFuture;

/*public class Menu {
    String title;
    Runnable action;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        menulist[]

    }

    public menulist(menuobj[] menu) {
        menuobj[] options = menu;

        Scanner sc = new Scanner(System.in);

        Map<Integer, Menu> menu = new HashMap<>();

        menu.put(0, new Menu("Exit", () -> Menu.exit() ) );
        menu.put(1, new Menu("Matrix", () -> Matrix.main(null) ) );
        menu.put(2, new Menu("Calculator", () -> Calculator.main(null) ) );
        menu.put(3, new Menu("IntByReference", () -> IntByReference.main(null) ) );

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
            }

        while (true) {
            System.out.println("-------------------------\n");
            System.out.println("Choose from these choices");
            System.out.println("-------------------------\n");

            for (int i =0; i < options.length; i++) {
                System.out.println((i+1) + " --> " + options[i][0]);
            }
            System.out.println("0 - Quit");
            selection = scan.nextInt();

            if (0 =< selection && selection <= options.length+1) {
                Runnable action = (Runnable) ("() -> "+options[selection][1]  +".main(null)");
                action.run();
                System.out.println();
            }

        }
    }


}

    class menuobj(String title, Runnable action) {
        private String title;
        private Runnable action;

        public void menuobj() {
            this.title = title;
            this.action = action;
        }

        public String getTitle() {
            return title;
        }

        public void setAction(Runnable action) {
            this.action = action;
        }

        public Runnable getAction() {
            return action;
        }

        public void setTitle(String title) {
            this.title = title;
        }

    }*/


public class Menu {
    String title;
    Runnable action;
    private static Boolean done = false;

    public Menu(String title, Runnable action) {
        this.title = title;
        this.action = action;
    }

    public static void exit() {
        done = true;
    }

    public static void main(String[] args) {

        do {
            Scanner sc = new Scanner(System.in);

            Map<Integer, Menu> menu = new HashMap<>();

            menu.put(1, new Menu("Matrix", () -> Matrix.main(null) ) );
            menu.put(2, new Menu("Calculator", () -> Calculator.main(null) ) );
            menu.put(3, new Menu("IntByReference", () -> IntByReference.main(null) ) );
            menu.put(0, new Menu("Exit", () -> Menu.exit() ) );

            System.out.println("-------------------------\n");
            System.out.println("Choose from these choices");
            System.out.println("-------------------------\n");
            for (Map.Entry<Integer, Menu> pair : menu.entrySet()) {
                System.out.println(pair.getKey() + " ==> " + pair.getValue().getTitle());
            }

            if (sc.hasNextInt()) {
                int input = sc.nextInt();
                try {
                    Menu m = menu.get(input);
                    m.getAction().run();
                    System.out.println();
                } catch (Expection e) {
                    System.out.println("Error with input of: " + input);
                }
            }

            System.out.println();
        } while(!done) {
            System.out.println("kinda sus that u want menu again, but ok, here you go: ");
        }
    }
}




