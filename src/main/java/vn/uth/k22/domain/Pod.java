package vn.uth.k22.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;


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

    @Column(name = "price_per_hour")
    private double pricePerHour;
    private int capacity;
    @Column(name = "is_available")
    private boolean isAvailable;
    private String img;
    @Column(columnDefinition="MEDIUMTEXT")
    private String description;


    // one pod to many booking
    @OneToMany(mappedBy="pod")
    List<Booking> bookings;


    @Override
    public String toString() {
        return "Pod [id=" + id + ", name=" + name + ", location=" + location + ", pricePerHour=" + pricePerHour
                + ", capacity=" + capacity + ", isAvailable=" + isAvailable + ", img=" + img + ", description="
                + description + "]";
    }

}







