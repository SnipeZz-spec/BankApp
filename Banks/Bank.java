package Banks;

import Cards.GeneralCard;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<GeneralCard> allCards;


    public Bank() {
        this.allCards = new ArrayList<>();
    }

    public void addCard(GeneralCard card){
        allCards.add(card);
    }

    public boolean transaction(int numberFrom, int numberTo, double sumToTransaction) {
        var cardFrom = getCard(numberFrom);
        var cardTo = getCard(numberTo);

        return cardFrom.makeTransaction(cardTo, sumToTransaction);
    }

//    public boolean pay(int numberFrom, double sumToPay) {
//        var cardFrom = getCard(numberFrom);
//
//        return cardFrom.makePay();
//    }

    private GeneralCard getCard(int number) {
        var curCard = allCards.stream().filter(c -> c.getNumber() == number).findFirst();
        if (curCard.isEmpty()){
            throw new IllegalArgumentException("Такая карта не найдена");
        }
        return curCard.get();
    }







}
