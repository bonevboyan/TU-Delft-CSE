package weekly_assignments.week_03.lab;

import java.util.ArrayList;
import java.util.List;

public class DatePicker {
    List<Person> persons;

    public DatePicker() {
        this.persons = new ArrayList<>();
    }

    public int getPersonsSize() {
        return this.persons.size();
    }

    public Person getPerson(int i) {
        if (this.persons.size() <= i) {
            throw new IllegalArgumentException();
        }

        return this.persons.get(i);
    }

    public void addPerson(Person person) {
        if (persons.contains(person)) {
            throw new IllegalArgumentException();
        }
    }

    public DateSet commonDates() {
        if (persons.size() <= 1) {
            throw new IllegalArgumentException();
        }

        DateSet intersection = persons.get(0).getDates();

        for (int i = 1; i < persons.size(); i++) {
            intersection = intersection.intersection(persons.get(i).getDates());
        }

        return intersection;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<DatePicker: [");

        for (int i = 0; i < this.persons.size() - 1; i++) {
            sb.append(this.persons.get(i)).append(", ");
        }

        sb.append(this.persons.get(this.persons.size() - 1)).append("]");

        return sb.toString();
    }
}
