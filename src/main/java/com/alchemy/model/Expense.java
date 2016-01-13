package com.alchemy.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * @author Sunny_Ghosh
 *
 */
@JsonRootName("expense")
@JsonPropertyOrder({ "expenseId", "date", "amount", "reason" })
public class Expense implements Serializable{

	/**
	 * added a default serialVersionUID
	 */
	private static final long serialVersionUID = -6975597405849603379L;
	
	private int expenseId;
	private Date date;
	private BigDecimal amount;
	private String reason;
	private BigDecimal vatAmount;
	
	public Expense() {
		System.out.println("**** Default cons Expense ****");
	}

	public Expense(int expenseId, Date date, BigDecimal amount, String reason, BigDecimal vatAmount) {
		super();
		this.expenseId = expenseId;
		this.date = date;
		this.amount = amount;
		this.reason = reason;
		this.vatAmount = vatAmount;
	}

	public int getExpenseId() {
	    return this.expenseId;
	}
	
	public void setExpenseId(int expenseId) {
		this.expenseId = expenseId;
	}
	
	public Date getDate() {
	    return this.date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}
	
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public BigDecimal getVatAmount() {
		return vatAmount;
	}

	public void setVatAmount(BigDecimal vatAmount) {
		this.vatAmount = vatAmount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + expenseId;
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
		result = prime * result + ((vatAmount == null) ? 0 : vatAmount.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Expense other = (Expense) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (expenseId != other.expenseId)
			return false;
		if (reason == null) {
			if (other.reason != null)
				return false;
		} else if (!reason.equals(other.reason))
			return false;
		if (vatAmount == null) {
			if (other.vatAmount != null)
				return false;
		} else if (!vatAmount.equals(other.vatAmount))
			return false;
		return true;
	}
}
