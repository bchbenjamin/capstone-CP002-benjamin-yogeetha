import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Loaded value must be written here
        Expenses ex = new Expenses();
        while (true)
        {
            Scanner sc = new Scanner(System.in);
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
                    System.out.println("1. Today's Date");
                    System.out.println("2. Enter Custom Date");
                    if (sc.nextInt() == 2) {
                        System.out.println("Current Categories: " + ex.categories());
                        System.out.print("Enter Category: ");
                        String category = sc.next();
                        System.out.print("Enter Expense: ");
                        double expense = sc.nextDouble();
                        System.out.print("Enter short note (Press enter to skip): ");
                        sc.nextLine();
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
                        System.out.println("Current Categories: " + ex.categories());
                        System.out.print("Enter Category: ");
                        String category = sc.next();
                        sc.nextLine();
                        System.out.print("Enter Expense: ");
                        double expense = sc.nextDouble();
                        sc.nextLine();
                        System.out.print("Enter short note (Press enter to skip): ");
                        String note = sc.nextLine();
                        ex.setExpense(LocalDate.now(), category.toLowerCase(), expense, note.trim());
                    }
                }
                case 2 -> {
                    String category;
                    do
                    {
                        System.out.println("Current Categories: " + ex.categories());
                        System.out.print("Enter the category: ");
                        category = sc.next().trim();
                        if (!Expenses.isValidCategory(category))
                        {
                            System.out.println("Invalid Category!");
                        }
                        else break;
                    }
                    while (true);
                    System.out.print("Enter the budget to be set");
                    switch (ex.setBudget(category, sc.nextInt()))
                    {
                        case 1 -> {
                            System.out.println("Budget set successfully!");
                        }
                        case 0 -> {
                            System.out.println("Budget set successfully! You've already spent more than 80% of your monthly budget");
                        }
                        case -1 -> {
                            System.out.println("You've already spent more than budget. Budget NOT set!");
                        }
                    }
                }
                case 3 -> {
                    ex.warn = !ex.warn;
                    String output = ex.warn ? "Warnings enabled" : "Warnings disabled";
                    System.out.println(output);
                }
                case 4 -> {
                    System.out.println(ex.getThisMonthExpenses());
                }
                case 5 -> {
                    System.out.print("Enter the number of top expenses to be logged: ");
                    System.out.println(ex.getLargestExpenses(sc.nextInt()));
                }
                case 6 -> {
                    // Write to CSV and exit
                    // If this is implemented then at the start, you must load from CSV
                    return;
                }
            }
            System.out.println("----Press any key to go next----");
            sc.nextLine();
        }
    }
}