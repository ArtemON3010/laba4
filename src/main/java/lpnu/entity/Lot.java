package lpnu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lpnu.entity.enumeration.LotState;
import lpnu.entity.enumeration.LotVariety;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lot {
    private Long id;
    private String name;
    private Double lotItemPrice;
    private Double lotBargain;
    private LotVariety lotVariety;
    private LotState lotState;

}
