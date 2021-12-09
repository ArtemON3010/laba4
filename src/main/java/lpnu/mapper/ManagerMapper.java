package lpnu.mapper;

import lpnu.dto.LotDTO;
import lpnu.dto.LotForManagerDTO;
import lpnu.entity.Lot;
import org.springframework.stereotype.Component;

@Component
public class ManagerMapper {
    public LotForManagerDTO toManagerDTO(final Lot lot){

        final LotForManagerDTO lotForManagerDTO = new LotForManagerDTO();

        lotForManagerDTO.setId(lot.getId());
        lotForManagerDTO.setName(lot.getName());
        lotForManagerDTO.setLotItemPrice(lot.getLotItemPrice());
        lotForManagerDTO.setLotBargain(lot.getLotBargain());
        lotForManagerDTO.setLotState(lot.getLotState());

        return  lotForManagerDTO;
    }
}
