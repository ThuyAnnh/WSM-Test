package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        Scanner sc = new Scanner("po");
        char c1 = sc.findInLine(".").charAt(0);
        char c2 = sc.findInLine(".").charAt(0);
        System.out.println(c1); // prints "a"
        System.out.println(c2); // prints "a"
//        System.out.println(sc.next()); // prints "bc"
    }
}
