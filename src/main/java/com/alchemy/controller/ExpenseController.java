package com.alchemy.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alchemy.model.Expense;
import com.alchemy.service.ExpenseService;

/**
 * @author Sunny_Ghosh
 *
 */

@RestController
class ExpenseController {

	@Autowired
	private ExpenseService expenseService;

	@RequestMapping(value = { "/", "/expenses" }, method = RequestMethod.GET)
	public ModelAndView defaultPage() {
		Expense expense = new Expense();
		return new ModelAndView("default", "user", expense);
	}

	@RequestMapping(value = "/expense", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Void> addExpense(@RequestBody Expense expense, HttpServletRequest request) {
		expenseService.addExpense(expense);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/allExpenses", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Expense>> allExpenses(HttpServletRequest request) {
		List<Expense> newExpense = expenseService.getExpenses();
		if (newExpense == null || newExpense.isEmpty()) {
			return new ResponseEntity<List<Expense>>(HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<List<Expense>>(newExpense, HttpStatus.OK);
	}
}
