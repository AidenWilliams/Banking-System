package Launcher;

import Users.Administrator;

public class Launcher {
    public static void main (String[] args){
        Administrator administrator = new Administrator();

        administrator.setEmail("Monke");

        System.out.println(administrator.getEmail());
    }
}
