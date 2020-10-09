package ndev.customwallet.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Generates report based on given parameters
 */
@Data
@Builder
public class Report {

    //private int reportId;
    private List<Expense> expenseList;
    private Map<ExpenseType, Double> expensetypeValueMapper;

    public ObjectNode generate(Map<String,Double> listMap){

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();

        for(Map.Entry<String, Double> entry : listMap.entrySet()){
            node.put(entry.getKey(),entry.getValue());
        }

        return node;

    }

}
