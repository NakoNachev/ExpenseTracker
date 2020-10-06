package ndev.customwallet.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
public class ExpenseType {

    private String expenseTypeId;
    private String expenseTypeName;

}
