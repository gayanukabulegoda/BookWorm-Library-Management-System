package lk.ijse.bookWormLibraryManagementSystem.entity;

import lk.ijse.bookWormLibraryManagementSystem.embedded.TransactionDetailPK;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "transaction_detail")
public class TransactionDetail {

    @EmbeddedId
    private TransactionDetailPK transactionDetailPK;

    @CreationTimestamp
    @Column(name = "date_and_time")
    private Timestamp dateAndTime;

    @ManyToOne
    @JoinColumn(
            name = "transaction_id",
            insertable = false,
            updatable = false
    )
    private Transaction transaction;

    @ManyToOne
    @JoinColumn(
            name = "book_id",
            insertable = false,
            updatable = false
    )
    private Book book;

}
