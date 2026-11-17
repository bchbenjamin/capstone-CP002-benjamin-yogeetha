# Expense Tracker

A simple console-based Expense Tracker developed using Java. The application allows users to record daily expenses, manage category-wise monthly budgets, monitor spending through budget alerts, and view monthly expense summaries.

## Features

### 1. Expense Management
- Add expenses using the current date or a custom date.
- Record the expense category, amount, and an optional note.
- Validate expense details before adding them.
- Reject negative expense amounts.

### 2. Category Management
- Organise expenses by category.
- Maintain separate spending records for different categories.
- Validate category names and reject empty categories.

### 3. Monthly Budget Management
- Set monthly budgets for individual categories.
- Prevent setting a budget below the amount already spent.
- Maintain independent budgets for different categories.

### 4. Budget Alerts
- Enable or disable budget warnings.
- Display a warning when category spending crosses 80% of its budget.
- Display a separate warning when spending reaches or exceeds 100% of the budget.

### 5. Monthly Expense Summary
- View expenses recorded during the current month.
- Calculate total spending for each category.
- Compare category-wise spending against the assigned budget.
- View the remaining budget.

### 6. Largest Expenses
- Display the largest expenses recorded during the current month.
- Sort expenses in descending order based on their amounts.

### 7. Input Validation
- Handle invalid menu selections and numeric inputs.
- Validate expense amounts, categories, and budget values.
- Handle invalid custom-date entries.

## Technologies Used

- **Programming Language:** Java
- **Java Version:** Java 17
- **Data Structures:** ArrayList, HashMap
- **Date Handling:** Java Time API (`LocalDate`)
- **Development Environment:** IntelliJ IDEA / VS Code / Terminal

## Project Structure

```text
capstone-CP002-benjamin-yogeetha/
│
├── src/
│   ├── Main.java
│   ├── Expense.java
│   └── Expenses.java
│
└── README.md
```

### Class Description

| Class | Responsibility |
|---|---|
| `Main.java` | Handles user interaction, menu options, and input |
| `Expense.java` | Represents an individual expense and its details |
| `Expenses.java` | Manages expense records, categories, budgets, summaries, and calculations |

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 17 or later
- Git

Verify your Java installation:

```bash
java -version
javac -version
```

### Clone the Repository

```bash
git clone https://github.com/c-yogeetha/capstone-CP002-benjamin-yogeetha.git
```

Navigate into the project directory:

```bash
cd capstone-CP002-benjamin-yogeetha
```

### Compile the Project

```bash
javac src/*.java
```

### Run the Application

```bash
java -cp src Main
```

## Application Menu

The application provides the following options:

| Option | Description |
|---|---|
| 1 | Add an expense with a current or custom date |
| 2 | Set a monthly budget for a category |
| 3 | Enable or disable budget warnings |
| 4 | View the monthly expense summary |
| 5 | List the largest expenses of the month |
| 6 | Exit the application |

## Example Budget Scenario

Consider a category with a monthly budget of ₹1,000.

| Total Spending | Expected Behaviour |
|---:|---|
| ₹500 | No warning |
| ₹800 | No warning at exactly 80% |
| ₹850 | 80% threshold warning |
| ₹1,000 | 100% budget warning |

## Development and Testing

The application was tested for:

- Adding expenses with current and custom dates.
- Rejecting negative expense amounts.
- Handling invalid category and numeric inputs.
- Setting and validating monthly budgets.
- Triggering budget threshold warnings.
- Calculating category-wise monthly spending.
- Filtering expenses by month.
- Sorting expenses by amount.

## Future Improvements

- Persistent storage using CSV or a database.
- Graphical user interface.
- Expense visualisation using charts.
- Exporting monthly reports.
- Support for recurring expenses.

## Contributors

Developed as part of the Capstone Project.

