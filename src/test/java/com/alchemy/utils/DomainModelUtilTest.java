package com.alchemy.utils;

import java.math.BigDecimal;
import java.util.Date;
import org.junit.*;
import static org.junit.Assert.*;
import com.alchemy.domain.ExpenseEntity;
import com.alchemy.model.Expense;

/**
 * @author Sunny_Ghosh
 */

public class DomainModelUtilTest {
	
	@Before
	public void setUp()
		throws Exception {
	}
	
	/**
	 * domainToModelConverter(ExpenseEntity) test.
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testDomainToModelConverter1()
		throws Exception {
		ExpenseEntity expenseDomain = new ExpenseEntity();
		expenseDomain.setReason("");
		expenseDomain.setAmount(new BigDecimal(1.0));
		expenseDomain.setDate(new Date());
		expenseDomain.setExpenseId(1);
		Expense result = DomainModelUtil.domainToModelConverter(expenseDomain);
		assertNotNull(result);
		assertEquals("", result.getReason());
		assertEquals(1, result.getExpenseId());
	}

	/**
	 * domainToModelConverter(ExpenseEntity) test.
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testDomainToModelConverter2()
		throws Exception {
		ExpenseEntity expenseDomain = null;
		Expense result = DomainModelUtil.domainToModelConverter(expenseDomain);
		assertEquals(null, result);
	}

	/**
	 * ExpenseEntity modelToDomainConverter(Expense) test.
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testModelToDomainConverter1()
		throws Exception {
		Expense expenseModel = new Expense(1, new Date(), new BigDecimal(1.0), "", new BigDecimal(1.0));
		ExpenseEntity result = DomainModelUtil.modelToDomainConverter(expenseModel);
		assertNotNull(result);
		assertEquals("", result.getReason());
		assertEquals(1, result.getExpenseId());
	}

	/**
	 * Run the ExpenseEntity modelToDomainConverter(Expense)  test null check
	 *
	 * @throws Exception
	 */
	@Test
	public void testModelToDomainConverter2()
		throws Exception {
		Expense expenseModel = null;
		ExpenseEntity result = DomainModelUtil.modelToDomainConverter(expenseModel);
		assertNotNull(result);
		assertEquals(null, result.getDate());
		assertEquals(null, result.getVatAmount());
		assertEquals(0, result.getExpenseId());
	}

	@After
	public void tearDown()
		throws Exception {
	}

	/**
	 * Test the full class
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(DomainModelUtilTest.class);
	}
}