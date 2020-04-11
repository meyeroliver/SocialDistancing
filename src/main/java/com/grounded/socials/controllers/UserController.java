package com.grounded.socials.controllers;

import com.grounded.socials.models.User;
import com.grounded.socials.services.UserService;

import static com.grounded.socials.utils.JsonUtil.*;
import static spark.Spark.*;

public class UserController {

    public UserController(final UserService userService) {

        post("/users/create",(request, response) -> {
            if (request.body() != null && !request.body().isEmpty()) {
                if (userService.createUser(request.body())){
                    response.status(200);
                    return "User was successfully inserted";
                } else {
                    response.status(500);
                    return  "A problem occurred on the server";
                }
            } else {
                response.status(400);
                return  "A problem occorred on the client";
            }
        }, json());

        get("/users",(request, response) -> {
            return userService.getAllUsers();
        }, json());

        get("/users/:id", (request, response) -> {
            try {
                int id = Integer.parseInt(request.params("id"));
                return userService.getUser(id);
            } catch (NumberFormatException e){
                response.status(400);
                return e.getMessage();
            }
        }, json());

        put("/users/update/:id", (request, response) -> {
            try {
                int id = Integer.parseInt(request.params("id"));
                if (userService.updateUser(id, request.body())) {
                    response.status(200);
                    return "User successfully updated";
                } else {
                    response.status(500);
                    return "A problem occurred on the server";
                }
            } catch (NumberFormatException e){
                e.getMessage();
                response.status(400);
                return "Query Param id must be an integer";
            }
        }, json());

        delete("/users/delete/:id", (request, response) -> "implementing the delete user endpoint");
    }
}
