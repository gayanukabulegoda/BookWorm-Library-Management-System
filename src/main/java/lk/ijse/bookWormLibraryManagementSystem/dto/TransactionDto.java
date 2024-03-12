package lk.ijse.bookWormLibraryManagementSystem.dto;

import lk.ijse.bookWormLibraryManagementSystem.entity.TransactionDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TransactionDto {

    private int id;
    private String transactionType;
    private int bookQty;
    private String dueDate;
    private Timestamp dateAndTime;
    private List<TransactionDetail> transactionDetails;
    private UserDto user;

}
