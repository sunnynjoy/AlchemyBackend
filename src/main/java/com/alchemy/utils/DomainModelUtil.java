package com.alchemy.utils;

import com.alchemy.domain.ExpenseEntity;
import com.alchemy.model.Expense;

/**
 * @author Sunny_Ghosh
 *
 */

public class DomainModelUtil {

	public static com.alchemy.domain.ExpenseEntity modelToDomainConverter(Expense expenseModel) {
		ExpenseEntity expenseDomain = new ExpenseEntity();
		if (expenseModel != null) {
			expenseDomain.setExpenseId(expenseModel.getExpenseId());
			expenseDomain.setDate(expenseModel.getDate());
			expenseDomain.setAmount(expenseModel.getAmount());
			expenseDomain.setReason(expenseModel.getReason());
			expenseDomain.setVatAmount(expenseModel.getVatAmount());
		}
		return expenseDomain;
	}

	public static com.alchemy.model.Expense domainToModelConverter(ExpenseEntity expenseDomain) {
		Expense expenseModel = null;
		if (expenseDomain != null) {
			expenseModel = new Expense(expenseDomain.getExpenseId(), expenseDomain.getDate(), expenseDomain.getAmount(),
					expenseDomain.getReason(),expenseDomain.getVatAmount());
		}
		return expenseModel;
	}
}
