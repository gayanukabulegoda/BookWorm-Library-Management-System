package lk.ijse.bookWormLibraryManagementSystem.dto;

import lk.ijse.bookWormLibraryManagementSystem.entity.Admin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookDto {

    private int id;
    private String name;
    private String type;
    private String language;
    private String status;
    private AdminDto admin;

}
