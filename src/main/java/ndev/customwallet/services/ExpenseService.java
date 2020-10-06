package ndev.customwallet.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import ndev.customwallet.data.ExpenseRepository;
import ndev.customwallet.data.ExpenseTypeRepository;
import ndev.customwallet.model.Expense;
import org.springframework.stereotype.Service;

import java.util.List;

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


}
