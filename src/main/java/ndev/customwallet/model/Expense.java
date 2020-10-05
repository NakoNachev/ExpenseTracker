package ndev.customwallet.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data

public class Expense {

    private String expenseId;
    private BigDecimal expenseAmount;

}
