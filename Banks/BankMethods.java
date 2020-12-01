package Banks;

import BankApp.Menu.MenuList;
import Cards.MaestroCard;
import Cards.VisaCard;
import Menu.RegularSpendingHash;
import Menu.SharesHash;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.spi.AbstractResourceBundleProvider;

public class BankMethods {
    Bank bank = new Bank();
    Scanner sc = new Scanner(System.in);
    HashMap<String, Double> onetimePayment = new HashMap<>();
    HashMap<String, Double> mySharesMap = new HashMap<>();




    public void informationOfCard(Bank bank) {
        System.out.println("Доступные карты: " + "\n1." + bank.getAllCards().get(0).getName() + "\n2. " + bank.getAllCards().get(1).getName() + "\n3.По всем. " + "\n4.По кошельку" + "\n0.Выход");
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
                System.out.println(bank.getAllCards().get(0));
                System.out.println("---------------------------------------");
                System.out.println(bank.getAllCards().get(1));
                break;
            case (4):
                System.out.println(bank.getAllCards().get(2));
            case (0):
                break;
        }
        System.out.println("---------------------------------------");
    }

    public void transaction(Bank bank) {
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
                double sum2 = sc.nextDouble();
                if (bank.getAllCards().get(1).isBalance() < sum2) {
                    System.out.println("Операция не выполнена! Недостаточно средств.");
                    break;
                }
                System.out.println("Операция выполненна успешно!");
                bank.getAllCards().get(0).setBalance(bank.getAllCards().get(0).isBalance() + sum2);
                bank.getAllCards().get(1).setBalance(bank.getAllCards().get(1).isBalance() - sum2);
                System.out.println("---------------------------------------");
                break;
            case (0):
                break;
        }
        System.out.println("---------------------------------------");
    }

    public void payOperation(Bank bank){
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
                int v1 = sc.nextInt();
                switch (v1) {
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

    public void viewOnePayment() {
        if (onetimePayment.isEmpty()){
            System.out.println("Список ваших покупок пуст");
        }
        else {
            System.out.println("Список совершенных единоразовых покупок");
            System.out.println(onetimePayment);
            System.out.println("---------------------------------------");
        }
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
                double sum2 = sc.nextDouble();
                System.out.println("Зачисление прошло успешно!");
                bank.getAllCards().get(1).setBalance(bank.getAllCards().get(1).isBalance() + sum2);
                break;
        }
        System.out.println("---------------------------------------");
    }


    public void walletOperation(Bank bank) {
        MenuList menuList = new MenuList();
        SharesHash hash = new SharesHash();
        System.out.println("Вы выбрали раздел работы с ценными бумагами");
        System.out.println("---------------------------------------");
        bank.getAllCards().get(2).cardList();
        menuList.walletOperationList();
        System.out.println("Выберите операцию, которую хотите совершить: ");
        while (!sc.hasNextInt()) {
            System.out.println("Неккоректный ввод! Повторите попытку");
            sc.next();
        }
        int v = sc.nextInt();
        switch (v) {

            case (1):
                System.out.println("Вы выбрали раздел покупки акций");
                System.out.println("---------------------------------------");
                while (true) {
                    System.out.println("Доступные к покупке акции: ");
                    hash.viewShares();
                    System.out.println("---------------------------------------");
                    System.out.println("Введите название компании акции которой вы бы хотел приобрести: ");
                    var str = sc.nextLine();
                    if (!hash.sharesHashMap.containsKey(str)){
                        System.out.println("Такой акции не найдено. Повторите ввод");
                        continue;
                    }
                    System.out.println("Примечание: при покупке ценных бумаг, происходит покупка не единой акции, а лота из 10 единиц!");
                    System.out.println("---------------------------------------");
                    bank.getAllCards().get(0).cardList();
                    bank.getAllCards().get(1).cardList();
                    System.out.println("Выберите карту с которой произвести оплату:");
                    while (!sc.hasNextInt()){
                        System.out.println("Ошибка ввода! Повторите попытку");
                        sc.next();
                    }
                    int v1 = sc.nextInt();
                    switch (v1) {
                        case (1):
                            if (bank.getAllCards().get(0).isBalance() < hash.sharesHashMap.get(str)) {
                                System.out.println("Операция не выполнена! Недостаточно средств на карте");
                                System.out.println("---------------------------------------");
                                break;
                            }
                            System.out.println("Покупка завершена успешно!");
                            mySharesMap.put(str, hash.sharesHashMap.get(str));
                            bank.getAllCards().get(0).setBalance(bank.getAllCards().get(0).isBalance() - (hash.sharesHashMap.get(str) * 10));
                            bank.getAllCards().get(2).setBalance(bank.getAllCards().get(2).isBalance() + (hash.sharesHashMap.get(str) * 10));
                            System.out.println("---------------------------------------");
                            break;
                        case (2):
                            if (bank.getAllCards().get(1).isBalance() < hash.sharesHashMap.get(str)) {
                                System.out.println("Операция не выполнена! Недостаточно средств на карте");
                                System.out.println("---------------------------------------");
                                break;
                            }
                            System.out.println("Покупка завершена успешно!");
                            mySharesMap.put(str, hash.sharesHashMap.get(str));
                            bank.getAllCards().get(1).setBalance(bank.getAllCards().get(1).isBalance() - (hash.sharesHashMap.get(str) * 10));
                            bank.getAllCards().get(2).setBalance(bank.getAllCards().get(2).isBalance() + (hash.sharesHashMap.get(str) * 10));
                            System.out.println("---------------------------------------");
                            break;
                    }break;
                }
                break;

            case (2):
                System.out.println("Вы выбрали раздел продажи акций акций");
                System.out.println("---------------------------------------");
                while (true){
                    if (mySharesMap.isEmpty()){
                        System.out.println("У вас пока нет акций, которые можно продать");
                        System.out.println("---------------------------------------");
                        break;
                    }
                    viewShares();
                    System.out.println("Выберите какую из акций вы бы хотели продать?");
                    System.out.println("---------------------------------------");
                    var str1 = sc.nextLine();
                    while (!mySharesMap.containsKey(str1)){
                        System.out.println("Такой акции не найдено. Повторите ввод");
                        continue;
                    }
                    System.out.println("Продажа завершена успешно! На счет второй карты произведено зачисление");
                    bank.getAllCards().get(2).setBalance(bank.getAllCards().get(2).isBalance() - (mySharesMap.get(str1) * 10));
                    bank.getAllCards().get(1).setBalance(bank.getAllCards().get(1).isBalance() + (mySharesMap.get(str1) * 10));
                    mySharesMap.remove(str1);
                    System.out.println("---------------------------------------");
                    break;

                }
                break;
            case (3):
                while (true) {
                    System.out.println("Вы выбрали раздел ваших акций");
                    System.out.println("---------------------------------------");
                    if (mySharesMap.isEmpty()) {
                        System.out.println("У вас пока нет ни одной акции");
                        System.out.println("---------------------------------------");
                        break;
                    }
                    viewSharesNow();
                    break;
                }
            case (0):
                break;
        }
    }

    public void viewShares() {
        System.out.println("Доступные к продаже акции: ");
        System.out.println(mySharesMap);
    }

    public void viewSharesNow() {
        System.out.println("Ваши акции: ");
        System.out.println(mySharesMap);
    }



}
