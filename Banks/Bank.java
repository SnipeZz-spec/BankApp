package Banks;

import Cards.GeneralCard;
import Cards.MaestroCard;
import Cards.VisaCard;

import javax.print.DocFlavor;
import javax.swing.text.html.Option;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Bank implements Serializable {
    private List<GeneralCard> allCards = new ArrayList<>();
    Banks.Serializable serializable = new Banks.Serializable();


//    public Bank() {
//        allCards = new ArrayList<>();
////        var visaCard = new VisaCard("Visa",987456123,05, 19, 10000);
////        var maestroCard = new MaestroCard("Maestro",123456789, 23,23, 0);
////        allCards.add(new VisaCard("Visa",987456123,5, 19, 10000));
////        allCards.add(new MaestroCard("Maestro",123456789, 3,23, 0));
////        serializable.serialization(allCards,"Bank.txt");
////        serializable.deSerialization("Bank.txt");
//    }
    public void addToList() {

        allCards.add(new VisaCard("Visa",987456123,5, 19, 10000));
        allCards.add(new MaestroCard("Maestro",123456789, 3,23, 0));
    }


    public List<GeneralCard> getAllCards() {
        return allCards;
    }

    public void setAllCards(List<GeneralCard> allCards) {
        this.allCards = allCards;
    }

    public void addCard(GeneralCard card){
        allCards.add(card);
    }

    public boolean transaction(int numberFrom, int numberTo, double sumToTransaction) {
        var cardFrom = getCard(numberFrom);
        var cardTo = getCard(numberTo);
        if (cardFrom.isEmpty() | cardTo.isEmpty()) {
            System.out.println("Данные карты не найдены. Повторите ввод");
            return false;
        }
        return cardFrom.get().makeTransaction(cardTo.get(), sumToTransaction);
    }



//    public boolean pay(int numberFrom, double sumToPay) {
//        var cardFrom = getCard(numberFrom);
//
//        return cardFrom.makePay();
//    }

    private Optional<GeneralCard> getCard(int number) {
        var curCard = allCards.stream().filter(c -> c.getNumber() == number).findFirst();
        if (curCard.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(curCard.get());
    }

    public void informationCard() {
        System.out.println("");
    }







}
