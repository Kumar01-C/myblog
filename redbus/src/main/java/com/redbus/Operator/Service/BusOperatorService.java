package com.redbus.Operator.Service;

import com.redbus.Operator.Entity.BusOperator;
import com.redbus.Operator.Payloads.BusOperatorDto;
import com.redbus.Operator.Payloads.PageResponse;

import java.util.List;

public interface BusOperatorService {
    BusOperatorDto saveSchedule(BusOperatorDto busOperatorDto);

    List<BusOperatorDto> getAllBusDetails();

    PageResponse getAllBus(int pageNo, int pageSize, String sortDir, String sortBy);


    List<BusOperator> findByBusOperatorCompanyName(String companyName);
}
