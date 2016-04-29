package com.crezam.ordering.api;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;

import java.util.Random;

public class EmbeddedApi {

    public static void main(String[] args) {

        Vertx vertx = Vertx.vertx();

        HttpServer server = vertx.createHttpServer();
        Router router = Router.router(vertx);

        router.route("/price").handler(routingContext -> {
            HttpServerResponse response = routingContext.response();
            response.putHeader("content-type", "application/json");
            response.end(mockPriceDoc());
        });

        server.requestHandler(router::accept).listen(8080);
    }

    private static String mockPriceDoc() {
        Random r = new Random();
        return "{ \"price\":" + r.nextInt(1000) + " }";
    }

}
