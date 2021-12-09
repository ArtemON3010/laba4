package lpnu.repository;

import lpnu.entity.Auction;
import lpnu.entity.Lot;
import lpnu.exception.ServiceException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AuctionRepository {
    private List<Auction> auctions = new ArrayList<>();

    private long id = 1;

    public List<Auction> getAllAuctions() {
        return new ArrayList<>(auctions);
    }

    public Auction getAuctionById(final long id) {
        return auctions.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "Auction with id {" + id + "} not found"));
    }

    public Auction saveAuction(final Auction auction) {
        auction.setId(id);

        ++id;

        auctions.add(auction);
        return auction;
    }

    public Auction updateAuction(final Auction auction) {

        final Auction savedAuction = getAuctionById(auction.getId());

        savedAuction.setPriceOfLot(auction.getPriceOfLot());
        savedAuction.setLotDuration(auction.getLotDuration());
        savedAuction.setLot(auction.getLot());
        savedAuction.setUser(auction.getUser());

        return savedAuction;
    }

    public void deleteAuctionById(final long id) {
        auctions = auctions.stream()
                .filter(e -> e.getId() != id)
                .collect(Collectors.toList());
    }
}
