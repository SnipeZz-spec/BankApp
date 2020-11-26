package Banks;

import Cards.GeneralCard;

import javax.print.DocFlavor;
import javax.swing.text.html.Option;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Bank implements Serializable {
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







}
