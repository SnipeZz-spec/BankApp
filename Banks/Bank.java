package Banks;

import Cards.GeneralCard;
import Cards.MaestroCard;
import Cards.PaperWallet;
import Cards.VisaCard;

import javax.print.DocFlavor;
import javax.swing.text.html.Option;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Bank implements Serializable {
    private List<GeneralCard> allCards = new ArrayList<>();
    Banks.Serializable serializable = new Banks.Serializable();

    public void addToList() {
        allCards.add(new VisaCard("Visa",897452345,5, 19, 10000));
        allCards.add(new MaestroCard("Maestro",945299345, 3,23, 0));
        allCards.add(new PaperWallet("SharesWallet", 85412397, 5, 21, 5000));

//        File file = new File("BankList.txt");
//        if (!file.isFile()) {
//            serializable.serialization(allCards, "BankList.txt");
//        } else {
//            serializable.deSerialization("BankList.txt");
//        }
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

//    public boolean transaction(int numberFrom, int numberTo, double sumToTransaction) {
//
//        var cardFrom = getCard(numberFrom);
//        var cardTo = getCard(numberTo);
//        if (cardFrom.isEmpty() | cardTo.isEmpty()) {
//            System.out.println("Данные карты не найдены. Повторите ввод");
//            return false;
//        }
//        return cardFrom.get().makeTransaction(cardTo.get(), sumToTransaction);
//    }
//
//    public boolean pay(int numberFrom, double sumToPay) {
//        var cardFrom = getCard(numberFrom);
//
//        return cardFrom.makePay();
//    }
//
//    private Optional<GeneralCard> getCard(int number) {
//        var curCard = allCards.stream().filter(c -> c.getNumber() == number).findFirst();
//        if (curCard.isEmpty()){
//            return Optional.empty();
//        }
//        return Optional.of(curCard.get());
//    }
//
//    public void informationCard() {
//        System.out.println("");
//    }







}
