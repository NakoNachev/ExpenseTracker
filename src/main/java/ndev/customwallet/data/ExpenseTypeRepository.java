package ndev.customwallet.data;

import ndev.customwallet.model.ExpenseType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseTypeRepository extends CrudRepository<ExpenseType,String> {
}
