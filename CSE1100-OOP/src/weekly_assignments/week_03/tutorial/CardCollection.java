package weekly_assignments.week_03.tutorial;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CardCollection {
    Set<TradingCard> collected;
    List<TradingCard> duplicates;

    public CardCollection() {
        collected = new HashSet<>();
        duplicates = new ArrayList<>();
    }

    public void add(CardPack pack) {
        List<TradingCard> cards = pack.unpack();

        for (int i = 0; i < cards.size(); i++) {
            if (!collected.add(cards.get(i))) {
                duplicates.add(cards.get(i));
            }
        }
    }

    public Set<TradingCard> getCollected() {
        return collected;
    }

    public List<TradingCard> getDuplicates() {
        return duplicates;
    }
}
