package ch.axa.jokebook.service;

import ch.axa.jokebook.model.DocFolder;
import ch.axa.jokebook.model.Document;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class DocFolderService {

    private final Map<Integer, DocFolder> docFolderMap = new ConcurrentHashMap<>();
    private final AtomicInteger idCounter = new AtomicInteger(0);

    //private final DocumentRepository repository;

    public DocFolderService() {
        addDocFolder(1, new DocFolder(1, "music", 1, List.of(new Document( 1, "first document", 3, "/data/documents/images", 244))));
        addDocFolder(2, new DocFolder(2, "game2s", 2, List.of(new Document(2, "Second document", 2,"/data/videos/micheal_jackson",5222))));
        addDocFolder(3, new DocFolder(3, "node_modules", 1, List.of(new Document(3, "third document", 2,"/data/node_modules/saved",12000))));
    }

    public Collection<DocFolder> getAllDocFolders() {
        return docFolderMap.values();
    }

    public DocFolder getFolderById(int id) {
        return docFolderMap.get(id);
    }

    public DocFolder addDocumentToFolder(int folderId, Document document) {
        DocFolder folder = getFolderById(folderId);

        List<Document> documentList = new ArrayList<>(folder.getDocuments());
        documentList.add(document);
        folder.setDocuments(documentList);

        return updateDocFolder(folderId, folder);
    }

    public DocFolder addDocFolder(int id, DocFolder document) {
        if (docFolderMap.values().stream().anyMatch(d -> d.getTitle().equals(document.getTitle()))) {
            throw new IllegalArgumentException(String.format("document with title %s already exists", document.getTitle()));
        }

        document.setId(idCounter.incrementAndGet());
        docFolderMap.put(id, document);

        return document;
    }

    public void deleteDocFolder(int id) {
        if (!docFolderMap.containsKey(id)) {
            throw new IllegalArgumentException(String.format("Product with id %d doesn't exist", id));
        }

        docFolderMap.remove(id);
    }

    public DocFolder updateDocFolder(int id, DocFolder docFolder) {
        deleteDocFolder(id);
        docFolderMap.put(id, docFolder);
        return docFolder;
    }

    public ArrayList<FileSize> getFolderSize() {
        ArrayList<FileSize> folderSizeList = new ArrayList<>();

        for(DocFolder folder: getAllDocFolders()) {
            folderSizeList.add(new FileSize(folder.getId(), getSingleFolderSize(folder.getId())));
        }

        return folderSizeList;
    }

    public double getSingleFolderSize(int id) {
        DocFolder folder = getFolderById(id);
        double totalSize = 0;
        for(Document document: folder.getDocuments()) {
            totalSize += document.getFileSizeInKB();
        }

        return totalSize;
    }
}
