package ndev.customwallet.controllers;


import ndev.customwallet.model.Expense;
import ndev.customwallet.model.ExpenseType;
import ndev.customwallet.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private ExpenseService expenseService;


    @GetMapping("/expenses")
    public List<Expense> returnExpenses() {

       return expenseService.returnExpences();

    }

    @GetMapping("/expense")
    public String returnJson() {

        return expenseService.returnJson();
    }

    @GetMapping("/expense/{id}")
    public Expense returnExpenseById(@PathVariable("id") int id){
        return expenseService.returnById(id);
    }

    @GetMapping("/expenses/{year}")
    public List<Expense> returnExpensesYear(@PathVariable("year") String year) {

        return null;
    }

    @GetMapping("/expenses/{year}/{month}")
    public List<Expense> returnExpensesYearMonth(@PathVariable("year") String year, @PathVariable("month")
                                                 String month) {

        return null;
    }
    @GetMapping("/expenses/{year}/{month}/{day}")
    public List<Expense> returnExpensesYearMonthDay(@PathVariable("year") String year, @PathVariable("month")
            String month, @PathVariable("day") String day) {

        return null;
    }
    @PostMapping("/expenses/{year}/{month}/{day}/{amount}/{expenseType}/{expenseDescription}")
    public void addNewExpense(@PathVariable("year") int year, @PathVariable("month") int month, @PathVariable("day")
            int day, @PathVariable("amount")BigDecimal amount, @PathVariable("expenseType")ExpenseType expenseType,
                @PathVariable("expenseDescription") String expenseDescription) {


    }
}
