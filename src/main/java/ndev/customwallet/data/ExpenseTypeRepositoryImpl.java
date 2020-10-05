package ndev.customwallet.data;

import ndev.customwallet.model.ExpenseType;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ExpenseTypeRepositoryImpl implements ExpenseTypeRepository {
    @Override
    public <S extends ExpenseType> S save(S s) {
        return null;
    }

    @Override
    public <S extends ExpenseType> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<ExpenseType> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public Iterable<ExpenseType> findAll() {
        return null;
    }

    @Override
    public Iterable<ExpenseType> findAllById(Iterable<String> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(ExpenseType expenseType) {

    }

    @Override
    public void deleteAll(Iterable<? extends ExpenseType> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
