package com.grounded.socials.controllers;

import com.grounded.socials.services.StoreService;
import com.grounded.socials.utils.JsonUtil;
import spark.Spark;

import static com.grounded.socials.utils.JsonUtil.json;
import static spark.Spark.*;

public class StoreController {

    public StoreController(final StoreService storeService) {
            Spark.post("/stores/create", (request, response) -> "implementing create store endpoint", json());

            get("/stores",(request, response) -> "implement getting all stores endpoint");

            get("/stores/:id", (request, response) -> {
                try {
                    int id = Integer.parseInt(request.params("id"));
                    return storeService.getStoreById(id);
                } catch (NumberFormatException e) {
                    return e.getMessage();
                }
            }, json());

            put("/stores/update/:id", (request, response) -> "implementing the update store endpoint");

            delete("/stores/delete/:id", (request, response) -> "implementing the delete store endpoint");
    }
}
