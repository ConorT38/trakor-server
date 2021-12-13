package com.trakor.DAO.Database;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.trakor.DAO.SearchDAO;
import com.trakor.Model.File;
import com.trakor.Model.Peer;
import com.trakor.Model.Seed;
import com.trakor.Model.Torrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Search Database Repository class.
 */
@Repository
@Qualifier("searchDatabase")
public class SearchDatabaseRepository implements SearchDAO {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Torrent> getTorrentSearchResults(String searchTerm) {
        File file = new File(1L, "MobyDick.mpv", 100000L, new Date(System.currentTimeMillis()));
        int filePieces = 10;

        try {
            Peer peer = new Peer(Inet4Address.getLocalHost(), false, false, 0, 1000);
            List<Peer> peers = new ArrayList<Peer>();
            peers.add(peer);

            Seed seed = new Seed(file, Inet4Address.getLocalHost(), true);
            List<Seed> seeders = new ArrayList<Seed>();
            seeders.add(seed);

            Torrent torrent = new Torrent(file, filePieces, peers, seeders);
            List<Torrent> torrents = new ArrayList<Torrent>();
            torrents.add(torrent);

            return torrents;
        } catch (UnknownHostException ex) {
            return new ArrayList<Torrent>();
        }

    }

}
