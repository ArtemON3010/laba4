package lpnu.service.impl;

import lpnu.dto.LotForManagerDTO;
import lpnu.entity.enumeration.LotState;
import lpnu.mapper.UserToUserDTOMapper;
import lpnu.repository.UserRepository;
import lpnu.service.LotService;
import lpnu.dto.LotDTO;
import lpnu.entity.Lot;
import lpnu.mapper.LotToLotDTOMapper;
import lpnu.mapper.ManagerMapper;
import lpnu.repository.LotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LotServiceImpl implements LotService{
    @Autowired
    private LotRepository lotRepository;

    @Autowired
    private LotToLotDTOMapper lotMapper;

    @Autowired
    private ManagerMapper managerMapper;


    @Override
    public List<LotDTO> getAllLots() {
        return lotRepository.getAllLots().stream().map(lotMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<LotForManagerDTO> getAllLotsForManager() {
        return lotRepository.getAllLotForManager().stream().map(managerMapper::toManagerDTO).collect(Collectors.toList());
    }


    @Override
    public LotDTO getLotById(final long id) {
        return lotMapper.toDTO(lotRepository.getLotById(id));
    }


    @Override
    public LotDTO saveLot(final LotDTO lotDTO) {

        final Lot lot = lotMapper.toEntity(lotDTO);
        lotRepository.saveLot(lot);
        return lotMapper.toDTO(lot);
    }

    @Override
    public LotDTO updateLot(final LotDTO lotDTO) {

        final Lot lot = lotMapper.toEntity(lotDTO);
        return lotMapper.toDTO(lotRepository.updateLot(lot));
    }

    @Override
    public void deleteLotById(long id) {
        lotRepository.deleteLotById(id);
    }

}
