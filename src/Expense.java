import java.time.LocalDate;

public class Expense implements Comparable<Expense> {
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
        else
            return -1;
    }

    Expense(LocalDate date, String category, double amount, String note)
    {
        if (date.isAfter(LocalDate.now()))
            this.date = LocalDate.now();
        else
            this.date = date;
        this.category = category;
        this.amount = amount;
        this.note = note;
    }

    @Override
    public String toString()
    {
        if (note.isEmpty())
            return date+"\t"+category+"\t"+amount+"\n";
        else
            return date+"\t"+category+"\t"+amount+"\nNote: "+note+"\n";
    }
}

/**
 * Date | Category | Amount | Note
 * object
 * Note: <Note></Note>
 * object2
 */