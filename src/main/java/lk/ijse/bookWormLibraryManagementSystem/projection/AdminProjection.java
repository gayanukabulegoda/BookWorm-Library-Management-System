package lk.ijse.bookWormLibraryManagementSystem.projection;

import lk.ijse.bookWormLibraryManagementSystem.embedded.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class AdminProjection {

    private int id;
    private Name name;

}
