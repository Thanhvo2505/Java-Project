package vn.uth.k22.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import java.util.List;




@Entity
@Table(name="pods")
@Data
public class Pod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name ;

    @Column(columnDefinition="TEXT")
    private String location;

    private double price_per_hour;
    private int capacity;
    private boolean isAvailable;
    private String img;
    @Column(columnDefinition="MEDIUMTEXT")
    private String description;


    // one pod to many booking
    @OneToMany(mappedBy="pod")
    List<Booking> bookings;

}







