package com.alchemy.dao;

import java.util.List;

import com.alchemy.exception.EntityException;
import com.alchemy.model.Expense;

/**
 * @author Sunny_Ghosh
 *
 */

public interface ExpenseDao {
	public Expense addExpense(Expense expense) throws EntityException;
	public List<Expense> getExpenses() throws EntityException;
	
}
