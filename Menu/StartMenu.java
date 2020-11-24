package Menu;

import java.util.ArrayList;
import java.util.Scanner;
import Banks.Bank;
import Cards.MaestroCard;
import Cards.VisaCard;


public class StartMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankApp.Menu.MenuList menuList = new BankApp.Menu.MenuList();
        RegularSpendingHash regularSpending = new RegularSpendingHash();
        Bank bank = new Bank();
        var visaCard = new VisaCard("Visa",987456123,05, 19, 0);
        var maestroCard = new MaestroCard("Maestro",123456789, 23,23, 0);
        bank.addCard(visaCard);
        bank.addCard(maestroCard);


        System.out.println("Добро пожаловать в бето-программу, Player One!");
        System.out.println("----------------------------------------------");
        menuList.viewMenu1();
        System.out.println("Выберите действие, которое хотите выполнить: ");
        int v = sc.nextInt();
        switch (v) {
            case (1):
                System.out.println("Доступные карты: " + "1." + maestroCard.getName() + "\n2." + visaCard.getName() + "\n3.По всем");
                System.out.println("Информацию по какой карте вы хотите получить?");
                int v1 = sc.nextInt();
                switch (v1) {
                    case (1):
                        visaCard.toString();
                        break;
                    case (2):
                        maestroCard.toString();
                        break;
                    case (3):
                        visaCard.toString();
                        System.out.println("-----------------------------------");
                        maestroCard.toString();
                        break;
                }
                break;
            case(2):
                System.out.println("Операции");
                System.out.println("-----------------------------------");
                menuList.viewMenu2();
                System.out.println("Выберите операцию");
                int v3 = sc.nextInt();
                switch (v3){
                    case (1):
                        System.out.println("Вы выбрали операцию перевода");
                        System.out.println("-----------------------------------");
                        visaCard.cardList();
                        maestroCard.cardList();
                        System.out.println("С какой карты выполнить перевод?");
                        int numberFrom = sc.nextInt();
                        //Доделать перевод
                        //Мне кажется можно убрать немного лишней грязи
                        switch (numberFrom) {
                            case (1):
                                System.out.println("Введите сумму перевода: ");
                                double sum = sc.nextDouble();
                                if (bank.transaction(987456123,123456789,0 )) {
                                    System.out.println("Перевод выполнен!");
                                }
                                else {
                                    System.out.println("Перевод не выполнен! Недостаточно средств.");
                                }
                                break;
                            case (2):
                                System.out.println("Введите сумму перевода: ");
                                if (bank.transaction(123456789, 987456123, 0)) {
                                    System.out.println("Перевод выполнен!");
                                }
                                else {
                                    System.out.println("Перевод не выполнен! Недостаточно средств.");
                                }
                                break;
                        }
                        //операция оплаты
                    case (2):
                        System.out.println("Вы выбрали операцию оплаты");
                        System.out.println("-----------------------------------");
                        menuList.viewMenu3();
                        System.out.println("Какой вид оплаты вы хотите провести?");
                        int v4 = sc.nextInt();
                        switch (v4) {
                            case (1):
                                System.out.println("Вы выбрали раздел единоразовой оплаты");
                                var menu4 = new ArrayList<>();
                                System.out.println("Введите назначение счета: ");
                                String purchase = sc.nextLine();
                                System.out.println("Введите сумму счета: ");
                                double sum = sc.nextDouble();
                                menu4.add(purchase + sum);
                                System.out.println("-----------------------------------");
                                visaCard.cardList();
                                maestroCard.cardList();
                                System.out.println("С какой карты выполнить оплату?");
                                int v5 = sc.nextInt();

                                //вот тут вычисление суммы, спросить правильно ли?
                                //добавить проверку на наличие средств
                                switch (v5) {
                                    case (1):
                                        visaCard.payTransaction(sum);
                                        break;
                                    case (2):
                                        maestroCard.payTransaction(sum);
                                        break;
                                }
                                break;
                            case (2):
                                System.out.println("Вы выбрали раздел регулярных трат");
                                regularSpending.viewHash();
                                System.out.println("Какую из услуг вы бы хотели оплатить?");
                                int v6 = sc.nextInt();
                                switch (v6) {
                                    case (1):
                                        System.out.println("Вы выбрали оплату услуги ");
                                }

                        }

                }
        }







    }
}
