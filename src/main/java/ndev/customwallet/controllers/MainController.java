package ndev.customwallet.controllers;



import ndev.customwallet.model.Expense;
import ndev.customwallet.model.ExpenseType;
import ndev.customwallet.services.ExpenseService;
import ndev.customwallet.services.ExpenseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private ExpenseService expenseService;
    @Autowired
    private ExpenseTypeService expenseTypeService;

    private final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    private final Calendar calendar = Calendar.getInstance();

    @GetMapping("/expenses")
    public List<Expense> returnExpenses() {

       return expenseService.returnExpences();

    }

    @GetMapping("/expenseTypes")
    public List<ExpenseType> returnExpenseTypes() {

        return this.expenseTypeService.getAll();
    }

    @GetMapping("/expense")
    public String returnJson() {

        return expenseService.returnJson();
    }

    /**
     * Get expense by its id
     * @param id
     * @return
     */
    @GetMapping("/expense/{id}")
    public Expense returnExpenseById(@PathVariable("id") int id){
        return expenseService.returnById(id);
    }


    @GetMapping("/expenses/{year}")
    public List<Expense> returnExpensesYear(@PathVariable("year") int year) {
        List<Expense> output = new ArrayList<Expense>();
        for(Expense expense: this.expenseService.returnExpences()){
            calendar.setTime(expense.getExpenseIssueDate());
            if(calendar.get(Calendar.YEAR) == year){
                output.add(expense);
            }
        }
        return output;
        }

    @GetMapping("/expenses/{year}/{month}")
    public List<Expense> returnExpensesYearMonth(@PathVariable("year") int year, @PathVariable("month")
                                                 int month) {
        List<Expense> output = new ArrayList<Expense>();
        for (Expense expense: this.returnExpensesYear(year)){

            calendar.setTime(expense.getExpenseIssueDate());
            System.out.println(calendar.get(Calendar.MONTH));
            if(calendar.get(Calendar.MONTH)+1 == month){    // needs +1 because it is 1 behind
                output.add(expense);
            }

        }
        return output;
    }
    @GetMapping("/expenses/{year}/{month}/{day}")
    public List<Expense> returnExpensesYearMonthDay(@PathVariable("year") int year, @PathVariable("month")
            int month, @PathVariable("day") int day) {

        List<Expense> output = new ArrayList<Expense>();
        for (Expense expense: this.returnExpensesYearMonth(year,month)){
            calendar.setTime(expense.getExpenseIssueDate());
            System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
            if(calendar.get(Calendar.DAY_OF_MONTH) == day){
                output.add(expense);
            }

        }
        return output;

    }

    @PostMapping("/expenses/{year}/{month}/{day}/{amount}/{expenseTypeName}/{expenseDescription}")
    public void addNewExpense(@PathVariable("year") int year, @PathVariable("month") int month, @PathVariable("day")
            int day, @PathVariable("amount")BigDecimal amount, @PathVariable("expenseTypeName") String expenseTypeName,
                @PathVariable("expenseDescription") String expenseDescription) {

        int expenseTypeId = 0;

        ExpenseType targetExpenseType = this.expenseTypeService.findByExpenseTypeName(expenseTypeName);
        Expense targetExpense = Expense.builder()
                .expenseId(this.expenseService.returnExpences().size()-1)
                .expenseAmount(amount)
                .expenseType(targetExpenseType)
                .expenseDescription(expenseDescription)
                .build();

        this.expenseService.saveExpense(targetExpense);
        //TODO: fix how it is displayed on the .json file
    }
}
