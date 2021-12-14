package com.trakor.DAO;

import java.util.List;

import com.trakor.Model.Peer;
import com.trakor.Model.Seed;

/**
 * DAO class for Peers/leechers.
 */
public interface PeerDAO {

    void addPeer(Peer peer);

    void addPeers(List<Peer> peer);

    void updatePeer(Peer peer);

    void removePeer(long peerId);

    List<Peer> getPeersByTorrentId(long torrentId);

    List<Seed> getSeedersByTorrentId(long torrentId);

}
