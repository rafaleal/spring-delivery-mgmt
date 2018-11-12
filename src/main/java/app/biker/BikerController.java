package app.biker;

import app.biker.dto.BikerCreationDTO;
import app.biker.dto.BikerGetDTO;
import app.biker.dto.BikerSummaryDTO;
import app.util.DTO;
import app.util.EndpointConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Created by Rafael Leal on 20/10/2018.
 */
@RestController
@RequestMapping(EndpointConstants.API_V1)
public class BikerController {

    private final BikerService bikerService;

    @Autowired
    BikerController(BikerService bikerService) {
        this.bikerService = bikerService;
    }

    @GetMapping(value = EndpointConstants.API_LIST_ALL_BIKERS, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<BikerGetDTO>> listAllBikers() {

//        return new ResponseEntity<List<BikerDTO>>("GET Response", HttpStatus.OK);
        return null;
    }

    @GetMapping(value = EndpointConstants.API_BIKER_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<BikerGetDTO> getBikerById(@PathVariable(value = "id") Long id) {
        BikerGetDTO bikerGetDTO = bikerService.getBikerById(id);
        return ResponseEntity.ok(bikerGetDTO);
    }

    @PostMapping(value = EndpointConstants.API_NEW_BIKER, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody ResponseEntity addBiker(@RequestBody @DTO(BikerCreationDTO.class) Biker b) {
        Biker biker = bikerService.addBiker(b);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/biker/{id}")
                .buildAndExpand(biker.getId())
                .toUri();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uriOfNewResource);

        return new ResponseEntity<>(biker, httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping(value = EndpointConstants.API_BIKER_ID, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<String> updateBiker(@PathVariable("id") Long bikerId, @RequestBody BikerGetDTO bikerGetDTO) {

        return new ResponseEntity<String>("PUT Response", HttpStatus.OK);
    }

    @GetMapping(value = EndpointConstants.API_LIST_ALL_BIKERS_SUMMARY, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<BikerSummaryDTO>> getBikersSummary() {
        return new ResponseEntity<>(this.bikerService.listAllBikersSummary(), HttpStatus.OK);
    }

//    public @ResponseBody ResponseEntity deleteBiker

}
