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
     * Remove torrent record from data source.
     * 
     * @param torrentId torrent identifier to be deleted from data source.
     */
    void removeTorrent(long torrentId);

    /**
     * Get list of torrents that match a given {@param searchTerm}.
     * 
     * @param searchTerm
     * @return List of {@see com.trakor.Model.Torrent}
     */
    List<Torrent> getTorrentSearchResults(String searchTerm);
}
