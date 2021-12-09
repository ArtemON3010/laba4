package lpnu.service.impl;

import lpnu.dto.AuctionDTO;
import lpnu.entity.Auction;
import lpnu.mapper.AuctionToAuctionMapper;
import lpnu.repository.AuctionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;
import lpnu.service.AuctionService;
import org.springframework.stereotype.Service;

@Service
public class AuctionServiceImpl implements AuctionService{
    @Autowired
    private AuctionRepository auctionRepository;
    @Autowired
    private AuctionToAuctionMapper auctionMapper;

    public AuctionServiceImpl(final AuctionRepository auctionRepository, final AuctionToAuctionMapper auctionMapper) {
        this.auctionRepository = auctionRepository;
        this.auctionMapper = auctionMapper;
    }

    @Override
    public List<AuctionDTO> getAllAuctions() {
        return auctionRepository.getAllAuctions().stream()
                .map(e -> auctionMapper.toDTO(e))
                .collect(Collectors.toList());
    }

    @Override
    public AuctionDTO getAuctionById(final Long id) {
        return auctionMapper.toDTO(auctionRepository.getAuctionById(id));
    }

    @Override
    public AuctionDTO saveAuction(final AuctionDTO auctionDTO) {

        final Auction auction = auctionMapper.toEntity(auctionDTO);

        auctionRepository.saveAuction(auction);

        return auctionMapper.toDTO(auction);
    }

    @Override
    public AuctionDTO updateAuction(final AuctionDTO auctionDTO) {

        final Auction auction = auctionMapper.toEntity(auctionDTO);

        return auctionMapper.toDTO(auctionRepository.updateAuction(auction));
    }

    @Override
    public void deleteAuctionById(final Long id) {
        auctionRepository.deleteAuctionById(id);
    }

}
