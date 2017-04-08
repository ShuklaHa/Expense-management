package com.room.expenses.ExpensesManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.room.expenses.ExpensesManagement.model.Expense;

public interface ExpenseDAO extends JpaRepository<Expense, Long>{

}
