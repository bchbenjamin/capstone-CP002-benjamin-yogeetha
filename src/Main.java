import java.util.ArrayList;
import java.util.Scanner;

// TODO: clean main class and create another Expenses class. I guess this makes main bad

public class Main {
    ArrayList<Expense> expenses = new ArrayList<>();
    public static void main(String[] args) {
        boolean warn = true;
        while (true)
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your choice:\n");
            System.out.println("1. Add an expense with date, category, amount and a short note");
            System.out.println("2. Set a monthly budget for each category");
            System.out.println("3. Warn when a category crosses 80 percent of its budget? Currently "+warn);
            System.out.println("4. Show a month summary: total spent per category against budget");
            System.out.println("5. List the n largest expenses of the month");
            switch (sc.nextInt())
            {
                case 1 -> {
                    setExpense();
                }
                case 2 -> {
                    setBudget();
                }
                case 3 -> {
                    warn = !warn;
                }
                case 4 -> {
                    getSummary();
                }
                case 5 -> {
                    getLargestExpenses(sc.nextInt());
                }
            }
        }
    }

    private static void getSummary() {
    }

    private static void getLargestExpenses(int i) {
    }

    private static void setBudget() {
    }

    private static void setExpense() {
    }
}