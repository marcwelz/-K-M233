package ch.axa.jokebook.model;

import lombok.Data;

import java.util.List;

@Data
public class DocFolder {

    private int id;
    private String title;
    private int sortOrder;
    private List<Document> documents;
}
