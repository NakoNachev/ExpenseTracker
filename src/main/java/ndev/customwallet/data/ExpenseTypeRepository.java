package ndev.customwallet.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import ndev.customwallet.model.Expense;
import ndev.customwallet.model.ExpenseType;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ExpenseTypeRepository implements CustomDao<ExpenseType> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<ExpenseType> getAll() {

        List<ExpenseType> expenseTypesList = null;
        try {
            expenseTypesList = Arrays.asList(objectMapper.readValue(new File("expenseTypes.json"),ExpenseType[].class));
        } catch (Exception exc) {
            exc.printStackTrace();
        }

        return expenseTypesList;
    }

    @Override
    public void save(ExpenseType expenseType) {

        try {
            objectMapper.writeValue(new File("expenseTypes.json"), ExpenseType.class);
        } catch (Exception exc){
            exc.printStackTrace();
        }

    }

    @Override
    public void delete(ExpenseType expenseType) {

    }

    @Override
    public ExpenseType getById(int id) {
        return null;
    }

    @Override
    public void update(ExpenseType expenseType) {

    }
}
