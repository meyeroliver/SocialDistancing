package com.grounded.socials.controllers;

import com.grounded.socials.services.UserService;
import com.grounded.socials.utils.JsonUtil;
import static spark.Spark.*;


public class UserController {

    public UserController(final UserService userService) {

        post("/users/create",(request, response) -> "implementing create user endpoint", JsonUtil.json());

        get("/users",(request, response) -> "implement getting all users", JsonUtil.json());

        get("/users/:id", (request, response) -> {
            try {
                int id = Integer.parseInt(request.params("id"));
                return userService.getUser(id);
            } catch (NumberFormatException e){
                return e.getMessage();
            }
        }, JsonUtil.json());

        get("users/stores/",(request, response) -> "implementing getting all stores that belong to user endpoint");

        put("/users/update/:id", (request, response) -> "implementing the update endpoint");

        delete("/users/delete/:id", (request, response) -> "implementing the delete user endpoint");
    }
}
