package com.trakor.DAO;

import java.util.List;

import com.trakor.Model.Torrent;

/**
 * DAO class for Torrents.
 */
public interface TorrentDAO {

    /**
     * Add torrent to data source.
     * 
     * @param torrent torrent info to be added to data source.
     */
    void addTorrent(Torrent torrent);

    /**
     * Add list of torrents to data source.
     * 
     * @param torrents torrents info to be added to data source.
     */
    void addTorrents(List<Torrent> torrents);

    /**
     * Delete torrent record from data source.
     * 
     * @param torrentId torrent identifier to be deleted from data source.
     */
    void deleteTorrent(String torrentId);

    /**
     * Get torrent by id.
     * 
     * @param torrentId unique torrent id.
     * @return {@see com.trakor.Model.Torrent}
     */
    Torrent getTorrentById(String torrentId);

    /**
     * Get list of torrents that match a given {@param searchTerm}.
     * 
     * @param searchTerm
     * @return List of {@see com.trakor.Model.Torrent}
     */
    List<Torrent> getTorrentSearchResults(String searchTerm);
}
