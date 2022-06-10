package ch.axa.jokebook.controller;

import ch.axa.jokebook.model.DocFolder;
import ch.axa.jokebook.model.Document;
import ch.axa.jokebook.service.DocFolderService;
import ch.axa.jokebook.service.FileSize;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Controller
@CrossOrigin(origins = {"${app.security.cors.origin}"})
@RequestMapping("/folder")
@AllArgsConstructor

public class DocumentController {

    private final DocFolderService service;

    @GetMapping("")
    public ResponseEntity<Collection<DocFolder>> getAllDocFolders() {
        return ResponseEntity.ok().body(service.getAllDocFolders());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<DocFolder> getFolderById(@PathVariable int id) {
        return ResponseEntity.ok().body(service.getFolderById(id));
    }

    @GetMapping("/getfoldersize")
    public ResponseEntity<ArrayList<FileSize>> getFolderSize() {
        return ResponseEntity.ok().body(service.getFolderSize());
    }

    @PostMapping("/add/{id}")
    public ResponseEntity<DocFolder> addDocFolder(@PathVariable int id, @RequestBody DocFolder folder) {
        return ResponseEntity.ok().body(service.addDocFolder(id, folder));
    }

    @PutMapping("/adddocument/{folderId}")
    private ResponseEntity<DocFolder> addDocumentToFolder(@PathVariable int folderId, @RequestBody Document document) {
        return ResponseEntity.ok().body(service.addDocumentToFolder(folderId, document));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<DocFolder> updateDocFolder(@PathVariable int id, @RequestBody DocFolder folder) {
        return ResponseEntity.ok().body(service.updateDocFolder(id, folder));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteDocFolder(@PathVariable int id) {
        service.deleteDocFolder(id);
        return ResponseEntity.ok().build();
    }
}
