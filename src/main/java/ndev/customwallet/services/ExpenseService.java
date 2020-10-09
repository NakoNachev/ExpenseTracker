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

    public Map<ExpenseType, Double> getMapperExpenseTypeValue() {

        return this.expenseRepository.getMapperExpenseTypeValueAll();
    }

    public Map<ExpenseType,Double> getMapperExpenseTypeValuePeriod(List<Expense> expenseList){

        return this.expenseRepository.getMapperExpenseTypeValuePeriod(expenseList);
    }

    public Map<String,Double> getMapperSum(Map<ExpenseType,Double> mapper) {

        Map<String,Double> newMapper = new HashMap<>();

        for(Map.Entry<ExpenseType, Double> entry : mapper.entrySet()){

            if (newMapper.containsKey(entry.getKey().getExpenseTypeName())){
                newMapper.replace(entry.getKey().getExpenseTypeName(),newMapper.get(entry.getKey().getExpenseTypeName()) + (entry.getValue()));
                System.out.println("updated");
            }
            else {
                newMapper.put(entry.getKey().getExpenseTypeName(),entry.getValue());
                System.out.println("In else method");
            }

        }
        return newMapper;
    }

}
