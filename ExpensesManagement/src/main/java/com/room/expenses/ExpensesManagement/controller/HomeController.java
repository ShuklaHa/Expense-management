package com.room.expenses.ExpensesManagement.controller;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.room.expenses.ExpensesManagement.model.Expense;
import com.room.expenses.ExpensesManagement.repository.ExpenseDAO;

@Controller
public class HomeController {

	@Autowired
	private ExpenseDAO expenseDao;

	@RequestMapping("/expenseHome")
	public String home(@ModelAttribute("Expense") Expense expense) {
		System.out.println("Inside home");
		return "homeForm";
	}

	@RequestMapping(value = "/takeAction", method = RequestMethod.GET)
	public String takeAction(@RequestParam(required = false, name = "action") String action,
			@ModelAttribute("Expense") Expense expense, Model model) {
		switch (action) {
		case "Submit":
			return "expenseForm";
		// break;
		case "Get Expenses":
			return getExpenses(model);

		default:
			break;
		}
		return "expenseForm";
	}

	private String getExpenses(Model model) {
		double amountTobeReceived = 0.0;
		String finalMessage;
		List<Expense> allExpenses = expenseDao.findAll();
		List<Expense> listOfExpenseForGivenMonth = allExpenses.stream().filter(e -> e.getDate() != null)
				.filter(e -> e.getDate().getMonth() == Calendar.getInstance().get(Calendar.MONTH))
				.collect(Collectors.toList());
		double harshitSum = listOfExpenseForGivenMonth.stream().filter(e -> e.getName() != null)
				.filter(e -> e.getName().equalsIgnoreCase("Harshit")).mapToDouble(e -> e.getAmount()).sum();
		double mritunjaySum = listOfExpenseForGivenMonth.stream().filter(e -> e.getName() != null)
				.filter(e -> e.getName().equalsIgnoreCase("Mritunjay")).mapToDouble(e -> e.getAmount()).sum();

		double total = harshitSum + mritunjaySum;
		double perHeadAmt = total / 2;
		if (mritunjaySum > harshitSum) {
			amountTobeReceived = mritunjaySum - perHeadAmt;
			finalMessage = "Mritunjay will receive";
		} else {
			amountTobeReceived = harshitSum - perHeadAmt;
			finalMessage = "Harshit will receive";
		}
		System.out.println(harshitSum + "--" + mritunjaySum + "--" + total);
		model.addAttribute("harshitsum", harshitSum);
		model.addAttribute("mritunjaySum", mritunjaySum);
		model.addAttribute("total", total);
		model.addAttribute("perHeadAmt", perHeadAmt);
		model.addAttribute("amountTobeReceived", amountTobeReceived);
		model.addAttribute("finalMessage", finalMessage);
		return "expenseResultView";
	}

	@RequestMapping("/greeting")
	public String greeting(@ModelAttribute("Expense") Expense expense, Model model) {
		model.addAttribute("expense", new Expense());
		return "expenseForm";
	}

	@RequestMapping(value = "/PutExpense", method = RequestMethod.POST)
	public String putExpense( @Valid @ModelAttribute("Expense") Expense expense,
			BindingResult bindingresult, Model model) {
		String message="";
		if (bindingresult.hasErrors()) {
			return "expenseForm";
		}
		try
		{
		expenseDao.saveAndFlush(expense);
		message = "Saved sucessfully";
		
		}catch (Exception e) {
			message="Problem occured";
		}
		model.addAttribute("successMesasge", message);
		model.addAttribute("Expense", new Expense());
		return "expenseForm";
	}
}
