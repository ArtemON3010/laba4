package lpnu.service;

import lpnu.dto.AuctionDTO;

public interface ParticipateAuctionService {
    AuctionDTO takePartOnCommonerAuction(Long userId,Long lotID);
    AuctionDTO takePartOnEliteAuction(Long userId,Long lotID);
    AuctionDTO takePartOnVipAuction(Long userId,Long lotID);


    void cancelParticipating(Long auctionId);
}
