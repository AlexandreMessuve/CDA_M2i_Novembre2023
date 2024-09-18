package org.example.kafka;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@ApplicationScoped
public class InventoryKafkaProducer {


    @Inject
    @Channel("stock-increase")
    Emitter<String> stockIncreaseEmitter;


    @Inject
    @Channel("available")
    Emitter<String> availableEmitter;

    public void publishStockIncreaseEvent(Long productId, int newQuantity){
        String message = "Product " + productId + " stock increased to " + newQuantity;
        stockIncreaseEmitter.send(message);
    }

    public void publishProductAvailabilityEvent(Long productId){
        String message = productId.toString();
        availableEmitter.send(message);
    }



}
