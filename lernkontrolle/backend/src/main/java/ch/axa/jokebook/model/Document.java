package ch.axa.jokebook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
public class Document {

    private int id;
    private String title;
    private int sortOrder;
    private String documentUrl;
}
