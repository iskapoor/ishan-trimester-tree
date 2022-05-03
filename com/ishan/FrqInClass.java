package com.ishan;

import java.util.Scanner;

class HiddenWord {
    private String word = null;

    public HiddenWord(String word) {
        this.word = word;
    }

    public String getHint(String guess) {
        String output = "";
        for (int i = 0; i < word.length(); i++) {
            if(word.contains("" + guess.charAt(i))) {
                if (word.charAt(i) == guess.charAt(i)) {
                    output += word.charAt(i);
                } else {
                    output += "+";
                }
            } else {
                output += "*";
            }
        }
        return output;
    }


}

public class FrqInClass {

    public static void q1 () {
        int[] arr = {3,1,2,4,5};
        int[][] arr2 = {{3,1,2,4,5},
                        {1,2,3,4,5}
        };
        System.out.println("Sample Array 1: [3, 1, 2, 4, 5] \nRunning arraySum on Sample Array 1 returns: ");
        System.out.println(arraySum(arr) + "\nSample Array 2: [{3,1,2,4,5},{1,2,3,4,5}]. Running rowSums on sample array 2 returns:");
        System.out.println(rowSums(arr2).toString());
        System.out.println("Running isDiverse on the Sample Array 2 returns: ");
        int[] sumArr = rowSums(arr2);
        for (int i = 0; i < sumArr.length; i++) {
            for (int j = i+1; j < sumArr.length; j++) {
                if (sumArr[i] == sumArr[j]) System.out.println("true");
            }
            System.out.println("false");
        }
    }

    public static int arraySum(int[] arr) {
        int sum = 0;
        for(int i : arr) {
            sum+= i;
        }
        return sum;
    }

    public static int[] rowSums(int[][] arr2D) {
        int[] output = new int[arr2D.length];
        int i = 0;
        for (int[] ar : arr2D) {
            output[i] = arraySum(ar);
        }
        return output;
    }

    public static void q2() {
        HiddenWord word = new HiddenWord("coder");
        Scanner sc = new Scanner(System.in);
        while(true) {
            if (sc.nextLine() == "EXIT") break;
            word.getHint(sc.nextLine());
        }

    }

 /*
    public static void q3() {

    }

    public int getValueAt(int row, int col) {
        int output = 0;
        for (SparseArrayEntry e : entries) {
            if (e.getRow() == row && e.getCol() == col) {
                output = e.getValue();
            }
        }
    }

    public void removeColumn(int col) {
        for(SparseArrayEntry e : entries) {
            if (e.getCol() == col) entries.remove(e);
            if (e.getCol() > col) {
                entries.add(new SparseArrayEntry(e.getRow(), e.getCol() - 1, e.getValue()));
                entries.remove(e);
            }
        }
        numCols -= 1;
    }
*/





    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input;
        while (true) {
            System.out.println("Which FRQ would you like to experience? (1/2/3/4/exit)");
            input = s.nextLine();
            if (input.equals("1")) {
                q1();
            } else if (input.equals("2")) {
                q2();
            } else if (input.equals("3")) {
                break;
            } else if (input.equals("4")) {
                break;
            } else if (input.equals("exit")) {
                break;
            }
        }
    }

}
