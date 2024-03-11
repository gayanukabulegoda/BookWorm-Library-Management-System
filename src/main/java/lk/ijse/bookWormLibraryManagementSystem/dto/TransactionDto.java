package lk.ijse.bookWormLibraryManagementSystem.dto;

import lk.ijse.bookWormLibraryManagementSystem.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TransactionDto {

    private int id;
    private String transactionType;
    private int bookQty;
    private String dueDate;
    private User user;

}
