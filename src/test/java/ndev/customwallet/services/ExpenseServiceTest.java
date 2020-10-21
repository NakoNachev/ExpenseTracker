package ndev.customwallet.services;

import ndev.customwallet.controllers.MainController;
import ndev.customwallet.model.Expense;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ExpenseServiceTest {

    @Autowired
    MainController mainController;
    @Autowired
    ExpenseService expenseService;

    @Test
    public void checkExpenseList(){

        //assertNull(mainController.returnExpensesYear(2020));
        //Calendar calendar = Calendar.getInstance();
        //calendar.setTime(expenseService.returnExpences().get(0).getExpenseIssueDate());
        //assertEquals(calendar.get(Calendar.YEAR),2020);
    }



}
