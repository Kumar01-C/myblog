package com.redbus.User.Controller;

import com.redbus.Operator.Entity.BusOperator;
import com.redbus.Operator.Repository.BusOperatorRepository;
import com.redbus.User.Payloads.BusListDto;
import com.redbus.User.Service.BusSearchService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/buses")
public class FindBusesController {

    private BusSearchService busSearchService;
    public FindBusesController(BusSearchService busSearchService) {
        this.busSearchService = busSearchService;
    }

// GET http://localhost:8080/api/buses/search-buses?departureCity=City1&arrivalCity=City2&departureDate=01/01/2023

    @GetMapping("/search-buses") // retriving only required fields for bus
    public List<BusListDto> searchBus(
            @RequestParam(required = false) String departureCity,
            @RequestParam(required = false) String arrivalCity,
            @RequestParam(required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date departureDate) {

        List<BusListDto> busList = busSearchService
                .findByDepartureCityAndArrivalCityAndDepartureDate(departureCity, arrivalCity, departureDate);

        return busList;
    }

}
