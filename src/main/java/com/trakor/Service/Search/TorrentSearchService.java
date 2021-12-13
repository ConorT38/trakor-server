package com.trakor.Service.Search;

import java.util.List;

import com.trakor.DAO.SearchDAO;
import com.trakor.Model.Torrent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TorrentSearchService {
    
    @Autowired
    SearchDAO searchDAO;

    public ResponseEntity<List<Torrent>> getTorrentSearchResults(String searchTerm) {
        // TODO Auto-generated method stub
        return searchDAO.getTorrentSearchResults(searchTerm);
    }

}
