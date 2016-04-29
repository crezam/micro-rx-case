package com.crezam.ordering.api;

import io.vertx.core.Vertx;
import java.util.Random;

public class EmbeddedApi {

    public static void main(String[] args) {
        Vertx.vertx()
                .createHttpServer()
                .requestHandler(req -> req.response().end(Integer.toString(mockPrice())))
                .listen(8080, handler -> {
                    if (handler.succeeded()) {
                        System.out.println("OK");
                    } else {
                        System.err.println("Alert");
                    }
                });
    }

    private static int mockPrice() {
        Random r = new Random();
        return r.nextInt(1000);
    }

}
