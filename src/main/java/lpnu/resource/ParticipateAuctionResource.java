package lpnu.resource;

import lpnu.dto.AuctionDTO;
import lpnu.service.ParticipateAuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ParticipateAuctionResource {
    @Autowired
    private ParticipateAuctionService participateAuctionService;


    @PostMapping("/participating-auction/common/{userId}/{lotId}")
    public AuctionDTO takePartOnCommonerAuction(@PathVariable Long userId,@PathVariable Long lotId) {
        return participateAuctionService.takePartOnCommonerAuction(userId, lotId);
    }

    @PostMapping("/participating-auction/elite/{userId}/{lotId}")
    public AuctionDTO takePartOnEliteAuction(@PathVariable Long userId,@PathVariable Long lotId) {
        return participateAuctionService.takePartOnEliteAuction(userId, lotId);
    }

    @PostMapping("/participating-auction/vip/{userId}/{lotId}")
    public AuctionDTO takePartOnVipAuction(@PathVariable Long userId,@PathVariable Long lotId) {
        return participateAuctionService.takePartOnVipAuction(userId, lotId);
    }

    @PutMapping("/cancel-participating/common/{auctionId}")
    public ResponseEntity cancelParticipating(@PathVariable Long auctionId) {
        participateAuctionService.cancelParticipating(auctionId);
        return ResponseEntity.ok().build();
    }

}
