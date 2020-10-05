package ndev.customwallet.services;

import ndev.customwallet.data.ExpenseRepository;
import ndev.customwallet.data.ExpenseRepositoryImpl;
import ndev.customwallet.data.ExpenseTypeRepository;
import ndev.customwallet.data.ExpenseTypeRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepositoryImpl expenseRepositoryImpl;
    @Autowired
    private ExpenseTypeRepositoryImpl expenseTypeRepositoryImpl;


}
