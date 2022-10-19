package ua.lviv.iot.db4.dblab4.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ServiceUser {
    private Integer id;
    private String nameOfProfile;
    private Integer downloadId;
}
