package com.trakor.DAO.Database;

import java.net.Inet4Address;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.trakor.DAO.SearchDAO;
import com.trakor.Model.File;
import com.trakor.Model.Peer;
import com.trakor.Model.Seed;
import com.trakor.Model.Torrent;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

/**
 * Search Database Repository class.
 */
@Repository
public class SearchDatabaseRepository implements SearchDAO{

    @Override
    public ResponseEntity<List<Torrent>> getTorrentSearchResults(String searchTerm) {
        File file = new File(1L, "MovieDick.mpv", 100000L,new Date(System.currentTimeMillis()));
        int filePieces = 10;
        
        try{
        Peer peer = new Peer(Inet4Address.getLocalHost(),false, false,0, 1000);
        List<Peer> peers = new ArrayList<Peer>();
        peers.add(peer);
        
        Seed seed = new Seed(file, Inet4Address.getLocalHost(), true);
        List<Seed> seeders = new ArrayList<Seed>();
        seeders.add(seed);

        Torrent torrent = new Torrent(file, filePieces, peers, seeders);
        List<Torrent> torrents = new ArrayList<Torrent>();
        torrents.add(torrent);

        return ResponseEntity.ok().body(torrents);
        } catch(UnknownHostException ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
}
