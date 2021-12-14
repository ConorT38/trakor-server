package com.trakor.Service.Peers;

import java.util.List;

import com.trakor.DAO.PeerDAO;
import com.trakor.Model.Peer;
import com.trakor.Model.Seed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Peer lookup service.
 */
@Service
public class PeerService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private @Qualifier("peerDatabase") PeerDAO peerDatabaseRepo;

    @Autowired
    private @Qualifier("peerCache") PeerDAO peerCacheRepo;

    public void addPeer(Peer peer) {
        // TODO Auto-generated method stub

    }

    public void removePeer(long peerId) {
        // TODO Auto-generated method stub

    }

    public ResponseEntity<List<Peer>> getPeersByTorrentId(long torrentId) {
        try {
            List<Peer> peerCacheResult = peerCacheRepo.getPeersByTorrentId(torrentId);
            if (peerCacheResult != null && peerCacheResult.size() != 0) {
                log.info("Peer results found in cache.");
                return ResponseEntity.ok().body(peerCacheResult);
            }

            List<Peer> peerDatabaseResult = peerDatabaseRepo.getPeersByTorrentId(torrentId);
            if (peerDatabaseResult != null && peerDatabaseResult.size() != 0) {
                log.info("Peer results found in database, caching results.");
                peerCacheRepo.addPeers(peerDatabaseResult);
                return ResponseEntity.ok().body(peerDatabaseResult);
            }
        } catch (Exception ex) {
            log.error("Could not load peers for torrent, Error: [" + ex.getLocalizedMessage() + "]");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    public ResponseEntity<List<Seed>> getSeedersByTorrentId(long torrentId) {
        // TODO Auto-generated method stub
        return null;
    }

}
