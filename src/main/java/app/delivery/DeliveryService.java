package app.delivery;

import app.delivery.dto.DeliveryGetDTO;

import java.util.List;

public interface DeliveryService {
    List<DeliveryGetDTO> listAllActiveDeliveries();
    DeliveryGetDTO getDeliveryById(Long id) throws Exception;
}
