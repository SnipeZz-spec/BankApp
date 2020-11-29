package Menu;

import BankApp.Menu.MenuList;
import Banks.BankMethods;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        BankApp.Menu.MenuList menuList = new MenuList();
        BankMethods methods = new BankMethods();


        System.out.println("Добро пожаловать в бето-программу, Player One!");
        System.out.println("----------------------------------------------");


        while (true) {
            Scanner sc = new Scanner(System.in);
            menuList.viewMenu1();
            System.out.println("Введите действие, которое хотите выполнить: ");
            while (!sc.hasNextInt()) {
                System.out.println("Введено некорректное значение! Повторите ввод.");
            }
            int v = sc.nextInt();
            switch (v) {
                case (1):
                    methods.informationOfCard();
                    break;
            }




        }
    }
}
