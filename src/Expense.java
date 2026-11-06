import java.time.LocalDate;

public class Expense implements Comparable<Expense> {
    boolean spent;
    LocalDate date;
    String category;
    double amount;
    String note;

    @Override
    public int compareTo(Expense o) {
        if (this.amount == o.amount)
            return 0;
        else if (this.amount > o.amount)
            return 1;
        else return -1;
    }
    Expense(LocalDate date, String category, double amount, String note)
    {
        this.date = date;
        this.category = category;
        this.amount = amount;
        this.note = note;
    }
}
