package com.alchemy.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

/**
 * @author Sunny_Ghosh
 */

public class ExpenseTest {
	
	@Spy
	Expense expense = getExpense();
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	/**
	 * Expense() constructor test.
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testExpense1()
		throws Exception {
		Expense result = new Expense();
		assertNotNull(result);
		assertEquals(null, result.getDate());
		assertEquals(null, result.getReason());
		assertEquals(null, result.getVatAmount());
		assertEquals(null, result.getAmount());
		assertEquals(0, result.getExpenseId());
	}

	/**
	 * Expense(int,Date,BigDecimal,String,BigDecimal) constructor test.
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testExpense2()
		throws Exception {
		Expense result = new Expense(expense.getExpenseId(), 
				expense.getDate(), expense.getAmount(), expense.getReason(),
				expense.getVatAmount());
		assertNotNull(result);
		assertEquals("test", result.getReason());
		assertEquals(1, result.getExpenseId());
		assertEquals(BigDecimal.valueOf(20.00), result.getAmount());
	}

	/**
	 * equals(Object) test.
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testEquals1()
		throws Exception {
		Expense expense1 = new Expense(1, new Date(), new BigDecimal(1.0), "", new BigDecimal(1.0));
		Object expense2 = new Expense(1, new Date(), new BigDecimal(1.0), "", new BigDecimal(1.0));
		boolean result = expense1.equals(expense2);
		assertEquals(true, result);
	}

	/**
	 * equals(Object) test by checking with a null object.
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testEquals2()
		throws Exception {
		Expense expense1 = getExpense();
		Object expense2 = null;
		boolean result = expense1.equals(expense2);
		assertEquals(false, result);
	}


	/**
	 * getAmount() test.
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testGetAmount()
		throws Exception {
		Expense expense = getExpense();
		assertNotNull(expense.getAmount());
		assertEquals("20.0", expense.getAmount().toString());
		assertEquals(20, expense.getAmount().intValue());
		assertEquals(20L, expense.getAmount().longValue());
		assertEquals(20.0f, expense.getAmount().floatValue(), 20.0f);
		assertEquals(20.0, expense.getAmount().doubleValue(), 20.0);
	}


	/**
	 * getExpenseId() test.
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testGetExpenseId()
		throws Exception {
		Expense expense = getExpense();
		assertEquals(1, expense.getExpenseId());
	}

	/**
	 * getReason() method test.
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testGetReason()
		throws Exception {
		Expense expense = getExpense();
		assertEquals("test", expense.getReason());
	}

	/**
	 * getVatAmount() test.
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testGetVatAmount()
		throws Exception {
		Expense expense = getExpense();
		assertNotNull(expense.getVatAmount());
		assertEquals("4.0", expense.getVatAmount().toString());
		assertEquals(4, expense.getVatAmount().intValue());
		assertEquals(4L, expense.getVatAmount().longValue());
		assertEquals(4.0f, expense.getVatAmount().floatValue(), 4.0f);
		assertEquals(4.0, expense.getVatAmount().doubleValue(), 4.0);
	}

	/**
	 * hashCode() test.
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testHashCode1()
		throws Exception {
		Expense expense = getExpense();
		int result = expense.hashCode();
		assertNotNull(result);
	}


	/**
	 * setAmount(BigDecimal) test.
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testSetAmount()
		throws Exception {
		Expense expense = getExpense();
		BigDecimal amount = new BigDecimal(5.0);
		expense.setAmount(amount);
		assertEquals(BigDecimal.valueOf(5), expense.getAmount());
	}

	/**
	 * setDate(Date) test.
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testSetDate()
		throws Exception {
		Expense expense = getExpense();
		Date date = new Date();
		expense.setDate(date);
		assertEquals(new Date(), expense.getDate());
	}

	/**
	 * setExpenseId(int) test.
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testSetExpenseId()
		throws Exception {
		Expense expense = getExpense();
		expense.setExpenseId(2);
		assertEquals(2, expense.getExpenseId());
	}

	/**
	 * setReason(String) test.
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testSetReason()
		throws Exception {
		Expense expense = getExpense();
		expense.setReason("second");
		assertEquals("second", expense.getReason());
	}

	/**
	 * setVatAmount(BigDecimal) test.
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testSetVatAmount()
		throws Exception {
		Expense expense = getExpense();
		BigDecimal vatAmount = new BigDecimal(2.0);
		expense.setVatAmount(vatAmount);
		assertEquals(BigDecimal.valueOf(2), expense.getVatAmount());
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

	/**
	 * Launch the test.
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(ExpenseTest.class);
	}
}