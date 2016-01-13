package com.alchemy.service;

import java.util.List;

import com.alchemy.model.Expense;

/**
 * @author Sunny_Ghosh
 *
 */

public interface ExpenseService {
	public Expense addExpense(Expense expense);
	public List<Expense> getExpenses();
	
}
