package lpnu.resource;

import lpnu.dto.LotDTO;
import lpnu.dto.UserDTO;
import lpnu.service.LotService;
import lpnu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class LotResource {
    @Autowired
    private LotService lotService;

    @GetMapping("/lot")
    public List<LotDTO> getAllLot() {
        return lotService.getAllLots();
    }

    @GetMapping("/lot/{id}")
    public LotDTO getLotById(@PathVariable final long id) {
        return lotService.getLotById(id);
    }

    @PostMapping("/lot")
    public LotDTO saveLot(@RequestBody @Validated final LotDTO lotDTO) {
        return lotService.saveLot(lotDTO);
    }

    @PutMapping("/fuel")
    public LotDTO updateLot(@RequestBody @Validated final LotDTO lotDTO) {
        return lotService.updateLot(lotDTO);
    }

    @DeleteMapping("/lot/{id}")
    public ResponseEntity deleteLotById(@PathVariable final long id) {
        lotService.deleteLotById(id);
        return ResponseEntity.ok().build();
    }
}
