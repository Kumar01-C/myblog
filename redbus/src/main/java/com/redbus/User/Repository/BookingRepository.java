package com.redbus.User.Repository;

import com.redbus.User.Entity.BookingDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<BookingDetails,String> {
}
