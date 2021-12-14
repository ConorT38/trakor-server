package com.trakor.DAO.Cache;

import java.util.List;

import com.trakor.DAO.PeerDAO;
import com.trakor.Model.Peer;
import com.trakor.Model.Seed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * Cache for Peer nodes.
 */
@Repository
@Qualifier("peerCache")
public class PeerCacheRepository implements PeerDAO {
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
        // TODO Auto-generated method stub
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
