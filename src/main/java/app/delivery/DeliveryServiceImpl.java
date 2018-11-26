package app.delivery;

import app.delivery.dto.DeliveryGetDTO;
import app.delivery.dto.DeliveryMapper;
import app.enums.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    DeliveryRepository deliveryRepository;

    @Autowired
    DeliveryMapper deliveryMapper;

    @Override
    public List<DeliveryGetDTO> listAllActiveDeliveries() {
        return deliveryMapper.deliveriesToDeliveryGetDTOList(this.deliveryRepository.findByStatusCode(StatusCode.A));
    }

    @Override
    public DeliveryGetDTO getDeliveryById(Long id) throws Exception {
        Optional<Delivery> optionalDelivery = this.deliveryRepository.findById(id);
        if (optionalDelivery.isPresent()) {
            return deliveryMapper.deliveryToDeliveryGetDTO(optionalDelivery.get());
        } else {
            throw new Exception("Not found");
        }
    }


}
