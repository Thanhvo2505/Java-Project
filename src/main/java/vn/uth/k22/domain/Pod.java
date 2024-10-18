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

    public Pod(int capacity, String description, long id, String img, boolean isAvailable, String location, String name, double pricePerHour) {
        this.capacity = capacity;
        this.description = description;
        this.id = id;
        this.img = img;
        this.isAvailable = isAvailable;
        this.location = location;
        this.name = name;
        this.pricePerHour = pricePerHour;
    }

    public Pod() {
    }
    
    @Override
    public String toString() {
        return "Pod [id=" + id + ", name=" + name + ", isAvailable=" + isAvailable + ", img=" + img + ", description=" + description + "]";
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}







