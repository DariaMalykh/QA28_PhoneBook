package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder


public class Contact {

    private String name;
    private String LastName;
    private String email;
    private String address;
    private String phone;
    private String description;
}
