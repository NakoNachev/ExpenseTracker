package ndev.customwallet.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Expense {

    private int expenseId;
    @Autowired
    private ExpenseType expenseType;
    private double expenseAmount;
    private Date expenseIssueDate;
    private String expenseDescription;

}
