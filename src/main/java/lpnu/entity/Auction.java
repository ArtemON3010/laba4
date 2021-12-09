package lpnu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Auction {
    private long id;
    private User user;
    private Lot lot;
    private double priceOfLot;
    private double lotDuration;
    private boolean isLotActive;

}
