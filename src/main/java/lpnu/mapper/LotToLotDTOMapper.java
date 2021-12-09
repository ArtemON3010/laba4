package lpnu.mapper;

import lpnu.dto.LotDTO;
import lpnu.entity.Lot;
import org.springframework.stereotype.Component;

@Component
public class LotToLotDTOMapper {
    public Lot toEntity(final LotDTO lotDTO){
        final Lot lot = new Lot();

        lot.setId(lotDTO.getId());
        lot.setName(lotDTO.getName());
        lot.setLotItemPrice(lotDTO.getLotItemPrice());
        lot.setLotBargain(lotDTO.getLotBargain());
        lot.setLotVariety(lotDTO.getLotVariety());
        lot.setLotState(lotDTO.getLotState());

        return lot;
    }

    public LotDTO toDTO(final Lot lot){
        final LotDTO lotDTO = new LotDTO();

        lotDTO.setId(lot.getId());
        lotDTO.setName(lot.getName());
        lotDTO.setLotItemPrice(lot.getLotItemPrice());
        lotDTO.setLotBargain(lot.getLotBargain());
        lotDTO.setLotVariety(lot.getLotVariety());
        lotDTO.setLotState(lot.getLotState());

        return lotDTO;
    }
}
