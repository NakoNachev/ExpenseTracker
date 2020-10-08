package ndev.customwallet.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import ndev.customwallet.data.ExpenseRepository;
import ndev.customwallet.data.ExpenseTypeRepository;
import ndev.customwallet.model.Expense;
import ndev.customwallet.model.ExpenseType;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final ExpenseTypeRepository expenseTypeRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public ExpenseService(ExpenseRepository expenseRepository, ExpenseTypeRepository expenseTypeRepository) {
        this.expenseRepository = expenseRepository;
        this.expenseTypeRepository = expenseTypeRepository;
    }

    public List<Expense> returnExpences(){
        return expenseRepository.getAll();
    }

    public String returnJson(){

        String jsonString = null;
        List<Expense> expenses = this.returnExpences();
        try {
            jsonString = this.objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(expenses.get(0));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        //objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        return jsonString;
    }

    public Expense returnById(int id) {
        return this.expenseRepository.getById(id);
    }

    public void saveExpense(Expense expense){

        this.expenseRepository.save(expense);
    }

    public Map<ExpenseType, BigDecimal> getMapperExpenseTypeValue() {

        return this.expenseRepository.getMapperExpenseTypeValueAll();
    }

    public Map<ExpenseType,BigDecimal> getMapperExpenseTypeValuePeriod(List<Expense> expenseList){

        return this.expenseRepository.getMapperExpenseTypeValuePeriod(expenseList);
    }

    public Map<String,BigDecimal> getMapperSum(Map<ExpenseType,BigDecimal> mapper) {

        Map<String,BigDecimal> newMapper = new HashMap<>();

        for(Map.Entry<ExpenseType, BigDecimal> entry : mapper.entrySet()){

            if (newMapper.containsKey(entry.getKey().getExpenseTypeName())){
                newMapper.put(entry.getKey().getExpenseTypeName(),newMapper.get(entry.getKey().getExpenseTypeName()).add(entry.getValue()));
            }
            else {
                newMapper.put(entry.getKey().getExpenseTypeName(),entry.getValue());
            }

        }
        return newMapper;
    }

}
