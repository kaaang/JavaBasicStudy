package chapter1.study01;

import java.util.Scanner;

public class Code14 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int [] data = new int [n];

        for(int i=0;i<n;i++){
            data[i] = kb.nextInt();
        }
        kb.close();

        
    }
}
