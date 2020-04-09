package com.grounded.socials.controllers;

import com.grounded.socials.services.StoreService;
import com.grounded.socials.utils.JsonUtil;
import spark.Spark;

import static spark.Spark.*;

public class StoreController {

    public StoreController(final StoreService storeService) {
            Spark.post("/stores/create", (request, response) -> "implementing create store endpoint", JsonUtil.json());

            get("/stores",(request, response) -> "implement getting all stores endpoint");

            get("/stores/:id", (request, response) -> "implementing getting store with id");

            put("/stores/update/:id", (request, response) -> "implementing the update store endpoint");

            delete("/stores/delete/:id", (request, response) -> "implementing the delete store endpoint");
    }
}
