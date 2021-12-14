package com.trakor.Service.Search;

import java.util.List;

import com.trakor.DAO.TorrentDAO;
import com.trakor.Model.Torrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TorrentSearchService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private @Qualifier("torrentDatabase") TorrentDAO torrentDatabaseRepo;

    @Autowired
    private @Qualifier("torrentCache") TorrentDAO torrentCacheRepo;

    /**
     * Get list of torrent results that match a given search string.
     * 
     * @param searchTerm search term for matching torrent results.
     * @return ResponseEntity<List<Torrent>>
     */
    public ResponseEntity<List<Torrent>> getTorrentSearchResults(String searchTerm) {
        try {
            List<Torrent> cacheSearchResult = torrentCacheRepo.getTorrentSearchResults(searchTerm);
            if (cacheSearchResult.size() != 0) {
                log.info("Search term matched results in cache.");
                return ResponseEntity.ok().body(cacheSearchResult);
            }

            List<Torrent> dbTorrentsSearchResult = torrentDatabaseRepo.getTorrentSearchResults(searchTerm);
            if (dbTorrentsSearchResult.size() != 0) {
                log.info("Search term matched results in database, caching results.");
                torrentCacheRepo.addTorrents(dbTorrentsSearchResult);
                return ResponseEntity.ok().body(dbTorrentsSearchResult);
            }
        } catch (Exception ex) {
            log.error("Could not load torrent search results, Error: [" + ex.getLocalizedMessage() + "]");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
