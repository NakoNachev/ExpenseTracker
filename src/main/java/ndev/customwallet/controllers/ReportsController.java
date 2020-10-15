package ndev.customwallet.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import ndev.customwallet.model.Expense;
import ndev.customwallet.model.ExpenseType;
import ndev.customwallet.model.Report;
import ndev.customwallet.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.*;

/**
 * Controller responsible for pulling reports base on expense type/amount
 * for different months/years.
 */
@RestController
@RequestMapping("/api/report")
public class ReportsController {

    @Autowired
    private ExpenseService expenseService;

    private Report report;

    private Calendar calendar = Calendar.getInstance();


    @GetMapping("/{year}")
    public ObjectNode getReportForYear(@PathVariable("year") int year){

        //List<Expense> expenseList = this.expenseService.returnExpences();
        //Map<ExpenseType, Double> mapper = this.expenseService.getMapperExpenseTypeValue();
        List<Expense> expenseList = new ArrayList<Expense>();
        for(Expense expense: this.expenseService.returnExpences()){
            calendar.setTime(expense.getExpenseIssueDate());
            if(calendar.get(Calendar.YEAR) == year){
                expenseList.add(expense);
            }
        }
        Map<ExpenseType, Double> mapper = this.expenseService.getMapperExpenseTypeValuePeriod(expenseList);

        this.report = Report.builder()
                        .expenseList(expenseList)
                        .expensetypeValueMapper(mapper)
                        .build();

        return this.report.generate(this.expenseService.getMapperSum(mapper));

    }

    @GetMapping("/{year}/{month}")
    public ObjectNode getReportForYearMonth(@PathVariable("year") int year,
                                        @PathVariable("month") int month){

        List<Expense> expenseList = new ArrayList<Expense>();
        for(Expense expense: this.expenseService.returnExpences()){
            calendar.setTime(expense.getExpenseIssueDate());
            if(calendar.get(Calendar.YEAR) == year && calendar.get(Calendar.MONTH)+1 == month){
                expenseList.add(expense);
            }
        }

        Map<ExpenseType, Double> mapper = this.expenseService.getMapperExpenseTypeValuePeriod(expenseList);

        this.report = Report.builder()
                .expenseList(expenseList)
                .expensetypeValueMapper(mapper)
                .build();

        return this.report.generate(this.expenseService.getMapperSum(mapper));

    }




}
