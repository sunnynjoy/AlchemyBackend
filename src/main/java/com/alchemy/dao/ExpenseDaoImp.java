package com.alchemy.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.alchemy.domain.ExpenseEntity;
import com.alchemy.exception.EntityException;
import com.alchemy.model.Expense;
import com.alchemy.utils.DomainModelUtil;

/**
 * @author Sunny_Ghosh
 *
 */

@Repository
@Transactional
@SuppressWarnings("unchecked")
public class ExpenseDaoImp implements ExpenseDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public ExpenseDaoImp(){
		super();
	}
	
	public ExpenseDaoImp(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	
	@Override
	public Expense addExpense(Expense expenseModel) throws EntityException {
		ExpenseEntity expenseEntity = DomainModelUtil.modelToDomainConverter(expenseModel);
		try {
			sessionFactory.getCurrentSession().persist(expenseEntity);
		} catch (Exception e) {
			new EntityException("Error while insert data in the database");
		}
		return DomainModelUtil.domainToModelConverter(expenseEntity);

	}

	@Override
	public List<Expense> getExpenses() throws EntityException {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ExpenseEntity.class);
		List<Expense> expenses = criteria.list();
		if(expenses == null){
			throw new EntityException("Error while fetching data from the database");
		}
		return expenses;
	}
}
