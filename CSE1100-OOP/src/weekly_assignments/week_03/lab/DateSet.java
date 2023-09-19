package weekly_assignments.week_03.lab;

import java.util.ArrayList;
import java.util.List;

public class DateSet {
    List<Date> dates;

    public DateSet() {
        this.dates = new ArrayList<>();
    }

    public int getDatesSize() {
        return this.dates.size();
    }

    public Date getDate(int i) {
        if (getDatesSize() >= i) {
            throw new IllegalArgumentException();
        }

        return this.dates.get(i);
    }

    public void add(Date date) {
        if (dates.contains(date)) {
            throw new IllegalArgumentException();
        }

        dates.add(date);
    }

    public boolean contains(Date date) {
        return dates.contains(date);
    }

    public DateSet intersection(DateSet other) {
        DateSet intersection = new DateSet();

        for (Date date :
                dates) {
            if (other.dates.contains(date)) {
                intersection.add(date);
            }
        }

        return intersection;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<DateSet: [");

        for (int i = 0; i < this.dates.size(); i++) {
            sb.append(this.dates.get(i)).append(", ");
        }

        sb.append(this.dates.get(this.dates.size() - 1)).append("]>");

        return sb.toString();
    }

    public boolean equals(Object other) {
        if(other == this) return true;

        if(other == null || this.getClass() != other.getClass()) {
            return false;
        }

        DateSet dateSet = (DateSet) other;

        DateSet intersection = dateSet.intersection(this);

        return intersection.getDatesSize() == dates.size() && dates.size() == dateSet.getDatesSize();
    }
}
