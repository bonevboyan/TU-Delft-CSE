package weekly_assignments.week_03.tutorial;

public class StringList {

    private String[] elements;
    private int amount;

    public StringList(int n) {
        this.elements = new String[Math.max(n, 0)];
    }

    public void add(String el) {
        if (amount >= elements.length) {
            throw new IllegalArgumentException();
        }

        elements[amount] = el;
        amount++;
    }

    public String get(int i) {
        return isInRange(i) ? elements[i] : null;
    }

    public void set(int i, String el) {
        if(!isInRange(i)) {
            throw new IllegalArgumentException();
        }
        elements[i] = el;
    }

    public int index(String el) {
        for (int i = 0; i < amount; i++) {
            if(elements[i].equals(el)) {
                return i;
            }
        }

        return -1;
    }

    public boolean contains(String el) {
        return index(el) != -1;
    }

    public int getSize() {
        return amount;
    }

    public boolean equals(Object other) {
        if(other == null || other.getClass() != this.getClass()) {
            return false;
        }

        StringList list = (StringList) other;

        if (list.amount != this.amount || list.elements.length != this.elements.length) {
            return false;
        }

        for (int i = 0; i < this.amount; i++) {
            if(this.get(i) == list.get(i)) continue;;

            if (this.get(i) == null && !this.get(i).equals(list.get(i))) {
                return false;
            }
        }

        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < this.amount - 1; i++) {
            sb.append(elements[i]).append(", ");
        }

        sb.append(elements[amount - 1]).append("]");

        return sb.toString();
    }

    private boolean isInRange(int i) {
        return i >= 0 && i < this.amount;
    }
}