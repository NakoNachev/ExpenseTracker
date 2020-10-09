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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/report")
public class ReportsController {

    @Autowired
    private ExpenseService expenseService;

    private Report report;


    @GetMapping("/{year}")
    public ObjectNode getReportForYear(@PathVariable("year") int year){

        List<Expense> expenseList = this.expenseService.returnExpences();
        Map<ExpenseType, Double> mapper = this.expenseService.getMapperExpenseTypeValue();

        this.report = Report.builder()
                        .expenseList(expenseList)
                        .expensetypeValueMapper(mapper)
                        .build();

        return this.report.generate(this.expenseService.getMapperSum(mapper));

    }

    @GetMapping("/{year}/{month}")
    public String getReportForYearMonth(@PathVariable("year") int year,
                                        @PathVariable("month") int month){

        return null;
    }




}
