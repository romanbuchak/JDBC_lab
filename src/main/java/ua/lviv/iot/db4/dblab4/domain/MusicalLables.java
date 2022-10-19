package ua.lviv.iot.db4.dblab4.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class MusicalLables {
    private Integer id;
    private String name;
    private String isAvard;
    private Integer songId;
}
