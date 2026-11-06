import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Expenses implements Iterable<Expense> {
    private ArrayList<Expense> expenses = new ArrayList<>();
    private HashMap<String, Integer> categories = new HashMap<>();
    public boolean warn = true;
    public static void getSummary() {

    }

    public static void getLargestExpenses(int i) {
    }

    public static void setBudget() {

    }

    public void setExpense(int year, int month, int day, String category, double amount, String note) {
        expenses.add(new Expense(LocalDate.of(year, month, day), category, amount, note));
        if (categories.containsKey(category))
            categories.replace(category, categories.get(category) + 1);
        else
            categories.put(category, 1);
    }
    public void setExpense(LocalDate time, String category, double amount, String note) {
        expenses.add(new Expense(time, category, amount, note));
        if (categories.containsKey(category))
            categories.replace(category, categories.get(category) + 1);
        else
            categories.put(category, 1);
    }
    public void setExpense(int year, int month, int day, String category, double amount) {
        expenses.add(new Expense(LocalDate.of(year, month, day), category, amount, ""));
        if (categories.containsKey(category))
            categories.replace(category, categories.get(category) + 1);
        else
            categories.put(category, 1);
    }
    public void setExpense(LocalDate time, String category, double amount) {
        expenses.add(new Expense(time, category, amount, ""));
        if (categories.containsKey(category))
            categories.replace(category, categories.get(category) + 1);
        else
            categories.put(category, 1);
    }
    public void setExpense(String category, double amount) {
        expenses.add(new Expense(LocalDate.now(), category, amount, ""));
        if (categories.containsKey(category))
            categories.replace(category, categories.get(category) + 1);
        else
            categories.put(category, 1);
    }
    public void setExpense(String category, double amount, String note) {
        expenses.add(new Expense(LocalDate.now(), category, amount, note));
        if (categories.containsKey(category))
            categories.replace(category, categories.get(category) + 1);
        else
            categories.put(category, 1);
    }

    public String categories()
        {return categories.toString();}

    @Override
    public String toString()
        {return expenses.toString();}
    @Override
    public Iterator<Expense> iterator() {
        return expenses.iterator();
    }
}
