package vn.uth.k22.domain;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;



@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String password;
    @Column(columnDefinition="MEDIUMTEXT")
    private String address;
    @Column
    private String phone;
    @Column
    private String avatar;
    @Column
    private String img;
    private Boolean isActive; // Mặc định là true

    // roleId
    // User many -> to one -> role
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy="user")
    private List<Booking> bookings;

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", address="
                + address + ", phone=" + phone + ", avatar=" + avatar + ", img=" + img + ", isActive=" + isActive
                + ", role=" + role.getName();
                
                // + ", bookings=" + bookings + "]";
    }


    public boolean isActive() {
        return isActive;
    }
    // Setter
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

}
