package fr.amicalelaiqueabbaretz.amicalelaiqueabbaretzapi.controller;

import fr.amicalelaiqueabbaretz.amicalelaiqueabbaretzapi.service.FileStorage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class OrderController {

    @Value("${storage.orders}")
    private String ordersPath;
    private final FileStorage fileStorage;

    public OrderController(FileStorage fileStorage) {
        this.fileStorage = fileStorage;
    }

    @PostMapping("order")
    public void createOrder(@RequestBody String json) throws IOException {
        fileStorage.writeStringToFile(ordersPath + "/Order", json);
    }
}
