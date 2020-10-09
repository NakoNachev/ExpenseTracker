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

        } catch (Exception exc) {
            exc.printStackTrace();
        }
        System.out.println("Expenses size is" + expenses.size());
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

        for (Expense targetExpense : expenses) {
            if (targetExpense.getExpenseId() == id) {
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
     *
     * @return
     */
    public Map<ExpenseType, Double> getMapperExpenseTypeValueAll() {
        List<Expense> expenseList = this.getAll();
        Map<ExpenseType, Double> map = new HashMap<>();

        for (Expense expense : expenseList) {
            if (map.containsKey(expense.getExpenseType())) {
                map.replace(expense.getExpenseType(), map.get(expense.getExpenseType()) + Double.valueOf(expense.getExpenseAmount()));
                System.out.println("Inside contains key");
                for (ExpenseType key : map.keySet()) {
                    System.out.println(key.getExpenseTypeName() + map.get(key));
                }
            } else {
                map.put(expense.getExpenseType(), Double.valueOf(expense.getExpenseAmount()));
                System.out.println("Outside contains key");
                System.out.println("Size of ma now is " + map.size());
                for (ExpenseType key : map.keySet()) {
                    System.out.println(key.getExpenseTypeName() + map.get(key));
                }
            }


        }
        System.out.println("Mapper has size" + map.size());
        return map;
    }

    public Map<ExpenseType, Double> getMapperExpenseTypeValuePeriod(List<Expense> periodList) {

        Map<ExpenseType, Double> map = new HashMap<>();

        for (Expense expense : periodList) {
            if (map.containsKey(expense.getExpenseType())) {
                map.replace(expense.getExpenseType(), map.get(expense.getExpenseType()) + Double.valueOf(expense.getExpenseAmount()));
                System.out.println("Inside contains key");
                for (ExpenseType key : map.keySet()) {
                    System.out.println(key.getExpenseTypeName() + map.get(key));
                }
            } else {
                map.put(expense.getExpenseType(), Double.valueOf(expense.getExpenseAmount()));
            }
        }
        return map;
    }
}

