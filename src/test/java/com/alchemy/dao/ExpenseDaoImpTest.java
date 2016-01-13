package com.alchemy.dao;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Spy;

import com.alchemy.domain.ExpenseEntity;
import com.alchemy.model.Expense;

/**
 * @author Sunny_Ghosh
 */

public class ExpenseDaoImpTest {
	
	@InjectMocks
	private ExpenseDao expenseDao = new ExpenseDaoImp();
	
	private SessionFactory sessionFactory;
	
	@Spy
	Expense expense = getExpense();
	
	@Spy
	List<Expense> expenses = getExpenses();
	
	Session session;
	
	Criteria criteria;
	
	@Before
	public void setUp()
		throws Exception {
		sessionFactory = mock(SessionFactory.class); 
		session = mock(Session.class); 
		criteria = mock(Criteria.class);
	}
	
	/**
	 * ExpenseDaoImp() constructor test.
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testExpenseDaoImp1()
		throws Exception {
		ExpenseDao expense = new ExpenseDaoImp();
		assertNotNull(expense);
	}

	/**
	 * ExpenseDaoImp(SessionFactory) constructor test.
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testExpenseDaoImp2()
		throws Exception {
		ExpenseDao expense = new ExpenseDaoImp(sessionFactory);
		assertNotNull(expense);
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
		ExpenseDao expenseDao = new ExpenseDaoImp(sessionFactory);
		when(sessionFactory.getCurrentSession()).thenReturn(session);
		Expense expenseRes = expenseDao.addExpense(expense);
		assertNotNull(expenseRes);
		Assert.assertEquals(1, expenseRes.getExpenseId());
	}
	
	
	/**
	 * Expense addExpense(Expense) test.  exception test
	 *
	 * @throws Exception
	 *
	 */
	@Test(expected = Exception.class)
	public void testAddExpense2()
		throws Exception {
		ExpenseDao expenseDao = new ExpenseDaoImp(sessionFactory);
		when(sessionFactory.getCurrentSession()).thenReturn(session);
		when(expenseDao.addExpense(expense)).thenThrow(new Exception("entity error"));
		Expense expenseRes = expenseDao.addExpense(expense);
		assertNotNull(expenseRes);
	}

	/**
	 * List<Expense> getExpenses() test. get all the expenses
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testGetExpenses1()
		throws Exception {
		ExpenseDao expenseDao = new ExpenseDaoImp(sessionFactory);
		when(sessionFactory.getCurrentSession()).thenReturn(session);
		when(session.createCriteria(ExpenseEntity.class)).thenReturn(criteria);
		when(criteria.list()).thenReturn(expenses);
		List<Expense> expenseList = expenseDao.getExpenses();
		assertNotNull(expenseList);
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
		new org.junit.runner.JUnitCore().run(ExpenseDaoImpTest.class);
	}
}