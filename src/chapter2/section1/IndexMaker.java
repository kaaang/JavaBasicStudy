package chapter2.section1;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class IndexMaker {

    static Item[] items = new Item[10000];

//    static String[] words = new String[100000];
//    static int[] count = new int[100000];
    static int n = 0;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        while (true){
            System.out.print("$ ");
            String command = kb.next();

            if(command.equals("read")){
                String fileName = kb.next();
                makeIndex(fileName);
            }else if(command.equals("find")){
                String str = kb.next();
                int index = findWord(str);
                if(index > -1){
                    System.out.println("The word " + items[index].word + " appears " + items[index].count + " times.");
                }else{
                    System.out.println("The word " + str + "does not appears.");
                }
            }else if(command.equals("saveas")){
                String fileName = kb.next();
                saveAs(fileName);
            }else if(command.equals("exit")){
                break;
            }
        }

        kb.close();
    }

    static void saveAs(String fileName){
        PrintWriter outFile;
        try {
            outFile = new PrintWriter(new FileWriter(fileName));
            for (int i=0; i<n; i++){
                outFile.println(items[i].word + " " + items[i].count);
            }
            outFile.close();
        } catch (IOException e) {
            System.out.println("Save filed");
            return;
        }
    }

    static void makeIndex(String fileName){
        try {
            Scanner inFile = new Scanner(new File(fileName));
            while (inFile.hasNext()){
                String str = inFile.next();
                String trimmed = trimming(str);

                if(trimmed != null){
                    String t = trimmed.toLowerCase(Locale.ROOT);
                    addWord(t);
                }
            }
            inFile.close();
        } catch (FileNotFoundException e) {
            return;
        }
    }


    static void addWord(String str){
        int index = findWord(str);

        if(index != -1){ //단어가 이미 존재할때
            items[index].count++;
        }else{
            int i = n-1;
            for(; i>=0 && items[i].word.compareToIgnoreCase(str)>0; i--){
                items[i+1] = items[i];
//                items[i+1].word = items[i].word;
//                items[i+1].count = items[i].count;
            }
            items[i+1] = new Item();
            items[i+1].word = str;
            items[i+1].count = 1;
            n++;
        }
    }

    static int findWord(String str){
        for(int i=0;i<n;i++){
            if(items[i].word.equalsIgnoreCase(str)){
                return i;
            }
        }
        return -1;
    }

    public static String trimming(String str){
        if(str == null || str.length()<=0){
            return null;
        }

        int i=0, j=str.length()-1;
        while (i <= str.length() &&!Character.isLetter(str.charAt(i))){
            i++;
        }
        while (j >= 0 &&!Character.isLetter(str.charAt(j))){
            j--;
        }

        String trimmed = null;
        if(i>j){
            return null;
        }
        trimmed = str.substring(i,j+1);

        return trimmed;
    }


}
