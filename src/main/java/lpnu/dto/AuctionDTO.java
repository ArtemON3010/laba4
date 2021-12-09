package lpnu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuctionDTO {
    private long id;
    private UserDTO user;
    private LotDTO lot;
    private double priceOfLot;
    private double lotDuration;
    private boolean isLotActive;
}
