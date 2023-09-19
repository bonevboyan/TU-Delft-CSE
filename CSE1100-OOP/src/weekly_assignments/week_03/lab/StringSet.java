package weekly_assignments.week_03.lab;

class bs {
    public static void main(String[] args) {
        StringSet one = new StringSet(1);
        StringSet other = new StringSet(1);
        one.add(new String("String 1"));
        other.add(new String("String 2"));
        System.out.println(one.equals(other));
    }
}

class StringSet {

    private String[] elements;
    private int amount;

    public StringSet(int n) {
        elements = new String[Math.max(n, 0)];
    }

    public void add(String el) {
        if (amount >= elements.length || this.contains(el)) {
            throw new IllegalArgumentException();
        }

        elements[amount] = el;
        amount++;
    }

    public String get(int i) {
        return isInRange(i) ? elements[i] : null;
    }

    public void set(int i, String el) {
        if (!isInRange(i) || el == null) {
            throw new IllegalArgumentException();
        }
        elements[i] = el;
    }

    public int index(String el) {
        for (int i = 0; i < amount; i++) {
            if (el.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(String el) {
        for (int i = 0; i < amount; i++) {
            if (elements[i].equals(el)) {
                return true;
            }
        }

        return false;
    }

    public int getSize() {
        return amount;
    }

    public boolean equals(Object other) {
        if(other == null || other.getClass() != this.getClass()) {
            return false;
        }

        StringSet list = (StringSet) other;

        if (list.amount != this.amount || list.elements.length != this.elements.length) {
            return false;
        }

        for (int i = 0; i < this.amount; i++) {
            if(this.get(i) == list.get(i)) continue;;

            if (this.get(i) == null || !this.get(i).equals(list.get(i))) {
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

    private boolean isInRange(int n) {
        return (0 <= n && n <= amount);
    }
}