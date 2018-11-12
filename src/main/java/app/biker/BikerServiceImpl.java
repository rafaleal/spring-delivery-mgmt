package app.biker;

import app.biker.dto.BikerGetDTO;
import app.biker.dto.BikerSummaryDTO;
import app.enums.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Rafael Leal on 20/10/2018.
 */
@Service
public class BikerServiceImpl implements BikerService {

    @Autowired
    private BikerRepository bikerRepository;

    @Override
    public List<BikerGetDTO> listAllBikers() {
        List<Biker> bikers = bikerRepository.findByStatusCode(StatusCode.A);
        return null;
    }

    @Override
    public List<BikerSummaryDTO> listAllBikersSummary() {
        return this.bikerRepository.getAllActiveBikersSummary();
    }

    @Override
    public BikerGetDTO getBikerById(Long id) {
        return null;
    }

    @Override
    public Biker addBiker(Biker biker) {
        biker.setStatusCode(StatusCode.A);
        return bikerRepository.save(biker);
    }

    @Override
    public BikerGetDTO updateBiker(Long id, BikerGetDTO details) {
        return null;
    }

    @Override
    public void deleteBikers(List<Long> ids) {

    }
}
