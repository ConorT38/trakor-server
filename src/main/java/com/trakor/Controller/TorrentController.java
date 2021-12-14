package com.trakor.Controller;

import java.util.List;

import com.trakor.Model.Torrent;
import com.trakor.Service.Search.TorrentSearchService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/search")
public class TorrentController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    TorrentSearchService searchService;

    /**
     * Rest endpoint used to search for torrents in Trakor.
     * 
     * GET /api/v1/search/torrents/{searchTerm}
     * 
     * @param searchTerm Search term for torrents.
     * @param headers    Http headers.
     * @return HTTP response with Torrents stored JSON format.
     */
    @GetMapping("/torrents/{searchTerm}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<Torrent>> getTorrentSearchResults(
            @PathVariable(value = "searchTerm") String searchTerm, @RequestHeader HttpHeaders headers) {
        log.info("Search for: '" + searchTerm + "'");
        return searchService.getTorrentSearchResults(searchTerm);
    }
}
