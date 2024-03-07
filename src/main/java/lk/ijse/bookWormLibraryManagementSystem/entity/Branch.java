package lk.ijse.bookWormLibraryManagementSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity(name = "branch")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "branch_id")
    private int id;
    private String name;
    private String location;
    @Column(name = "contact_no")
    private String contactNo;

    @CreationTimestamp
    @Column(name = "date_and_time")
    private Timestamp dateAndTime;

    @UpdateTimestamp
    @Column(name = "last_updated")
    private Timestamp dateTimeUpdate;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

}