package com.alchemy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alchemy.dao.ExpenseDao;
import com.alchemy.exception.EntityException;
import com.alchemy.exception.ExpenseManipulationException;
import com.alchemy.model.Expense;

/**
 * @author Sunny_Ghosh
 *
 */

@Service
public class ExpenseServiceImp implements ExpenseService{

	@Autowired
	private ExpenseDao expenseDao;
	

	public ExpenseServiceImp() {
		super();
	}
	
	public ExpenseServiceImp(ExpenseDao expenseDao){
		this.expenseDao = expenseDao;
	}

	@Override
	public Expense addExpense(Expense expense) {
		try {
			return expenseDao.addExpense(expense);
		} catch (EntityException e) {
			throw new ExpenseManipulationException(e.getMessage());
		}
	}

	@Override
	public List<Expense> getExpenses() {
		try {
			return expenseDao.getExpenses();
		} catch (EntityException e) {
			throw new ExpenseManipulationException(e.getMessage());
		}
	}	
}
