package lpnu.service.impl;


import lpnu.dto.AuctionDTO;
import lpnu.entity.Lot;
import lpnu.entity.Auction;
import lpnu.entity.User;
import lpnu.entity.enumeration.LotState;
import lpnu.entity.enumeration.LotVariety;

import lpnu.mapper.AuctionToAuctionMapper;
import lpnu.repository.LotRepository;
import lpnu.repository.AuctionRepository;
import lpnu.repository.UserRepository;
import lpnu.service.ParticipateAuctionService;
import lpnu.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipateAuctionServiceImpl implements ParticipateAuctionService{
    @Autowired
    private AuctionRepository auctionRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LotRepository lotRepository;

    @Autowired
    private AuctionToAuctionMapper auctionToAuctionMapper;

    @Autowired
    private EmailService emailService;



    @Override
    public AuctionDTO takePartOnCommonerAuction(Long userId,Long lotID){
        final Lot lot = lotRepository.getLotById(lotID);
        lot.setLotState(LotState.NOT_ACTIVE);
        lot.setLotVariety(LotVariety.COMMONER);
        Auction auction = new Auction();
        auction.setLot(lot);

        final User user = userRepository.getUserById(userId);
        auction.setUser(user);
        auction.setLotActive(true);

        emailService.sendSimpleMessage(user.getEmail(),
                "Welcome to a common auction", "Your lot is: " + lot.toString());

        return auctionToAuctionMapper.toDTO(auction);
    }
    @Override
    public AuctionDTO takePartOnEliteAuction(Long userId,Long lotID){
        final Lot lot = lotRepository.getLotById(lotID);
        lot.setLotState(LotState.NOT_ACTIVE);
        lot.setLotVariety(LotVariety.ELITE);
        Auction auction = new Auction();
        auction.setLot(lot);

        final User user = userRepository.getUserById(userId);
        auction.setUser(user);
        auction.setLotActive(true);

        emailService.sendSimpleMessage(user.getEmail(),
                "Welcome to a Elite auction", "Your lot is: " + lot.toString());

        return auctionToAuctionMapper.toDTO(auction);
    }
    @Override
    public AuctionDTO takePartOnVipAuction(Long userId,Long lotID){
        final Lot lot = lotRepository.getLotById(lotID);
        lot.setLotState(LotState.NOT_ACTIVE);
        lot.setLotVariety(LotVariety.VIP);
        Auction auction = new Auction();
        auction.setLot(lot);

        final User user = userRepository.getUserById(userId);
        auction.setUser(user);
        auction.setLotActive(true);

        emailService.sendSimpleMessage(user.getEmail(),
                "Welcome to a VIP auction", "Your lot is: " + lot.toString());

        return auctionToAuctionMapper.toDTO(auction);
    }

    @Override
    public void cancelParticipating(Long auctionId){
        final Auction auction = auctionRepository.getAuctionById(auctionId);
        auction.setLotActive(false);
        emailService.sendSimpleMessage(auction.getUser().getEmail(), "Auction", "Your lot " + auctionId + " canceled");
        auctionRepository.updateAuction(auction);
    }
}
