package lpnu.resource;

import lpnu.dto.LotDTO;
import lpnu.dto.LotForManagerDTO;
import lpnu.service.LotService;
import lpnu.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ManagerResource {
    @Autowired
    private LotService lotService;

    @Autowired
    private ManagerService managerService;

    @GetMapping("/manager/lot")
    public List<LotForManagerDTO> getAllLot() {
        return lotService.getAllLotsForManager();
    }

    @GetMapping("/manager/approve/{lotId}")
    public ResponseEntity approveLotById(final @PathVariable Long lotId) {
        managerService.approve(lotId);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/manager/deactivate/{lotId}")
    public ResponseEntity deactivateLot(final @PathVariable Long lotId) {
        managerService.deactivate(lotId);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
