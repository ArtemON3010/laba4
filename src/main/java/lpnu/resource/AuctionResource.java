package lpnu.resource;

import lpnu.service.AuctionService;
import lpnu.dto.AuctionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AuctionResource {
    @Autowired
    private AuctionService auctionService;


    @GetMapping("/auctions")
    public List<AuctionDTO> getAllAuction() {
        return auctionService.getAllAuctions();
    }

    @GetMapping("/auctions/{id}")
    public AuctionDTO getOrderById(@PathVariable final Long id) {
        return auctionService.getAuctionById(id);
    }


    @PostMapping("/auctions")
    public AuctionDTO saveAuction(@RequestBody @Validated final AuctionDTO auctionDTO) {
        return auctionService.saveAuction(auctionDTO);
    }


    @PutMapping("/auctions")
    public AuctionDTO updateAuction(@RequestBody @Validated final AuctionDTO auctionDTO) {
        return auctionService.updateAuction(auctionDTO);
    }


    @DeleteMapping("/auctions/{id}")
    public ResponseEntity deleteAuctionById(@PathVariable final Long id) {
        auctionService.deleteAuctionById(id);
        return ResponseEntity.ok().build();
    }
}
