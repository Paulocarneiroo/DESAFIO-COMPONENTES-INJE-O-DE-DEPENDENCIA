package com.desafio.services;

import com.desafio.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {
    public double shipment(Order order){
        double shipmentValue;
        if (order.getBasic() < 100){
            shipmentValue = 20;
        } else if (order.getBasic() > 100 && order.getBasic() < 200) {
            shipmentValue = 12;
        }
        else {
            shipmentValue = 0;
        }
        return shipmentValue;
    }
}
