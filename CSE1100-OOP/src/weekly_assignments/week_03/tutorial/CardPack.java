package weekly_assignments.week_03.tutorial;

import java.util.Arrays;
import java.util.List;

public class CardPack {
    TradingCard[] cards;

    public CardPack(TradingCard a, TradingCard b, TradingCard c, TradingCard d){
        cards = new TradingCard[]{a, b, c, d};
    }

    public List<TradingCard> unpack() {
        return Arrays.asList(cards);
    }
}
