import java.time.LocalDate;
import java.util.*;

public class Expenses implements Iterable<Expense> {
    private ArrayList<Expense> expenses = new ArrayList<>();
    private HashMap<String, Integer> categories = new HashMap<>();
    private HashMap<String, Double> budget = new HashMap<>();
//    public double total = Double.MAX_VALUE;
    public boolean warn = true;

    private String summaryLines(String category, double spent, double budget)
        {return "\n"+category+"\t"+spent+"\t"+budget;}

    public String getSummary()
    {
        Expenses e = getThisMonthExpenses();
        HashMap<String, Double> categories = new HashMap<>();
        for (Expense ex : e)
            if (categories.containsKey(ex.category))
                categories.replace(ex.category, categories.get(ex.category) + ex.amount);
            else
                categories.put(ex.category, ex.amount);
        StringBuilder output = new StringBuilder("Category\tAmount Spent\t");
        for (String s : categories.keySet())
            {output.append(summaryLines(s, categories.get(s), this.budget.get(s)));}
        return "" + output;
    }

    public Expenses getLargestExpenses(int n) {
        expenses.sort(Expense::compareTo);
        int largest = expenses.toArray().length-1;
        int smallest = Math.max(-1, largest - n);
        Expenses output = new Expenses();
        for (int i = largest; i > smallest; i--)
            output.setExpenses(expenses.get(i));
        return output;
    }

    public Expenses getThisMonthExpenses()
    {
        Expenses output = new Expenses();
        for (Expense e : expenses)
            if (inTheSameMonth(e.date))
                output.setExpenses(e);
        return output;
    }

    public static boolean inTheSameMonth(LocalDate other)
        {return other.getDayOfMonth() == LocalDate.now().getDayOfMonth() && other.getDayOfYear() == LocalDate.now().getDayOfYear();}

    public int setBudget(String category, double budget_value) {
        /**
         * returns 1 if the budget is set successfully
         * returns 0 if the budget was set but the user needs to be warned (80+% of the budget has been spent)
         * returns -1 if the budget was not set.
         */
        double spentBudget = 0.0;
        for (Expense e : expenses)
            if (e.category.equals(category) && inTheSameMonth(e.date))
                spentBudget += e.amount;
        if (warn)
        {
            if (spentBudget > budget_value)
                return -1;
            else if (spentBudget > ((4/5) * budget_value)) {
                budget.replace(category, budget_value);
                return 0;
            }
            else
                budget.replace(category, budget_value);
            return 1;
        }
        else
        {
            if (spentBudget > budget_value)
                return -1;
            else
                budget.replace(category, budget_value);
            return 1;
        }
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

    public static boolean isValidCategory(String category)
    {
        if (category.trim().isEmpty())
            return false;
        else if (category.contains(" "))
            return false;
        return true;
    }

    private void addCategory(String category)
    {
        if (!isValidCategory(category))
            this.addCategory("Uncategorized");
        else if (categories.containsKey(category))
            categories.replace(category, categories.get(category) + 1);
        else {
            categories.put(category, 1);
            budget.put(category, Double.MAX_VALUE);
        }
    }

    public String categories()
        {return categories.toString();}

    public Set<String> getCategories()
        {return categories.keySet();}

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
