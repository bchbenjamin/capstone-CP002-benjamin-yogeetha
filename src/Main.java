import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void clear ()
    {
        System.out.print("\033[H\033[2J");
    }
    public static void main(String[] args) {

        while (true)
        {
            Scanner sc = new Scanner(System.in);
            Expenses ex = new Expenses();
            clear();
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
                    clear();
                    System.out.println("1. Today's Date");
                    System.out.println("2. Enter Custom Date");
                    if (sc.nextInt() == 2) {
                        clear();
                        System.out.println("Current Categories: " + ex.categories());
                        System.out.print("Enter Category: ");
                        String category = sc.next();
                        System.out.print("Enter Expense: ");
                        double expense = sc.nextDouble();
                        System.out.print("Enter short note (Press enter to skip): ");
                        String note = sc.nextLine();
                        System.out.print("Enter Year: ");
                        int year = sc.nextInt();
                        System.out.print("Enter Month: ");
                        int month = sc.nextInt();
                        System.out.print("Enter Date: ");
                        int date = sc.nextInt();
                        ex.setExpense(year, month, date, category, expense, note.trim());
                    }
                    else
                    {
                        clear();
                        System.out.println("Current Categories: " + ex.categories());
                        System.out.print("Enter Category: ");
                        String category = sc.next();
                        sc.nextLine(); // to get other words
                        System.out.print("Enter Expense: ");
                        double expense = sc.nextDouble();
                        sc.nextLine(); // to get the '\n'
                        System.out.print("Enter short note (Press enter to skip): ");
                        String note = sc.nextLine();
                        ex.setExpense(LocalDate.now(), category.toLowerCase(), expense, note.trim());
                    }
                }
                case 2 -> {
                    System.out.println("Current Categories: " + ex.categories());
                    System.out.print("Enter the category (Keep blank to set overall budget): ");
                    String category = sc.next();
                    System.out.print("Enter the budget to be set");
                    if (ex.setBudget(category.trim(), sc.nextInt()))
                        System.out.println("Successfully set budget!");
                    else
                        System.out.println("Budget is still "+ex.total+". The requested budget isn't feasible with the category-specific budgets!");
                }
                case 3 -> {
                    ex.warn = !ex.warn;
                    String output = ex.warn ? "Warnings enabled" : "Warnings disabled";
                    System.out.println(output);
                }
                case 4 -> {
                    ex.getSummary();
                }
                case 5 -> {
                    System.out.println(ex.getLargestExpenses(sc.nextInt()));
                }
                case 6 -> {
                    return;
                }
            }
        }
    }
}