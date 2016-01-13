package com.alchemy.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.ModelAndViewAssert;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import com.alchemy.model.Expense;
import com.alchemy.service.ExpenseService;

/**
 * @author Sunny_Ghosh
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebMvcTestConfig.class})
@WebAppConfiguration
public class ExpenseControllerTest {

	@Mock
	ExpenseService expenseService;

	@InjectMocks
	private ExpenseController controller = new ExpenseController();
	
	@Autowired
    private WebApplicationContext webApplicationContext;

	@Mock
	HttpServletRequest request;

	@Spy
	Expense expense = getExpense();
	
	@Spy
	List<Expense> expenses = getExpenses();
	
	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		 mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	/**
	 * Run the ModelAndView defaultPage() test
	 * 
	 * @throws Exception
	 */
	
	@Test
	public void testDefaultPage() throws Exception{
		ModelAndView modelAndView = controller.defaultPage();
		ModelAndViewAssert.assertViewName(modelAndView, "default");
		ModelAndViewAssert.assertAndReturnModelAttributeOfType(modelAndView, "user", Expense.class);
	}
	
	
	/**
	 * ModelAndView defaultPage() test , testing the request mapping
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDefaultPage1() throws Exception {
		mockMvc.perform(get("/expenses")).andExpect(status().isOk()).andExpect(view().name("default"))
				.andExpect(forwardedUrl("/WEB-INF/views/default.jsp"));
	}
	

	/**
	 * ResponseEntity<Void> addExpense(Expense,HttpServletRequest)
	 *  test
	 * 
	 * @throws Exception
	 */
	@Test
	public void testAddExpense() throws Exception {
		when(expenseService.addExpense(any())).thenReturn(expense);
		ResponseEntity<Void> result = controller.addExpense(expense, request);
		assertNotNull(result);
		Assert.assertEquals(HttpStatus.CREATED, result.getStatusCode());
	}
	
	
	/**
	 * ResponseEntity<Void> addExpense(Expense,HttpServletRequest)
	 * test, testing the request mapping /expense for Unsuppported media type 
	 * 
	 * @throws Exception
	 */
	@Test
	public void testAddExpense1() throws Exception {
		mockMvc.perform(post("/expense")
		.contentType(MediaType.APPLICATION_XML)
		.content(expense.toString().getBytes("UTF-8")))
		.andExpect(status().is4xxClientError());
	}

	/**
	 * ResponseEntity<List<Expense>> allExpenses(HttpServletRequest)
	 *  test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testAllExpenses() throws Exception {
		when(expenseService.getExpenses()).thenReturn(expenses);
		ResponseEntity<List<Expense>> result = controller.allExpenses(request);
		assertNotNull(result);
		Assert.assertEquals(HttpStatus.OK, result.getStatusCode());
	}

	/**
	 * ResponseEntity<List<Expense>> allExpenses(HttpServletRequest)
	 * test. 
	 * 
	 * Null check
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testAllExpenses1() throws Exception {
		when(expenseService.getExpenses()).thenReturn(null);
		ResponseEntity<List<Expense>> result = controller.allExpenses(request);
		Assert.assertEquals(HttpStatus.EXPECTATION_FAILED, result.getStatusCode());
	}

	
	@After
	public void tearDown() throws Exception {
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
	 * run the whole test
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(ExpenseControllerTest.class);
	}
}