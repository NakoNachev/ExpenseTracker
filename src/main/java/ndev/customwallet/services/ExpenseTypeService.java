package ndev.customwallet.services;

import ndev.customwallet.data.ExpenseTypeRepository;
import org.springframework.stereotype.Service;

@Service
public class ExpenseTypeService {


    private final ExpenseTypeRepository expenseTypeRepository;

    public ExpenseTypeService(ExpenseTypeRepository expenseTypeRepository) {
        this.expenseTypeRepository = expenseTypeRepository;
    }
}
