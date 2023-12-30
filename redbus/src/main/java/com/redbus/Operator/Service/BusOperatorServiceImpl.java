package com.redbus.Operator.Service;

import com.redbus.Operator.Entity.BusOperator;
import com.redbus.Operator.Exception.ResourceNotFoundException;
import com.redbus.Operator.Payloads.BusOperatorDto;
import com.redbus.Operator.Payloads.PageResponse;
import com.redbus.Operator.Repository.BusOperatorRepository;
import com.redbus.User.Entity.TicketCost;
import com.redbus.Operator.Repository.TicketCostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BusOperatorServiceImpl implements BusOperatorService{

    private BusOperatorRepository busOperatorRepository;

    private TicketCostRepository ticketCostRepository;
    private ModelMapper mapper;

    public BusOperatorServiceImpl(BusOperatorRepository busOperatorRepository, TicketCostRepository ticketCostRepository, ModelMapper mapper) {
        this.busOperatorRepository = busOperatorRepository;
        this.ticketCostRepository = ticketCostRepository;
        this.mapper = mapper;
    }

    @Override
    public BusOperatorDto saveSchedule(BusOperatorDto busOperatorDto) {
        BusOperator busOperator = mapToEntity(busOperatorDto);

        // Create a new TicketCost entity and set its properties
        TicketCost ticketCost = new TicketCost();
        ticketCost.setTicketId(UUID.randomUUID().toString());
        ticketCost.setCode(busOperatorDto.getTicketCost().getCode());
        ticketCost.setPrice(busOperatorDto.getTicketCost().getPrice());
        ticketCost.setDiscountAmount(busOperatorDto.getTicketCost().getDiscountAmount());

      //  TicketCost savedTicketCost = ticketCostRepository.save(ticketCost);

        // Set the relationship between BusOperator and TicketCost
        busOperator.setTicketCost(ticketCost);

        // Set the busId for BusOperator
        String busId = UUID.randomUUID().toString();
        busOperator.setBusId(busId);

        // Save BusOperator along with the associated TicketCost
        BusOperator savedSchedule = busOperatorRepository.save(busOperator);

        BusOperatorDto busOperatorDtoSchedule = mapToDto(savedSchedule);
        return busOperatorDtoSchedule;

    }
//        BusOperator busOperator = mapToEntity(busOperatorDto);
//        String busId = UUID.randomUUID().toString();
//        busOperator.setBusId(busId);
//        BusOperator savedSchedule = busOperatorRepository.save(busOperator);
//        BusOperatorDto busOperatorDtoSchedule = mapToDto(savedSchedule);
//        return busOperatorDtoSchedule;
//    }
    BusOperator mapToEntity(BusOperatorDto busOperatorDto){
        BusOperator busOperator = mapper.map(busOperatorDto, BusOperator.class);
        return busOperator;
    }
    BusOperatorDto mapToDto(BusOperator BusOperator){

        BusOperatorDto busOperatorDto = mapper.map(BusOperator, BusOperatorDto.class);
        return busOperatorDto;
    }


    @Override
    public List<BusOperatorDto> getAllBusDetails() {
        List<BusOperator> allBusDetails = busOperatorRepository.findAll();
        List<BusOperatorDto> allBuses = allBusDetails.stream().map(busOperator -> mapToDto(busOperator)).collect(Collectors.toList());
        return allBuses;
    }

    @Override
    public PageResponse getAllBus(int pageNo, int pageSize, String sortDir, String sortBy) {

      Sort sort =  sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo,pageSize,sort);

        Page<BusOperator> pageObj = busOperatorRepository.findAll(pageable);
        List<BusOperator> content = pageObj.getContent();

        List<BusOperatorDto> allBuses = content.stream().map(busOperator -> mapToDto(busOperator)).collect(Collectors.toList());

       PageResponse pageResponse = new PageResponse();
       pageResponse.setDto(allBuses);
       pageResponse.setPageNo(pageObj.getNumber());
       pageResponse.setPageSize(pageObj.getSize());
        pageResponse.setTotalPages(pageObj.getTotalPages());
        pageResponse.setLastpage(pageObj.isLast());

        return pageResponse;
    }

    @Override
    public List<BusOperator> findByBusOperatorCompanyName(String companyName) {
        List<BusOperator> operators = busOperatorRepository.findByBusOperatorCompanyName(companyName);
        if (operators.isEmpty()) {
            throw new ResourceNotFoundException("Bus operators not found for company: " + companyName);
        }
        return operators;
    }


}
