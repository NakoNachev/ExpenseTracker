package ndev.customwallet.data;

import ndev.customwallet.model.Expense;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface ExpenseRepository extends CrudRepository<Expense,String> {
}
