package com.trakor.DAO.Cache;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.trakor.DAO.TorrentDAO;
import com.trakor.Model.FileInfo;
import com.trakor.Model.Peer;
import com.trakor.Model.Seed;
import com.trakor.Model.Torrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

/**
 * Cache for Torrents.
 */
@Repository
@Qualifier("torrentCache")
public class TorrentCacheRepository implements TorrentDAO {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private static final String KEY = "Torrent";

    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations<String, String, Torrent> hashOperations;

    @Autowired
    public TorrentCacheRepository(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addTorrent(Torrent torrent) {
        hashOperations.put(KEY, torrent.getId().toString(), torrent);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addTorrents(List<Torrent> torrents) {
        Map<String, Torrent> torrentsMap = new HashMap<String, Torrent>();
        for (Torrent torrent : torrents) {
            torrentsMap.put(torrent.getId().toString(), torrent);
        }

        hashOperations.putAll(KEY, torrentsMap);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteTorrent(String torrentId) {
        hashOperations.delete(KEY, torrentId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Torrent getTorrentById(String torrentId) {
        return (Torrent) hashOperations.get(KEY, torrentId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Torrent> getTorrentSearchResults(String searchTerm) {
        // TODO Auto-generated method stub
        FileInfo file = new FileInfo(1L, "MobyDick.mpv", 100000L, new Date(System.currentTimeMillis()));
        int filePieces = 10;

        try {
            Peer peer = new Peer(Inet4Address.getLocalHost(), file, false, false, 0, 1000);
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
            log.error("Could not get Torrent peers: [" + ex.getLocalizedMessage() + "]");
            return new ArrayList<Torrent>();
        }
    }

}
