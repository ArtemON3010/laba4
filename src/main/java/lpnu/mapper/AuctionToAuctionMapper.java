package lpnu.mapper;

import lpnu.dto.AuctionDTO;
import lpnu.entity.Auction;
import lpnu.entity.Lot;
import lpnu.repository.LotRepository;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class AuctionToAuctionMapper {

    @Autowired
    private UserToUserDTOMapper userMapper;
    @Autowired
    private LotToLotDTOMapper lotMapper;


    @Autowired
    private LotRepository lotRepository;
    public Auction toEntity(final AuctionDTO auctionDTO){

        final Auction auction = new Auction();

        auction.setId(auctionDTO.getId());
        auction.setPriceOfLot(auctionDTO.getPriceOfLot());

        auction.setUser(userMapper.toEntity(auctionDTO.getUser()));
        auction.setLot(lotMapper.toEntity(auctionDTO.getLot()));

        auction.setLotDuration(auctionDTO.getLotDuration());
        auction.setLotActive(auctionDTO.isLotActive());



        return auction;
    }

    public AuctionDTO toDTO(final Auction auction) {
        final AuctionDTO auctionDTO = new AuctionDTO();

        auctionDTO.setId(auction.getId());
        auctionDTO.setPriceOfLot(auction.getPriceOfLot());

        auctionDTO.setUser(userMapper.toDTO(auction.getUser()));
        auctionDTO.setLot(lotMapper.toDTO(auction.getLot()));

        auctionDTO.setLotDuration(auction.getLotDuration());
        auctionDTO.setLotActive(auction.isLotActive());

        return auctionDTO;
    }
}

