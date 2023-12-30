package com.redbus.Operator.Controller;

import com.redbus.Operator.Entity.BusOperator;
import com.redbus.Operator.Payloads.BusOperatorDto;
import com.redbus.Operator.Payloads.PageResponse;
import com.redbus.Operator.Service.BusOperatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bus-operator")
public class BusOperatorController {

    private BusOperatorService busOperatorService;

    public BusOperatorController(BusOperatorService busOperatorService) {
        this.busOperatorService = busOperatorService;
    }

    // http://localhost:8080/api/bus-operator

    @PostMapping
    public ResponseEntity<BusOperatorDto> addBus(@RequestBody BusOperatorDto BusOperatorDto) {

        BusOperatorDto dtos = busOperatorService.saveSchedule(BusOperatorDto);

        return new ResponseEntity<>(dtos, HttpStatus.CREATED);

    }

//    @GetMapping
//    public List<BusOperatorDto> getAllBusDetails(){
//        List<BusOperatorDto> listOfBus = busOperatorService.getAllBusDetails();
//        return listOfBus;
//    }


  //  http://localhost:8080/api/bus-operator?pageNo=0&pageSize=0&sortBy=busOperatorCompanyName&sortDir=desc

    @GetMapping
    public PageResponse getAllBusDetails(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false)  int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir

    ){
        PageResponse listOfBus = busOperatorService.getAllBus(pageNo,pageSize,sortDir,sortBy);
        return listOfBus;
    }

    //  http://localhost:8080/api/bus-operator/by-company/{companyName}

    @GetMapping("/by-company/{companyName}")
    public List<BusOperator> getOperatorsByCompanyName(@PathVariable String companyName) {
        List<BusOperator> operators = busOperatorService.findByBusOperatorCompanyName(companyName);

        return operators;
    }

}
