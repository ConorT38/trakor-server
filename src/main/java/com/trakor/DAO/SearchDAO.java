package com.trakor.DAO;

import java.util.List;

import com.trakor.Model.Torrent;

import org.springframework.http.ResponseEntity;

public interface SearchDAO {
    ResponseEntity<List<Torrent>> getTorrentSearchResults(String searchTerm);
}
