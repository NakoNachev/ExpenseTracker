package ndev.customwallet.controllers;


import ndev.customwallet.model.Expense;
import ndev.customwallet.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private ExpenseService expenseService;


    @GetMapping("/expenses")
    public String returnExpenses() {

        return "test";
    }
}
