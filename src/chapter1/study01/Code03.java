package chapter1.study01;

import java.util.Scanner;

public class Code03 {
    public static void main(String[] args) {
        String str = "Hello";
        String input = null;

        Scanner kb = new Scanner(System.in);
        System.out.println("Please type a string : ");

        input = kb.next();

//        if(str == input){
        if(str.equals(input)){
            System.out.println("Strings match! :-)");
        }else{
            System.out.println("String do not match! :-(");
        }

        kb.close();
    }
}
