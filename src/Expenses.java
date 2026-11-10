import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class Expenses implements Iterable<Expense> {
    private ArrayList<Expense> expenses = new ArrayList<>();
    private HashMap<String, Integer> categories = new HashMap<>();
    private HashMap<String, Double> budget = new HashMap<>();
    public double total = 0;
    public boolean warn = true;
    public void getSummary() {
        System.out.println(this);
    }

    public Expenses getLargestExpenses(int n) {
        expenses.sort(Expense::compareTo);
        int largest = expenses.toArray().length;
        int smallest = Math.max(0, largest - n);
        Expenses output = new Expenses();
        for (int i = largest-1; i >= smallest; i--)
            output.setExpenses(expenses.get(i));
        return output;
    }

    public boolean setBudget(String key, double value) {
        if (budget.isEmpty() && categories.isEmpty())
        {
            total = Math.max(total, value);
            return value == total;
        }
        if (budget.isEmpty())
        {
            for (String category : categories.keySet())
                budget.put(category, -1.0);
        }
        budget.put(key, value);
        return setOverallBudget();
    }

    private boolean setOverallBudget()
    {
        double a = 0;
        for (String category : budget.keySet())
            a += budget.get(category);
        total = Math.max(a, total);
        return total == a;
    }

    public void setExpense(int year, int month, int day, String category, double amount, String note) {
        expenses.add(new Expense(LocalDate.of(year, month, day), category, amount, note));
        addCategory(category);
    }
    public void setExpense(LocalDate time, String category, double amount, String note) {
        expenses.add(new Expense(time, category, amount, note));
        addCategory(category);
    }
    public void setExpenses(Expense expense)
    {
        expenses.add(expense);
        addCategory(expense.category);
    }
    public void setExpense(int year, int month, int day, String category, double amount) {
        expenses.add(new Expense(LocalDate.of(year, month, day), category, amount, ""));
        addCategory(category);
    }
    public void setExpense(LocalDate time, String category, double amount) {
        expenses.add(new Expense(time, category, amount, ""));
        addCategory(category);
    }
    public void setExpense(String category, double amount) {
        expenses.add(new Expense(LocalDate.now(), category, amount, ""));
        addCategory(category);
    }
    public void setExpense(String category, double amount, String note) {
        expenses.add(new Expense(LocalDate.now(), category, amount, note));
    }

    private void addCategory(String category)
    {
        if (category.trim().isEmpty())
        {
            if (categories.containsKey("Uncategorized"))
                categories.replace("Uncategorized", categories.get("Uncategorized") + 1);
            else {
                categories.put("Uncategorized", 1);
                budget.put("Uncategorized", -1.0);
            }
        }
        else if (categories.containsKey(category))
            categories.replace(category, categories.get(category) + 1);
        else {
            categories.put(category, 1);
            budget.put(category, -1.0);
        }
    }

    public String categories()
        {return categories.toString();}

    @Override
    public String toString()
    {
        StringBuilder output = new StringBuilder("Date \t Category \t Amount\n");
        for (Expense expense : expenses)
            output.append(expense);
        return output.toString();
    }

    @Override
    public Iterator<Expense> iterator() {
        return expenses.iterator();
    }
}
