package com.alchemy.testAll;

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.alchemy.controller.ExpenseControllerTest;
import com.alchemy.dao.ExpenseDaoImpTest;
import com.alchemy.model.ExpenseTest;
import com.alchemy.service.ExpenseServiceImpTest;
import com.alchemy.utils.DomainModelUtilTest;

/**
 * TestAll runs all the tests within its package and sub packages.
 *
 * @author Sunny_Ghosh
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	ExpenseServiceImpTest.class,
	ExpenseTest.class,
	DomainModelUtilTest.class,
	ExpenseDaoImpTest.class,
	ExpenseControllerTest.class
})
public class TestAll {

	/**
	 * Launch the test.
	 */
	public static void main(String[] args) {
		JUnitCore.runClasses(new Class[] { TestAll.class });
	}
}
