import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        while (true)
        {
            Scanner sc = new Scanner(System.in);
            Expenses ex = new Expenses();
            System.out.print("\033[H\033[2J");
            System.out.println("Enter your choice:\n");
            System.out.println("1. Add an expense with date, category, amount and a short note");
            System.out.println("2. Set a monthly budget for each category");
            System.out.println("3. Warn when a category crosses 80 percent of its budget? Currently "+ex.warn);
            System.out.println("4. Show a month summary: total spent per category against budget");
            System.out.println("5. List the n largest expenses of the month");
            System.out.println("6. Exit");
            switch (sc.nextInt())
            {
                case 1 -> {
                    System.out.print("\033[H\033[2J");
                    System.out.println("1. Today's Date");
                    System.out.println("2. Enter Custom Date");
                    if (sc.nextInt() != 2) {
                        System.out.print("\033[H\033[2J");
                        System.out.println("Current Categories: " + ex.categories());
                        System.out.print("Enter Expense: ");
                        ex.setExpense();
                    }
                }
                case 2 -> {
                    ex.setBudget();
                }
                case 3 -> {
                    ex.warn = !ex.warn;
                }
                case 4 -> {
                    ex.getSummary();
                }
                case 5 -> {
                    ex.getLargestExpenses(sc.nextInt());
                }
                case 6 -> {
                    return;
                }
            }
        }
    }
}