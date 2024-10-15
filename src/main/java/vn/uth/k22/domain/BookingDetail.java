package vn.uth.k22.domain;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name="booking_details")
@Data
public class BookingDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int quantity;

    private double price;

    // booking_id many to one
    @ManyToOne
    @JoinColumn(name="booking_id")
    private Booking booking;

    // service_id many to one
    @ManyToOne
    @JoinColumn(name="service_id")
    private Service service;
}


