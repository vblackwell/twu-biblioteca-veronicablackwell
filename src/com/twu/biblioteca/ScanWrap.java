package com.twu.biblioteca;

import java.util.Scanner;

public class ScanWrap {

    public String scanInput(){
        return new Scanner(System.in).nextLine();
    }

    public void scanClose(){
        new Scanner(System.in).close();
    }
}
