package lk.ijse.bookWormLibraryManagementSystem.entity;

import lk.ijse.bookWormLibraryManagementSystem.embedded.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private int id;

    @Column(nullable = false)
    private Name name;

    @Column(
            name = "contact_no",
            nullable = false,
            unique = true
    )
    private String contactNo;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @UpdateTimestamp
    @Column(name = "last_updated")
    private Timestamp dateTimeUpdate;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "admin"
    )
    private List<User> users = new ArrayList<>();

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "admin"
    )
    private List<Branch> branches = new ArrayList<>();

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "admin"
    )
    private List<Book> books = new ArrayList<>();

}
