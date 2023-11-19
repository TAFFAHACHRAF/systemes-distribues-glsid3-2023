package taffah.enset.common_api.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class CreatAccountRequestDTO {
    private double initialBalance;
    private String currency;

}
