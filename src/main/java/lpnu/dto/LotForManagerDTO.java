package lpnu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lpnu.entity.enumeration.LotState;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LotForManagerDTO {
    private Long id;
    private String name;
    private Double lotItemPrice;
    private Double lotBargain;
    private LotState lotState;
}
