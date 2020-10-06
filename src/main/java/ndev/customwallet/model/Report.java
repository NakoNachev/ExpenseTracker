package ndev.customwallet.model;

import lombok.Data;

import java.util.List;

/**
 * Generates report based on given parameters
 */
@Data
public class Report {

    private int reportId;
    private List<Expense> expenseList;
}
