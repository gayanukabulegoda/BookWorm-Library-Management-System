package lk.ijse.bookWormLibraryManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BranchDto {

    private int id;
    private String name;
    private String location;
    private String contactNo;
    private AdminDto admin;

}
