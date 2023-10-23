package practice_exams.mock_exam;

public enum Rarity {
    NORMAL(1),
    RARE(2),
    EPIC(4),
    LEGENDARY(10);

    private final int value;

    Rarity (int value) {
        this.value = value;
    }

    /**
     * Returns the gold value of the card
     * @return int - the value
     */
    public int getValue() {
        return value;
    }
}
