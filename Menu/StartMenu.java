package Menu;

import java.util.ArrayList;
import java.util.Scanner;
import Banks.Bank;
import Cards.MaestroCard;
import Cards.VisaCard;


public class StartMenu  {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в бето-программу, Player One!");
        System.out.println("----------------------------------------------");

        while (true){
            Scanner sc = new Scanner(System.in);
            BankApp.Menu.MenuList menuList = new BankApp.Menu.MenuList();
            RegularSpendingHash regularSpending = new RegularSpendingHash();
            Bank bank = new Bank();
            var visaCard = new VisaCard("Visa",987456123,05, 19, 10000);
            var maestroCard = new MaestroCard("Maestro",123456789, 23,23, 0);
            bank.addCard(visaCard);
            bank.addCard(maestroCard);

            menuList.viewMenu1();
            System.out.println("Выберите действие, которое хотите выполнить: ");
            while (!sc.hasNextInt()){
                System.out.println("Выберите действие, которое хотите выполнить: ");
                sc.next();
            }
            int v = sc.nextInt();
            switch (v) {
                case (1):
                    System.out.println("Доступные карты: " + "\n1." + visaCard.getName() + "\n2." + maestroCard.getName() + "\n3.По всем" + "\n0.Выход");
                    System.out.println("Информацию по какой карте вы хотите получить?");
                    while (!sc.hasNextInt()){
                        System.out.println("Информацию по какой карте вы хотите получить?");
                        sc.next();
                    }
                    int v1 = sc.nextInt();
                    switch (v1) {
                        case (1):
                            System.out.println(visaCard.toString());
                            break;
                        case (2):
                            System.out.println(maestroCard.toString());
                            break;
                        case (3):
                            System.out.println(visaCard.toString());
                            System.out.println("-----------------------------------");
                            System.out.println(maestroCard.toString());
                            break;
                        case (0):
                            break;
                        default:
                            System.out.println("Повторите ввод");
                            continue;
                    }
                    break;
                case(2):
                    System.out.println("Операции");
                    System.out.println("-----------------------------------");
                    menuList.viewMenu2();
                    System.out.println("Выберите операцию");
                    while (!sc.hasNextInt()){
                        System.out.println("Выберите операцию");
                        sc.next();
                    }
                    int v3 = sc.nextInt();
                    switch (v3) {
                        case (1):
                            System.out.println("Вы выбрали операцию перевода");
                            System.out.println("-----------------------------------");
                            visaCard.cardList();
                            maestroCard.cardList();
                                System.out.println("С какой карты выполнить перевод?");
                                while (!sc.hasNextInt()) {
                                    System.out.println("Введите карту с которой будет выполнен перевод: ");
                                    sc.next();
                                }
                                int numberFrom = sc.nextInt();
                                System.out.println("На какую карту выполнить перевод?");
                                while (!sc.hasNextInt()) {
                                    System.out.println("Введите карту на которую надо перевести: ");
                                    sc.next();
                                }
                                int numberTo = sc.nextInt();
                                System.out.println("Введите сумму перевода: ");
                                while (!sc.hasNextDouble()) {
                                    System.out.println("Введите сумму перевода: ");
                                    sc.next();
                                }
                                double sum = sc.nextDouble();
                                if (bank.transaction(numberFrom, numberTo, sum)) {
                                    System.out.println("Перевод выполнен!");
                                } else {
                                    System.out.println("Перевод не выполнен! Недостаточно средств.");
                                }
                                break;
                            //операция оплаты
                        case (2):
                            System.out.println("Вы выбрали операцию оплаты");
                            System.out.println("-----------------------------------");
                            menuList.viewMenu3();
                            System.out.println("Какой вид оплаты вы хотите провести?");
                            while (!sc.hasNextInt()){
                                System.out.println("Какой вид оплаты вы хоитите произвести?");
                                sc.next();
                            }
                            int v4 = sc.nextInt();
                            switch (v4) {
                                case (1):
                                    System.out.println("Вы выбрали раздел единоразовой оплаты");
                                    var menu4 = new ArrayList<>();
                                    System.out.println("Введите назначение счета: ");
                                    String purchase = sc.nextLine();
                                    while (!sc.hasNextDouble()){
                                        System.out.println("Введите сумму счета: ");
                                        sc.next();
                                    }
                                    double sum2 = sc.nextDouble();
                                    menu4.add(purchase + sum2);
                                    System.out.println("-----------------------------------");
                                    visaCard.cardList();
                                    maestroCard.cardList();
                                    System.out.println("С какой карты выполнить оплату?");
                                    while (!sc.hasNextInt()){
                                        System.out.println("Выберите карту с которой произвести оплату");
                                        sc.next();
                                    }
                                    int v5 = sc.nextInt();
                                    //вот тут вычисление суммы, спросить правильно ли?
                                    //добавить проверку на наличие средств
                                    switch (v5) {
                                        case (1):
                                            visaCard.payTransaction(sum2);
                                            break;
                                        case (2):
                                            maestroCard.payTransaction(sum2);
                                            break;
                                    }
                                    break;
                                case (2):
                                    System.out.println("Вы выбрали раздел регулярных трат");
                                    while (true) {
                                        regularSpending.viewHash();
                                        System.out.println("Какую из услуг вы бы хотели оплатить?");
                                        String v6 = sc.nextLine();
                                        if (!regularSpending.spendingMap.containsKey(v6)) {
                                            System.out.println("Выбранной вами услуги нет");
                                            continue;
                                        }
                                        visaCard.cardList();
                                        maestroCard.cardList();
                                        System.out.println("С какой карты вы хотите произвести оплату");
                                        while (!sc.hasNextInt()){
                                            System.out.println("Введите карту для оплаты");
                                            sc.next();
                                        }
                                        v5 = sc.nextInt();
                                        switch (v5) {
                                            case (1):
                                                if (visaCard.isBalance() < regularSpending.spendingMap.get(v6)) {
                                                    System.out.println("На данной карте недостаточно средств");
                                                    System.out.println("Выберите другую карту");
                                                    continue;
                                                }
                                                System.out.println("Операция выполненна успешно");
                                                double amount = visaCard.isBalance() - regularSpending.spendingMap.get(v6);
                                                break;
                                            case (2):
                                                if (maestroCard.isBalance() < regularSpending.spendingMap.get(v6)) {
                                                    System.out.println("На данной карте недостаточно средств");
                                                    System.out.println("Выберите другую карту");
                                                    continue;
                                                }
                                                double amount2 = maestroCard.isBalance() - regularSpending.spendingMap.get(v6);
                                                break;
                                        }
                                        break;
                                    }
                                case (0):
                                    break;
                                default:
                                    System.out.println("Повторите ввод");
                                    continue;
                            }
                        break;
                    }
                    break;
                case (3):

                    System.out.println("Вы выбрали ");
            }







        }
    }
}
