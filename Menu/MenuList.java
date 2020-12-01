package BankApp.Menu;

import Cards.GeneralCard;
import Cards.VisaCard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuList {


    public void viewMenu1() {
        var menu1 = new ArrayList<>();
        menu1.add("1.Информация по картам и кошелькам");
        menu1.add("2.Операции");
        menu1.add("3.Пополнение карты");
        menu1.add("4.Работа с кошельком");
        menu1.add("0.Выход");

        for (var s: menu1) {
            System.out.println(s);
        }
    }


    public void viewMenu2() {
        var menu2 = new ArrayList<>();
        menu2.add("1.Перевод");
        menu2.add("2.Оплата");
        menu2.add("3.Список единоразовых покупок");
        menu2.add("0.Выход");

        for (var s : menu2) {
            System.out.println(s);
        }
    }

    public void viewMenu3() {
        var menu3 = new ArrayList<>();
        menu3.add("1.Одноразовая оплата счета");
        menu3.add("2.Оплата регулярных счетов");

        for (var s : menu3 ) {
            System.out.println(s);
        }
    }

    //данный метод записывает в лист траты, которые происходят единожды
    public void payOperation() {
        Scanner sc = new Scanner(System.in);
        var menu4 = new ArrayList<>();
        System.out.println("Введите назначение счета: ");
        String purchase = sc.nextLine();
        System.out.println("Введите сумму счета: ");
        double sum = sc.nextDouble();
        menu4.add(purchase + sum);
    }




    //тут же метод показывающий эти траты
    public void viewPurchases() {

    }

    public void walletOperationList(){
        var menu = new ArrayList<>();
        menu.add("1.Купить акции");
        menu.add("2.Продать акции");
        menu.add("3.Мои бумаги");
        menu.add("0.Выход");

        for (var s: menu) {
            System.out.println(s);
        }
    }

    //под-лист регулярных счетов
    public void viewMenu5() {
        var menu5 = new ArrayList<>();
        menu5.add("");
    }

}
