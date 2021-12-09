package lpnu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lpnu.entity.enumeration.LotState;
import lpnu.entity.enumeration.LotVariety;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class LotDTO {
    private Long id;

    @NotBlank
    @NotNull
    private String name;

    @Min(1)
    @NotNull
    private Double lotItemPrice;

    @Min(1)
    @NotNull
    private Double lotBargain;

    @NotNull
    private LotVariety lotVariety;

    @NotNull
    private LotState lotState;

}
