package com.redbus.Operator.Repository;

import com.redbus.Operator.Entity.BusOperator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface BusOperatorRepository extends JpaRepository<BusOperator,String> {


    List<BusOperator> findByBusOperatorCompanyName(String companyName);

   // List<BusOperator> findByDepartureCityAndArrivalCityAndDepartureDate(String departureCity, String arrivalCity, Date departureDate);


    @Query("SELECT bo FROM BusOperator bo " + "WHERE bo.departureCity = :departureCity " + "AND bo.arrivalCity = :arrivalCity " + "AND bo.departureDate = :departureDate")
    List<BusOperator> findByDepartureCityAndArrivalCityAndDepartureDate(
                @Param("departureCity") String departureCity,
                @Param("arrivalCity") String arrivalCity,
                @Param("departureDate") Date departureDate);



}
