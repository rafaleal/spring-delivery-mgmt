package app.biker;

import app.biker.dto.BikerGetDTO;
import app.biker.dto.BikerSummaryDTO;

import java.util.List;

/**
 * Created by Avell on 20/10/2018.
 */
public interface BikerService {
    List<BikerGetDTO> listAllBikers();
    List<BikerSummaryDTO> listAllBikersSummary();
    BikerGetDTO getBikerById(Long id);
    Biker addBiker(Biker biker);
    BikerGetDTO updateBiker(Long id, BikerGetDTO details);
    void deleteBikers(List<Long> ids);
}
