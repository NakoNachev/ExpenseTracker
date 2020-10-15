package ndev.customwallet.model;


import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Analysis {

    private List<Report> reportsList;

    public ObjectNode returnAvgByType()
}
