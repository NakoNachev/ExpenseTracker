package ndev.customwallet;

import ndev.customwallet.model.Expense;
import ndev.customwallet.services.ExpenseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestService {

    @Autowired
    private ExpenseService expenseService;

    @Test
    public void testService(){

        //List<Expense> expenseList = expenseService.returnExpences();

        //assertEquals(expenseList.size(),0);
    }

}
