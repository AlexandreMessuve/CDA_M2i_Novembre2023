package org.example.kafka;


import io.smallrye.common.annotation.Blocking;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.example.Product;
import org.example.ProductRepository;
import org.example.ProductService;

@ApplicationScoped
public class ProductKafkaConsumer {

    @Inject
    ProductRepository productRepository;

    @Inject
    ProductService productService;

    @Incoming("stock-increase")
    @Blocking
    @Transactional
    public void updateProductStock(String message) {
        Long productId = parseProductIdFromMessage(message);
        int newQuantity = parseQuantityFromMessage(message);
        Product product = productRepository.findById(productId);
        if (product != null) {
            product.setQuantity(product.getQuantity()+newQuantity);
            productRepository.persist(product);
        }
    }

    private Long parseProductIdFromMessage(String message) {
        // Extract the productId from the message
        // Example: "Product 1001 stock increased to 50"
        String[] parts = message.split(" ");
        return Long.parseLong(parts[1]);
    }

    private int parseQuantityFromMessage(String message) {
        // Extract the new quantity from the message
        String[] parts = message.split(" ");
        return Integer.parseInt(parts[5]);
    }

    @Incoming("available")
    @Blocking
    public void consume(ConsumerRecord<String, String> record){
        Long productId = Long.valueOf(record.value());
        productService.updateProductAvailability(productId);
    }




}