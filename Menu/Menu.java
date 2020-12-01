package Menu;

import BankApp.Menu.MenuList;
import Banks.Bank;
import Banks.BankMethods;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        BankApp.Menu.MenuList menuList = new MenuList();
        BankMethods methods = new BankMethods();
        Bank bank = new Bank();
        bank.addToList();

        System.out.println("Добро пожаловать в бета-программу, Player One!");
        System.out.println("----------------------------------------------");
        while (true) {
            Scanner sc = new Scanner(System.in);
            menuList.viewMenu1();
            System.out.println("Введите действие, которое хотите выполнить: ");
            while (!sc.hasNextInt()) {
                System.out.println("Введено некорректное значение! Повторите ввод.");
                sc.next();
            }
            int v = sc.nextInt();
            switch (v) {
                case (1):
                    System.out.println("---------------------------------------");
                    System.out.println("---------------Информация--------------");
                    System.out.println("---------------------------------------");
                    methods.informationOfCard(bank);
                    break;
                case (2):
                    System.out.println("---------------------------------------");
                    System.out.println("---------------Операции----------------");
                    System.out.println("-------Вы выбрали раздел операций------");
                    menuList.viewMenu2();
                    System.out.println("-----------Выберите операцию-----------");
                    while (!sc.hasNextInt()) {
                        System.out.println("Введено некорректное значение! Повторите ввод.");
                        sc.next();
                    }
                    int v2 = sc.nextInt();
                    switch (v2) {
                        case (1):
                            methods.transaction(bank);
                            break;
                        case (2):
                            methods.payOperation(bank);
                            break;
                        case (3):
                            methods.viewOnePayment();
                            break;
                    }
                    break;
                case (3):
                    System.out.println("---------------------------------------");
                    System.out.println("-----------Пополнение карты------------");
                    methods.replenishmentCard(bank);
                    break;
                case (4):
                    System.out.println("---------------------------------------");
                    System.out.println("---------------Кошелек-----------------");
                    methods.walletOperation(bank);
                    break;
                case (0):
                    break;
            }
        }
    }
}
