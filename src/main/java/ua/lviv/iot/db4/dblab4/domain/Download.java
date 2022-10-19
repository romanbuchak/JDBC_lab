package ua.lviv.iot.db4.dblab4.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Download {
    private Integer id;
    private String songId;
    private Float price;
    private Integer quantity;
}
