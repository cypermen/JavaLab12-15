package ru.mirea;
import java.util.Scanner;
import java.util.regex.*;


public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //String[] str = ex1(s.nextLine());
        //for (String i: str) {
        //  System.out.println(i);
        //}
        //System.out.println(ex2("abcdefghijklmnopqrstuv18340"));
        //System.out.println(ex2("abcdefghijklmnopqrstu340"));
        //ex3(s.nextLine());
        System.out.println(ex4(s.nextLine()));
    }

    public static String[] ex1(String s){
        String[] result ;
        Pattern p = Pattern.compile("[.]+\\s*");
        result = p.split(s);
        return result;
    }

    public static boolean ex2(String s){
        boolean result;
        Pattern p = Pattern.compile("^abcdefghijklmnopqrstuv18340$");
        result = p.matcher(s).matches();
        return result;
    }


    public static void ex3(String s){
        Pattern p = Pattern.compile("\\d+[.]?\\d?\\d? (USD|RUB|EU)");
        Matcher m = p.matcher(s);
        while(m.find()){
            System.out.println("Цены: " + m.group());
        }
    }
    public static boolean ex4(String s){

        Pattern p = Pattern.compile("([0-3]\\d)[/]([0-1]\\d)[/](\\d{4})");
        boolean b = p.matcher(s).matches();
        int i = Integer.valueOf(s.substring(7));
        if(Integer.valueOf(s.substring(6)) >= 1900 && Integer.valueOf(s.substring(6)) <= 9999 && p.matcher(s).matches()){
           if (Integer.valueOf(s.substring(3,5)) <= 12){
               if (Integer.valueOf(s.substring(3,5)) == 2){
                   if(Integer.valueOf(s.substring(6)) % 4 == 0 && Integer.valueOf(s.substring(6)) % 100 != 0 && Integer.valueOf(s.substring(0,2)) <= 29)
                   {
                       return true;
                   }else if (Integer.valueOf(s.substring(6)) % 400 == 0 && Integer.valueOf(s.substring(0,2)) <= 29){
                       return true;
                   }else if (Integer.valueOf(s.substring(0,2)) <= 28){
                       return true;
                   }
               }else{
                   switch (Integer.valueOf(s.substring(3,5))){
                       case (1):
                       case (3):
                       case (5):
                       case (7):
                       case (8):
                       case (10):
                       case (12):
                           if (Integer.valueOf(s.substring(0,2)) <= 31){
                               return true;
                           }else{
                               return false;
                           }
                       default:

                           if (Integer.valueOf(s.substring(0,2)) <= 30){
                               return true;
                           }else{
                               return false;
                           }

                   }
               }

           }
        }
        return false;
    }

    public static boolean ex5(String s){
        boolean result;
        Pattern p = Pattern.compile("\\w+@\\w+[.]?\\w+");
        result = p.matcher(s).matches();
        return result;
    }

    public static boolean ex6(String s){
        boolean result;
        result = Pattern.matches("\\w{8,}", s) && Pattern.matches("\\w*[A-Z]?\\w*", s);
        result &= Pattern.matches("\\w*[0-9]+\\w*", s) && Pattern.matches("\\w*[a-z]+\\w*", s);
        return result;
    }

}
