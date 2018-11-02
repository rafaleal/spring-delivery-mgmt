package app.biker;

import java.util.List;

/**
 * Created by Avell on 20/10/2018.
 */
public interface BikerService {
    List<BikerDTO> listAllBikers();
    BikerDTO getBikerById(Long id);
    void addBiker(BikerDTO biker);
    BikerDTO updateBiker(Long id, BikerDTO details);
    void deleteBikers(List<Long> ids);
}
