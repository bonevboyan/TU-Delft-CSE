package weekly_assignments.week_03.lab;

public class Person {
    String name;
    DateSet dates;

    public Person(String name) {
        this.name = name;
        this.dates = new DateSet();
    }

    public String getName() {
        return name;
    }

    public DateSet getDates() {
        return dates;
    }

    public void addDate(Date date) {
        if (dates.contains(date)) {
            throw new IllegalArgumentException();
        }

        this.dates.add(date);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;

        if(obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        Person person = (Person) obj;

        return person.getName().equals(this.name) && this.dates.equals(person.getDates());
    }

    @Override
    public String toString() {
        return "<Person: <Name: " + name + ">, " +
                this.dates.toString() + ">";
    }
}
