package hr.intellexi.demo.tickemanageradmin.model;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class Ticket {

    @Column(name = "id")
    private String id;
    @Column(name = "FIRSTNAME")
    private String firstName;
    @Column(name = "LASTNAME")
    private String lastName;
    @Column(name = "CLUB")
    private String club;
    @Column(name = "DISTANCE")
    private String distance;
}
