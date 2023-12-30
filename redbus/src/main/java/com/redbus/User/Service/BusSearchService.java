package com.redbus.User.Service;

import com.redbus.Operator.Entity.BusOperator;
import com.redbus.Operator.Repository.BusOperatorRepository;
import com.redbus.User.Payloads.BusListDto;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BusSearchService {

    private BusOperatorRepository busOperatorRepository;

    public BusSearchService(BusOperatorRepository busOperatorRepository) {
        this.busOperatorRepository = busOperatorRepository;
    }

    public List<BusListDto> findByDepartureCityAndArrivalCityAndDepartureDate(String departureCity, String arrivalCity, Date departureDate) {

        List<BusOperator> buses = busOperatorRepository.findByDepartureCityAndArrivalCityAndDepartureDate(departureCity, arrivalCity, departureDate);
        List<BusListDto> busList = buses.stream().map(bus -> mapToDto(bus)).collect(Collectors.toList());
        return busList;
    }

    BusListDto mapToDto(BusOperator busOperator){
        BusListDto busListDto = new BusListDto();
        busListDto.setBusNumber(busOperator.getBusNumber());
        busListDto.setBusType(busOperator.getBusType());
        busListDto.setBusOperatorCompanyName(busOperator.getBusOperatorCompanyName());
        busListDto.setDepartureCity(busOperator.getDepartureCity());
        busListDto.setArrivalCity(busOperator.getArrivalCity());
        busListDto.setDepartureDate(busOperator.getDepartureDate());
        busListDto.setArrivalDate(busOperator.getArrivalDate());
        busListDto.setDepartureTime(busOperator.getDepartureTime());
        busListDto.setArrivalTime(busOperator.getArrivalTime());
        busListDto.setAmenities(busOperator.getAmenities());
        busListDto.setTotalTravelTime(busOperator.getTotalTravelTime());
        busListDto.setNumberSeats(busOperator.getNumberSeats());
     return busListDto;
    }
}
