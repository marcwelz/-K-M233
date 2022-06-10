package ch.axa.jokebook.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Document {

    private int id;
    private String title;
    private int sortOrder;
    private String documentUrl;
    private double fileSizeInKB;
}
