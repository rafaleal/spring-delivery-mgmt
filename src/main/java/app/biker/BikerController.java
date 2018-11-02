package app.biker;

import app.util.EndpointConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Rafael Leal on 20/10/2018.
 */
@RestController
@RequestMapping(EndpointConstants.API_V1)
public class BikerController {

    private BikerService bikerService;

    @Autowired
    public void setBikerService(BikerService bikerService) {
        this.bikerService = bikerService;
    }

    @GetMapping(value = EndpointConstants.API_LIST_ALL_BIKERS, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<BikerDTO>> listAllBikers() {

//        return new ResponseEntity<List<BikerDTO>>("GET Response", HttpStatus.OK);
        return null;
    }

    @GetMapping(value = EndpointConstants.API_BIKER_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<BikerDTO> getBikerById(@PathVariable(value = "id") Long id) {
        BikerDTO bikerDTO = bikerService.getBikerById(id);
        return ResponseEntity.ok(bikerDTO);
    }

    @PostMapping(value = EndpointConstants.API_NEW_BIKER, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity addBiker(@RequestBody BikerDTO biker) {
        bikerService.addBiker(biker);
        return new ResponseEntity<String>("POST Response", HttpStatus.CREATED);
    }

    @PutMapping(value = EndpointConstants.API_BIKER_ID, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<String> updateBiker(@PathVariable("id") Long bikerId, @RequestBody BikerDTO bikerDTO) {

        return new ResponseEntity<String>("PUT Response", HttpStatus.OK);
    }

//    public @ResponseBody ResponseEntity deleteBiker

}
