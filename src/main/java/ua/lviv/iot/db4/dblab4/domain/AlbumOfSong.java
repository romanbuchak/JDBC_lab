package ua.lviv.iot.db4.dblab4.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class AlbumOfSong {
    private Integer id;
    private Integer quantity;
    private String name;
    private Integer songId;
}
