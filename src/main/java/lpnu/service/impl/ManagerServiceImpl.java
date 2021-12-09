package lpnu.service.impl;

import lpnu.entity.Lot;
import lpnu.entity.enumeration.LotState;
import lpnu.exception.ServiceException;
import lpnu.repository.LotRepository;
import lpnu.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private LotRepository lotRepository;

    @Override
    public void approve(final Long lotId) {
        final Lot lot = lotRepository.getLotById(lotId);

        lot.setLotState(LotState.ACTIVE);

        lotRepository.updateLot(lot);
    }
    @Override
    public void deactivate(final Long lotId) {
        final Lot lot = lotRepository.getLotById(lotId);

        if(lot.getLotState() != LotState.ACTIVE){
            throw new ServiceException(400, "Lot should be in active state", "Current state: " + lot.getLotState());
        }

        lot.setLotState(LotState.NOT_ACTIVE);

        lotRepository.updateLot(lot);
    }

    @Override
    public void delete(final Long lotId) {
        final Lot lot = lotRepository.getLotById(lotId);

        lot.setLotState(LotState.DELETED);

        lotRepository.updateLot(lot);
    }
}
