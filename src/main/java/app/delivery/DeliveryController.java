package app.delivery;

import app.delivery.dto.DeliveryGetDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static app.util.EndpointConstants.API_DELIVERY_ID;
import static app.util.EndpointConstants.API_LIST_ALL_DELIVERIES;
import static app.util.EndpointConstants.API_V1;

@RestController
@RequestMapping(API_V1)
public class DeliveryController {

    private DeliveryService deliveryService;

    DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @GetMapping(value = API_LIST_ALL_DELIVERIES, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<DeliveryGetDTO>> getAllDeliveries() {
        return new ResponseEntity<>(this.deliveryService.listAllActiveDeliveries(), HttpStatus.OK);
    }

    @GetMapping(value = API_DELIVERY_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<DeliveryGetDTO> getDeliveryById(@PathVariable(value = "id") Long id) throws Exception {
        return new ResponseEntity<>(this.deliveryService.getDeliveryById(id), HttpStatus.OK);
    }

}
