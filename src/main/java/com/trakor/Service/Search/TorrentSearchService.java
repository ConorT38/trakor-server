package com.trakor.Service.Search;

import java.util.List;

import com.trakor.DAO.SearchDAO;
import com.trakor.Model.Torrent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TorrentSearchService {

    @Autowired
    private @Qualifier("searchDatabase") SearchDAO searchDatabaseRepo;

    @Autowired
    private @Qualifier("searchCache") SearchDAO searchCacheRepo;

    /** 
     * Get list of torrent results that match a given search string.
     * 
     * @param searchTerm search term for matching torrent results.
     * @return ResponseEntity<List<Torrent>>
     */
    public ResponseEntity<List<Torrent>> getTorrentSearchResults(String searchTerm) {
        return ResponseEntity.ok().body(searchCacheRepo.getTorrentSearchResults(searchTerm));
    }

}
