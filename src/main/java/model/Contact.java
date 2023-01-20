package model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class Contact {

    @Setter
    @Getter
    @ToString
    @Builder

    private String name;
    private String lastName;
    private String email;
    private String address;
    private String phone;
    private String description;

}
