package com.trakor.DAO.Database;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.trakor.DAO.PeerDAO;
import com.trakor.Model.FileInfo;
import com.trakor.Model.Peer;
import com.trakor.Model.Seed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * Database repository for Peer nodes.
 */
@Repository
@Qualifier("peerDatabase")
public class PeerDatabaseRepository implements PeerDAO {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * {@inheritDoc}
     */
    @Override
    public void addPeer(Peer peer) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addPeers(List<Peer> peer) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updatePeer(Peer peer) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removePeer(long peerId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Peer> getPeersByTorrentId(long torrentId) {
        try {
            FileInfo file = new FileInfo(1L, "MobyDick.mpv", 100000L, new Date(System.currentTimeMillis()));
            Peer peer = new Peer(Inet4Address.getLocalHost(), file, false, false, 0, 1000);
            Peer peer2 = new Peer(Inet4Address.getLocalHost(), file, false, false, 0, 1000);
            Peer peer3 = new Peer(Inet4Address.getLocalHost(), file, false, false, 0, 1000);
            Peer peer4 = new Peer(Inet4Address.getLocalHost(), file, false, false, 0, 1000);
            List<Peer> peers = new ArrayList<Peer>();
            peers.add(peer);
            peers.add(peer2);
            peers.add(peer3);
            peers.add(peer4);

            log.info("found '"+peers.size()+"' number of peers");
            return peers;
        } catch (UnknownHostException ex) {
            log.error("oh no");
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Seed> getSeedersByTorrentId(long torrentId) {
        // TODO Auto-generated method stub
        return null;
    }

}
