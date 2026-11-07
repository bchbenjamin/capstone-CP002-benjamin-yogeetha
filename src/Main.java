import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        while (true)
        {
            Scanner sc = new Scanner(System.in);
            Expenses ex = new Expenses();
            System.out.print("\033[H\033[2J"); // TODO: This doesn't work and needs to be replaced. Best to use a method for this.
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
                    if (sc.nextInt() == 2) {
                        System.out.print("\033[H\033[2J");
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
                        System.out.print("\033[H\033[2J");
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