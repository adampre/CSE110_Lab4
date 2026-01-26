package edu.ucsd.spendingtracker.datasource;

import java.util.List;
import java.util.ArrayList;
import edu.ucsd.spendingtracker.model.Expense;

public class InMemoryDataSource implements IDataSource{
    private List<Expense> expenses = new ArrayList<>();

    @Override
    public List<Expense> getExpenses() {
        return List.copyOf(expenses);
    }

    @Override
    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    @Override
    public void deleteExpense(int id) {
        expenses.removeIf(expense -> expense.getID() == id);
    }
}

