class Date implements Comparable<Date> {
    int date;
    int month;
    int year;

    @Override
    public int compareTo(Date o) {
        if (this.year != o.year)
            return this.year > o.year ? 1 : -1;
        if (this.month != o.month)
            return this.month > o.month ? 1 : -1;
        if (this.date != o.date)
            return this.date > o.date ? 1 : -1;
        return 0;
    }

    Date(int date, int month, int year)
    {
        this.date = date;
        this.month = month;
        this.year = year;
    }

    Date(String date)
    {
        // TODO: Implement this fully
    }
}

public class Expense {
    boolean spent;
    Date date;
    String category;
    double amount;
    String note;

    // TODO: Add some constructors here
}
