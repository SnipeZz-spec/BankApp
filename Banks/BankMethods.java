package Banks;

import BankApp.Menu.MenuList;
import Cards.MaestroCard;
import Cards.VisaCard;
import Menu.RegularSpendingHash;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BankMethods {
    Bank bank = new Bank();
    Scanner sc = new Scanner(System.in);
    HashMap<String, Double> onetimePayment = new HashMap<>();


    public void informationOfCard(Bank bank) {
        System.out.println("Доступные карты: " + "\n1." + bank.getAllCards().get(0).getName() + "\n2. " + bank.getAllCards().get(1).getName() + "\n3.По всем. " + "\n0.Выход");
        System.out.println("Информацию по какой карте вы хотите получить?");
        while (!sc.hasNextInt()) {
            System.out.println("Некорректный ввод! Повторите попытку");
            sc.next();
        }
        int v = sc.nextInt();
        switch (v) {
            case (1):
                System.out.println(bank.getAllCards().get(0));
                break;
            case (2):
                System.out.println(bank.getAllCards().get(1));
                break;
            case (3):
                System.out.println(bank.getAllCards().get(0).toString());
                System.out.println("---------------------------------------");
                System.out.println(bank.getAllCards().get(1).toString());
                break;
            case (0):
                break;
        }
        System.out.println("---------------------------------------");
    }

    public void transaction(Bank bank) {
        bank.addToList();
        System.out.println("Вы выбрали операцию перевода");
        System.out.println("---------------------------------------");
        bank.getAllCards().get(0).cardList();
        bank.getAllCards().get(1).cardList();
        System.out.println("С какой карты выполнить перевод?");
        while (!sc.hasNextInt()) {
            System.out.println("Некорректный ввод! Повторите попытку");
            sc.next();
        }
        int v = sc.nextInt();
        switch (v) {
            case (1):
                System.out.println("Введите сумму перевода");
                while (!sc.hasNextDouble()) {
                    System.out.println("Некорректное значение!");
                    sc.next();
                }
                double sum = sc.nextDouble();
                if (bank.getAllCards().get(0).isBalance() < sum) {
                    System.out.println("Операция не выполнена! Недостаточно средств.");
                    break;
                }
                System.out.println("Операция выполненна успешно!");
                bank.getAllCards().get(0).setBalance(bank.getAllCards().get(0).isBalance() - sum);
                bank.getAllCards().get(1).setBalance(bank.getAllCards().get(1).isBalance() + sum);
                System.out.println("---------------------------------------");
                break;
            case (2):
                System.out.println("Введите сумму перевода");
                while (!sc.hasNextDouble()) {
                    System.out.println("Некорректное значение!");
                    sc.next();
                }
                sum = sc.nextDouble();
                if (bank.getAllCards().get(1).isBalance() < sum) {
                    System.out.println("Операция не выполнена! Недостаточно средств.");
                    break;
                }
                System.out.println("Операция выполненна успешно!");
                bank.getAllCards().get(0).setBalance(bank.getAllCards().get(0).isBalance() + sum);
                bank.getAllCards().get(1).setBalance(bank.getAllCards().get(1).isBalance() - sum);
                System.out.println("---------------------------------------");
                break;
            case (0):
                break;
        }
        System.out.println("---------------------------------------");
    }

    public void payOperation(Bank bank){
        bank.addToList();
        BankApp.Menu.MenuList menuList = new MenuList();
        RegularSpendingHash spendingHash = new RegularSpendingHash();
        System.out.println("Вы выбрали операцию оплаты");
        System.out.println("---------------------------------------");
        menuList.viewMenu3();
        System.out.println("Выберите какой вид оплаты вы хотите произвести?");
        while (!sc.hasNextInt()) {
            System.out.println("Некорректный ввод! Повторите попытку");
            sc.next();
        }
        int v = sc.nextInt();
        switch (v) {
            case (1):
                System.out.println("Вы выбрали раздел единоразовой оплаты");
                System.out.println("---------------------------------------");
                System.out.println("Введите назначение счета: ");
                String purchase = sc.nextLine();
                System.out.println("Введите сумму счета: ");
                while (!sc.hasNextDouble()){
                    System.out.println("Некорректный ввод! Повторите попытку");
                    sc.next();
                }
                double sum = sc.nextDouble();
                onetimePayment.put(purchase, sum);
                bank.getAllCards().get(0).cardList();
                bank.getAllCards().get(1).cardList();
                System.out.println("С какой карты выполнить оплату?");
                while (!sc.hasNextInt()) {
                    System.out.println("Некорректный ввод! Повторите попытку");
                    sc.next();
                }
                v = sc.nextInt();
                switch (v) {
                    case (1):
                        if (bank.getAllCards().get(0).isBalance() < sum) {
                            System.out.println("Операция не выполнена! Недостаточно средств на карте");
                            break;
                        }
                        System.out.println("Операция выполненна успешно!");
                        bank.getAllCards().get(0).setBalance(bank.getAllCards().get(0).isBalance() - sum);
                        break;
                    case (2):
                        if (bank.getAllCards().get(1).isBalance() < sum) {
                            System.out.println("Операция не выполнена! Недостаточно средств на карте");
                            break;
                        }
                        System.out.println("Операция выполненна успешно!");
                        bank.getAllCards().get(1).setBalance(bank.getAllCards().get(1).isBalance() - sum);
                        break;
                }
                break;
            case (2):
                System.out.println("Вы выбрали раздел регулярных трат");
                System.out.println("---------------------------------------");
                while (true) {
                    spendingHash.viewHash();
                    System.out.println("Выберите услугу которую хотите оплатить");
                    String vStr = sc.nextLine();
                    if (!spendingHash.spendingMap.containsKey(vStr)) {
                        System.out.println("Выбранной вами услуги нет. Повторите ввод");
                        continue;
                    }
                    bank.getAllCards().get(0).cardList();
                    bank.getAllCards().get(1).cardList();
                    System.out.println("С какой карты выполнить оплату?");
                    while (!sc.hasNextInt()) {
                        System.out.println("Некорректный ввод! Повторите попытку");
                        sc.next();
                    }
                    v = sc.nextInt();
                    switch (v) {
                        case (1):
                            if (bank.getAllCards().get(0).isBalance() < spendingHash.spendingMap.get(vStr)) {
                                System.out.println("Операция не выполнена! Недостаточно средств на карте");
                                break;
                            }
                            System.out.println("Операция выполненна успешно!");
                            bank.getAllCards().get(0).setBalance(bank.getAllCards().get(0).isBalance() - spendingHash.spendingMap.get(vStr));
                            break;
                        case (2):
                            if (bank.getAllCards().get(1).isBalance() < spendingHash.spendingMap.get(vStr)) {
                                System.out.println("Операция не выполнена! Недостаточно средств на карте");
                                break;
                            }
                            System.out.println("Операция выполненна успешно!");
                            bank.getAllCards().get(1).setBalance(bank.getAllCards().get(1).isBalance() - spendingHash.spendingMap.get(vStr));
                            break;
                    }
                    break;
                }
        }
        System.out.println("---------------------------------------");
    }

    public void replenishmentCard (Bank bank){
        System.out.println("Вы выбрали раздел пополнения карт");
        System.out.println("---------------------------------------");
        bank.getAllCards().get(0).cardList();
        bank.getAllCards().get(1).cardList();
        System.out.println("Какую из карт произвести зачисление?");
        while (!sc.hasNextInt()){
            System.out.println("Некорректный ввод! Повторите попытку");
            sc.next();
        }
        int v = sc.nextInt();
        switch (v) {
            case (1):
                System.out.println("Введите сумму зачисления");
                while (!sc.hasNextDouble()){
                    System.out.println("Введено некорректное значение! Повторите попытку");
                    sc.next();
                }
                double sum = sc.nextDouble();
                System.out.println("Зачисление прошло успешно!");
                bank.getAllCards().get(0).setBalance(bank.getAllCards().get(0).isBalance() + sum);
                break;
            case (2):
                System.out.println("Введите сумму зачисления");
                while (!sc.hasNextDouble()){
                    System.out.println("Введено некорректное значение! Повторите попытку");
                    sc.next();
                }
                sum = sc.nextDouble();
                System.out.println("Зачисление прошло успешно!");
                bank.getAllCards().get(1).setBalance(bank.getAllCards().get(1).isBalance() + sum);
                break;
        }
        System.out.println("---------------------------------------");
    }

}
