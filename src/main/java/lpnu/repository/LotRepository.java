package lpnu.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import lpnu.entity.Lot;
import lpnu.entity.enumeration.LotState;
import lpnu.exception.ServiceException;
import lpnu.util.JacksonUtil;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class LotRepository {
    private List<Lot> lotList;

    private long id = 1;

    @PostConstruct
    public void init(){

        final Path file = Paths.get("lot.txt");
        try {
            final String savedLotsAsString = Files.readString(file, StandardCharsets.UTF_16);
           lotList = JacksonUtil.deserialize(savedLotsAsString, new TypeReference<List<Lot>>() {});

            if (lotList == null) {
                lotList = new ArrayList<>();
                return;
            }

            final long maxId = lotList.stream().mapToLong(Lot::getId).max().orElse(1);

            this.id = maxId + 1;
        } catch (final Exception e){
            System.out.println("We have an issue");
            lotList = new ArrayList<>();
        }

    }

    @PreDestroy
    public void preDestroy(){
        final Path file = Paths.get("lot.txt");
        try {
            Files.writeString(file, JacksonUtil.serialize(lotList), StandardCharsets.UTF_16);
        } catch (final Exception e){
            System.out.println("We have an issue");
        }
    }

    public List<Lot> getAllLots() {
        return lotList.stream().filter(e -> e.getLotState() == LotState.ACTIVE).collect(Collectors.toList());
    }

    public List<Lot> getAllLotForManager() {
        return new ArrayList<>(lotList);
    }


    public Lot getLotById(final long id) {
        return lotList.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "lot with id {" + id + "} not found"));
    }


    public Lot getLotByName(final String name) {
        return lotList.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "lot with name {" + name + "} not found"));
    }

    public Lot saveLot(final Lot lot) {
        lot.setId(id);

        ++id;

        lotList.add(lot);
        return lot;
    }

    public Lot updateLot(final Lot lot) {

        final Lot savedLot = getLotById(lot.getId());

        savedLot.setName(lot.getName());
        savedLot.setLotItemPrice(lot.getLotItemPrice());
        savedLot.setLotBargain(lot.getLotBargain());
        savedLot.setLotState(lot.getLotState());
        savedLot.setLotVariety(lot.getLotVariety());


        return savedLot;
    }

        public void deleteLotById(final long id) {
        lotList = lotList.stream()
                .filter(e -> e.getId() != id)
                .collect(Collectors.toList());
    }


}
