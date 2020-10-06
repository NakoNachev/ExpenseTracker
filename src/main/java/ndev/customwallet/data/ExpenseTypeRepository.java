package ndev.customwallet.data;

import ndev.customwallet.model.ExpenseType;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ExpenseTypeRepository implements CustomDao<ExpenseType> {
    @Override
    public List<ExpenseType> getAll() {
        return null;
    }

    @Override
    public void save(ExpenseType expenseType) {

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
