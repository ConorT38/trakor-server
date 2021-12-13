package com.trakor.DAO.Cache;

import java.util.List;

import com.trakor.DAO.PeerDAO;
import com.trakor.Model.Peer;
import com.trakor.Model.Seed;

import org.springframework.stereotype.Service;

/**
 * Cache lookup of Peer nodes status.
 */
@Service
public class PeerCacheRepository implements PeerDAO {

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
