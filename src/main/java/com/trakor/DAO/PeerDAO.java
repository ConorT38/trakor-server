package com.trakor.DAO;

import java.util.List;

import com.trakor.Model.Peer;
import com.trakor.Model.Seed;

/**
 * DAO class for Peers/leechers.
 */
public interface PeerDAO {

    void addPeer(Peer peer);

    void removePeer(long peerId);

    List<Peer> getPeersByFileId(long fileId);

    List<Seed> getSeedersByFileId(long fileId);

}
