package weekly_assignments.week_03.lab;

public class Date {
    String date;

    public Date(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public String toString() {
        return "<Date: " + date + ">";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;

        if(obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        Date date = (Date) obj;

        return date.date.equals(this.date);
    }
}
