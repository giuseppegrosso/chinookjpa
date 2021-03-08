package it.plansoft.chinookjpa.dto;/* ggrosso created on 08/03/2021 inside the package - it.plansoft.chinookjpa.dto */

import it.plansoft.chinookjpa.model.Albums;
import it.plansoft.chinookjpa.model.Genres;
import it.plansoft.chinookjpa.model.InvoiceItem;
import it.plansoft.chinookjpa.model.MediaTypes;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class TracksDto {
    private Long id;
    private String name;
    private Albums album;
    private MediaTypes mediaTypes;
    private Genres genres;
    private Set<InvoiceItem> invoiceItems;
    private String composer;
    private Long milliseconds;
    private Long bytes;
    private Double unitPrice;

}
