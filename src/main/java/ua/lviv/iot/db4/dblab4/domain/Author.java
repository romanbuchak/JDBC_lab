package ua.lviv.iot.db4.dblab4.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Author {
    private Integer id;
    private String name;
    private String surname;
    private String gender;
    private String email;
    private Integer songId;
}
