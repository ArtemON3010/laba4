package lpnu.service;

import lpnu.dto.LotDTO;
import lpnu.dto.LotForManagerDTO;

import java.util.List;

public interface LotService {

    List<LotDTO> getAllLots();
    LotDTO getLotById(long id);
    LotDTO saveLot(LotDTO lotDTO);
    LotDTO updateLot(LotDTO lotDTO);
    void deleteLotById(long id);

    List<LotForManagerDTO> getAllLotsForManager();
}
