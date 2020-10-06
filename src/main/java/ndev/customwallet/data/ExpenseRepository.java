package ndev.customwallet.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import ndev.customwallet.model.Expense;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class ExpenseRepository implements CustomDao<Expense> {

    private final ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public List<Expense> getAll() {

        List<Expense> expenses = new ArrayList<Expense>();
        try {
            expenses = Arrays.asList(objectMapper.readValue(new File("data.json"), Expense[].class));

        } catch (Exception exc){
            exc.printStackTrace();
        }

        return expenses;

    }

    @Override
    public void save(Expense expense) {
        try {
            objectMapper.writeValue(new File("data.json"),Expense.class);
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
}

