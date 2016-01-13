package com.alchemy.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Sunny_Ghosh
 *
 */

@Entity
@Table(name = "expense")
public class ExpenseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6163860650561035513L;
	
	private int expenseId;
	private Date date;
	private BigDecimal amount;
	private String reason;
	private BigDecimal vatAmount;

	public ExpenseEntity(){
		super();
	};
	
	@Id
	@Column(name = "expenseId", unique = true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getExpenseId() {
	    return this.expenseId;
	}
	
	public void setExpenseId(int expenseId) {
	    this.expenseId = expenseId;
	}
	
	
	@Column(name = "date",nullable = false)
	public Date getDate() {
	    return this.date;
	}
	
	public void setDate(Date date) {
	    this.date = date;
	}

	@Column(name = "amount",nullable = false)
	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Column(name = "reason",nullable = false)
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	@Column(name = "vatAmount",nullable = false)
	public BigDecimal getVatAmount() {
		return vatAmount;
	}

	public void setVatAmount(BigDecimal vatAmount) {
		this.vatAmount = vatAmount;
	}
}
