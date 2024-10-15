package vn.uth.k22.domain;


import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name="bookings")
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDateTime  startTime;
    private LocalDateTime  endTime;

    private double totalPrice;

    // many booking to one pod_id
    @ManyToOne
    @JoinColumn(name="pod_id")
    private Pod pod;

    // many booking to one user_id
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    
}
