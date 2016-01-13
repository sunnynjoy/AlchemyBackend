package com.alchemy.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.alchemy.dao.ExpenseDao;
import com.alchemy.exception.EntityException;
import com.alchemy.exception.ExpenseManipulationException;
import com.alchemy.model.Expense;

/**
 * @author Sunny_Ghosh
 */

public class ExpenseServiceImpTest {
	
	@InjectMocks
	private ExpenseService expenseService = new ExpenseServiceImp();

	@Mock
	private ExpenseDao expenseDao;
	
	@Spy
	Expense expense = getExpense();
	
	@Spy
	List<Expense> expenses = getExpenses();
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	/**
	 * ExpenseServiceImp() constructor test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testExpenseServiceImp1()
		throws Exception {
		ExpenseService result = new ExpenseServiceImp();
		assertNotNull(result);
	}

	/**
	 * ExpenseServiceImp(ExpenseDao) constructor test by injecting dao.
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testExpenseServiceImp2()
		throws Exception {
		ExpenseServiceImp result = new ExpenseServiceImp(expenseDao);
		assertNotNull(result);
	}

	/**
	 * Expense addExpense(Expense) test.
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testAddExpense1()
		throws Exception {
		when(expenseDao.addExpense(any())).thenReturn(expense);
		Expense result = expenseService.addExpense(expense);
		assertNotNull(result);
		Assert.assertEquals("test", result.getReason());
	}
	
	
	/**
	 * Expense addExpense(Expense) test. Exception check
	 *
	 * @throws Exception
	 *
	 */
	@Test(expected = ExpenseManipulationException.class)
	public void testAddExpense2()
		throws Exception {
		when(expenseService.addExpense(any())).thenThrow(new EntityException("add expense error"));
		Expense result = expenseService.addExpense(expense);
		assertNotNull(result);
	}

	/**
	 * Expense getExpenses test, getting all the expenses
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testGetExpense1()
		throws Exception {
		when(expenseDao.getExpenses()).thenReturn(expenses);
		List<Expense> result = expenseService.getExpenses();
		assertNotNull(result);
		Assert.assertEquals(BigDecimal.valueOf(20.0), result.get(0).getAmount());
	}

	
	/**
	 * Expense getExpenses test exception check
	 *
	 * @throws Exception
	 *
	 */
	@Test(expected = ExpenseManipulationException.class)
	public void testGetExpense2()
		throws Exception {
		when(expenseService.getExpenses()).thenThrow(new EntityException("get expense error"));
		List<Expense> result = expenseService.getExpenses();
		assertNotNull(result);
	}


	@After
	public void tearDown()
		throws Exception {
	}
	
	// setting the initial object parameters
		private Expense getExpense() {
			Expense expense = new Expense(1, new Date(), BigDecimal.valueOf(20.00), "test", BigDecimal.valueOf(4.00));
			return expense;
		}
		
		// setting the initial object parameters and returning a list
		private List<Expense> getExpenses() {
			List<Expense> expenses = new ArrayList<>();
			expenses.add(getExpense());
			return expenses;
		}

	/**
	 * Launch the test.
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(ExpenseServiceImpTest.class);
	}
}