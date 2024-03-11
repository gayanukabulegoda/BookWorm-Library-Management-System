package lk.ijse.bookWormLibraryManagementSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "branch")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "branch_id")
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    @Column(
            name = "contact_no",
            nullable = false,
            unique = true
    )
    private String contactNo;

    @UpdateTimestamp
    @Column(name = "last_updated")
    private Timestamp dateTimeUpdate;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

}
