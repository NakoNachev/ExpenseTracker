package ndev.customwallet.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import ndev.customwallet.model.Expense;
import ndev.customwallet.model.ExpenseType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.math.BigDecimal;
import java.net.URL;
import java.util.*;

@Repository
public class ExpenseRepository implements CustomDao<Expense> {

    private final ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public List<Expense> getAll() {

        List<Expense> expenses = new ArrayList<Expense>();
        try {
            expenses = Arrays.asList(objectMapper.readValue(new File("src/main/resources/static/data.json"), Expense[].class));

        } catch (Exception exc){
            exc.printStackTrace();
        }

        return expenses;

    }

    @Override
    public void save(Expense expense) {
        try {

            File file = new File("src/main/resources/static/data.json");

            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, true))); // append mode file writer

            objectMapper.writeValue(out, expense);
            //objectMapper.writeValue(new File("src/main/resources/static/data.json"),Expense.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Expense expense) {

    }

    @Override
    public Expense getById(int id) {

        Expense target = null;
        List<Expense> expenses = this.getAll();

        for(Expense targetExpense: expenses){
            if (targetExpense.getExpenseId() == id){
                target = targetExpense;
            }
        }
        return target;
    }

    @Override
    public void update(Expense expense) {

    }

    /**
     * Returns mapper with the combinations of expensetype and amount
     * for the whole period.
     * @return
     */
    public Map<ExpenseType, BigDecimal> getMapperExpenseTypeValueAll(){
        List<Expense> expenseList = this.getAll();
        Map<ExpenseType,BigDecimal> map = new HashMap<>();

        for(Expense expense: expenseList){
            map.put(expense.getExpenseType(),expense.getExpenseAmount());
        }

        return map;
    }

    public Map<ExpenseType,BigDecimal> getMapperExpenseTypeValuePeriod(List<Expense> periodList){

        Map<ExpenseType,BigDecimal> map = null;

        for(Expense expense: periodList){
            map.put(expense.getExpenseType(),expense.getExpenseAmount());
        }

        return map;
    }
}

