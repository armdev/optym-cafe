/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.project.app.coffee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author armena
 */
@RestController
@RequestMapping("/api/v2/coffee")
public class CoffeeController {

    @GetMapping("/build")
    public String buildCoffee(@RequestParam String coffeeType) {
        if (coffeeType.equalsIgnoreCase("Americano")) {
            return "Cup of Americano";
        }

        if (coffeeType.equalsIgnoreCase("Cappuchino")) {
            return "Cup of Cappuchino";
        }

        return "Uknown Coffee";
        
    }

}
