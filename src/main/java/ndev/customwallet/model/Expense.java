package ndev.customwallet.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class Expense {

    private int expenseId;
    @Autowired
    private ExpenseType expenseType;
    private BigDecimal expenseAmount;
    private Date expenseIssueDate;
    private String expenseDescription;

}
