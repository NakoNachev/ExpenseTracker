package ndev.customwallet.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Generates report based on given parameters
 */
@Data
public class Report {

    //private int reportId;
    private List<Expense> expenseList;
    private Map<ExpenseType, BigDecimal> expensetypeValueMapper;
}
