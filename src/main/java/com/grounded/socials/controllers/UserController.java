package com.grounded.socials.controllers;

import com.grounded.socials.services.UserService;
import com.grounded.socials.utils.JsonUtil;
import spark.Spark;

import static spark.Spark.*;

public class UserController {

    public UserController(final UserService userService) {

        Spark.post("/users/create",(request, response) -> "implementing create user endpoint", JsonUtil.json());

        Spark.get("/users", "com/grounded/socials/json",(request, response) -> userService.getAllUsers(), JsonUtil.json());

        Spark.get("/users/:id", (request, response) -> "implement getting desired user by id", JsonUtil.json());

        get("users/stores/",(request, response) -> "implementing getting all stores that belong to user endpoint");

        put("/users/update/:id", (request, response) -> "implementing the update endpoint");

        delete("/users/delete/:id", (request, response) -> "implementing the delete user endpoint");
    }
}
