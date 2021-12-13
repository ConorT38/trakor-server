package com.trakor.DAO;

import java.util.List;

import com.trakor.Model.Torrent;


public interface SearchDAO {
    
    /**
     * Get list of torrents that match a given {@param searchTerm}. 
     * @param searchTerm
     * @return List of {@see com.trakor.Model.Torrent}
     */
    List<Torrent> getTorrentSearchResults(String searchTerm);
}
