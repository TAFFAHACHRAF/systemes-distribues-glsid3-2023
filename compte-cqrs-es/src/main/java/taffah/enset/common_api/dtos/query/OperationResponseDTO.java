package taffah.enset.common_api.dtos.query;

import taffah.enset.common_api.enumerations.OperationType;

import java.util.Date;

public class OperationResponseDTO {
    private Long id;
    private Date operationDate;
    private double amount;
    private OperationType operationType;
}
