package com.room.expenses.ExpensesManagement.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Expense  {
	@Id
	@GeneratedValue
	private int id;
	//@Transient
	private Date date;
	@NotNull
private String name;
	@NotNull
	 @Size(min=2, max=30)
private String item;
	@NotNull(message="Amount cant be empty")
private Double amount;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getItem() {
	return item;
}
public void setItem(String item) {
	this.item = item;
}
public Double getAmount() {
	return amount;
}
public void setAmount(Double amount) {
	this.amount = amount;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}

@PrePersist
protected void onUpdate() {
date = new Date();
}

}
