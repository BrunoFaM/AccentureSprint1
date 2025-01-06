package com.example.myapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/api/greeting")
    @Operation(summary = "Get Greeting", description = "Returns a greeting message")
    public String getGreeting() {
        return "Hello, World!";
    }

    @PostMapping("/api/submit")
    @Operation(summary = "Submit Data", description = "Receives data and returns a confirmation message.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Data successfully received."),
            @ApiResponse(responseCode = "400", description = "Bad request, invalid data.")
    }
    )
    public String submitData(@RequestBody String data) {
        return "Data received: " + data;
    }

    @GetMapping("/api/user/{id}")
    @Operation(summary = "Get user by ID", description = "Receives an id and returns the User ID")
    public String getUserById(@PathVariable("id") Long id) {
        return "User ID: " + id;
    }

    @GetMapping("/api/search")
    @Operation(summary = "Search", description = "Searches for items based on a query parameter.")
    public String search(
            @RequestParam(name = "query", defaultValue = "")
            @Parameter(description = "Search query") String query) {
        return "Search results for: " + query;
    }
}
