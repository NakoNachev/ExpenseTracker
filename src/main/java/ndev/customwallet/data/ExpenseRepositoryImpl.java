package ndev.customwallet.data;

import ndev.customwallet.model.Expense;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ExpenseRepositoryImpl implements ExpenseRepository {
    @Override
    public <S extends Expense> S save(S s) {
        return null;
    }

    @Override
    public <S extends Expense> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Expense> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public Iterable<Expense> findAll() {
        return null;
    }

    @Override
    public Iterable<Expense> findAllById(Iterable<String> iterable) {
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
    public void delete(Expense expense) {

    }

    @Override
    public void deleteAll(Iterable<? extends Expense> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
