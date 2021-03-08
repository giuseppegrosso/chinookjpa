package it.plansoft.chinookjpa.dto;/* ggrosso created on 08/03/2021 inside the package - it.plansoft.chinookjpa.dto */

import it.plansoft.chinookjpa.model.Tracks;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class PlayListDto {
    private Long id;
    private String name;
    private Set<TracksDto> tracks;
}
