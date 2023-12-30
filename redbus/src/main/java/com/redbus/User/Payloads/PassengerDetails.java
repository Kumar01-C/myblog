package com.redbus.User.Payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassengerDetails {
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;

}
