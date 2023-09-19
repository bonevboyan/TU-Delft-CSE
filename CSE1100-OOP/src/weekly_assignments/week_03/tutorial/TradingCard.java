package weekly_assignments.week_03.tutorial;

import java.util.Objects;

public class TradingCard {
    String name;
    String rarity;

    public TradingCard(String name, String rarity) {
        this.name = name;
        this.rarity = rarity;
    }

    public String getName() {
        return name;
    }

    public String getRarity() {
        return rarity;
    }

    @Override
    public String toString() {
        return "A " + rarity + " " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TradingCard that = (TradingCard) o;
        return Objects.equals(name, that.name) && Objects.equals(rarity, that.rarity);
    }
}
