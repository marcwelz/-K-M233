package ch.axa.jokebook.model;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class DocFolder {

    private int id;
    private String title;
    private int sortOrder;
    private List<Document> documents;
}
