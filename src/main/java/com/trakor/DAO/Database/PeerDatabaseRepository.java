package com.trakor.DAO.Database;

import java.util.List;

import com.trakor.DAO.PeerDAO;
import com.trakor.Model.Peer;
import com.trakor.Model.Seed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Service for looking up the state of Peer nodes
 * in the tracker database.
 */
@Service
public class PeerDatabaseRepository implements PeerDAO {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void addPeer(Peer peer) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removePeer(long peerId) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Peer> getPeersByFileId(long fileId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Seed> getSeedersByFileId(long fileId) {
        // TODO Auto-generated method stub
        return null;
    }

}
