package lpnu.service;

import lpnu.dto.AuctionDTO;
import java.util.List;

public interface AuctionService {
    List<AuctionDTO> getAllAuctions();
    AuctionDTO getAuctionById(Long id);
    AuctionDTO saveAuction(AuctionDTO user);
    AuctionDTO updateAuction(AuctionDTO user);
    void deleteAuctionById(Long id);
}
