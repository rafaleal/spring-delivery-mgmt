package app.biker;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Rafael Leal on 20/10/2018.
 */
@Service
public class BikerServiceImpl implements BikerService {
    @Override
    public List<BikerDTO> listAllBikers() {
        return null;
    }

    @Override
    public BikerDTO getBikerById(Long id) {
        return null;
    }

    @Override
    public void addBiker(BikerDTO biker) {

    }

    @Override
    public BikerDTO updateBiker(Long id, BikerDTO details) {
        return null;
    }

    @Override
    public void deleteBikers(List<Long> ids) {

    }
}
