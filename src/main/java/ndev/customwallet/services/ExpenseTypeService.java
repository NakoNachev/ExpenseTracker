package ndev.customwallet.services;

import ndev.customwallet.data.ExpenseTypeRepository;
import ndev.customwallet.model.ExpenseType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseTypeService {


    private final ExpenseTypeRepository expenseTypeRepository;

    public ExpenseTypeService(ExpenseTypeRepository expenseTypeRepository) {
        this.expenseTypeRepository = expenseTypeRepository;
    }

    public List<ExpenseType> getAll(){
        return this.expenseTypeRepository.getAll();
    }
}
