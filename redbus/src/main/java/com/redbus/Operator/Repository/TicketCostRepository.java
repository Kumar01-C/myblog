package com.redbus.Operator.Repository;

import com.redbus.User.Entity.TicketCost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketCostRepository extends JpaRepository<TicketCost,String> {
}
