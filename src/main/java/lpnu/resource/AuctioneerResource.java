package lpnu.resource;

import lpnu.dto.SimpleUserDTO;
import lpnu.service.AuctioneerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

public class AuctioneerResource {

    @Autowired
    private AuctioneerService auctioneerService;

    @GetMapping("/auctioneers/users/{id}")
    public SimpleUserDTO getSimpleUserDTO(final @PathVariable long id){
        return auctioneerService.getSimpleUserById(id);
    }
}
