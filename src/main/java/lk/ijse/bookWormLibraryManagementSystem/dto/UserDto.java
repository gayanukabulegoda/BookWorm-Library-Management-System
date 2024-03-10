package lk.ijse.bookWormLibraryManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {

    private int id;
    private String name;
    private String email;
    private String username;
    private String password;
    private AdminDto admin;

}
