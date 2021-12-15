package com.trakor.Model;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import org.springframework.data.redis.core.RedisHash;

/**
 * Torrent information for file.
 */
@RedisHash("Torrent")
public class Torrent implements Serializable {
    private UUID id;
    private FileInfo file;
    private int filePieces;
    private List<Peer> peers;
    private List<Seed> seeders;

    /**
     * Creates a new instance of Torrent.
     * 
     * @param file       The file to be torrented.
     * @param filePieces The number of chunks/pieces of the file that is
     *                   split between peer nodes.
     * @param peers      List of all peers downloading this torrent.
     * @param seeders    List of all seeders of the torrent.
     */
    public Torrent(FileInfo file, int filePieces, List<Peer> peers, List<Seed> seeders) {
        this.setId(UUID.randomUUID());
        this.setFile(file);
        this.setFilePieces(filePieces);
        this.setSeeders(seeders);
        this.setPeers(peers);
    }

    /**
     * Creates a new instance of Torrent.
     * 
     * @param id         Unique ID generated for a torrent.
     * @param file       The file to be torrented.
     * @param filePieces The number of chunks/pieces of the file that is
     *                   split between peer nodes.
     * @param peers      List of all peers downloading this torrent.
     * @param seeders    List of all seeders of the torrent.
     */
    public Torrent(UUID id, FileInfo file, int filePieces, List<Peer> peers, List<Seed> seeders) {
        this.setId(id);
        this.setFile(file);
        this.setFilePieces(filePieces);
        this.setSeeders(seeders);
        this.setPeers(peers);
    }

    /**
     * @return long
     */
    public UUID getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * @return File
     */
    public FileInfo getFile() {
        return this.file;
    }

    /**
     * @param file
     */
    public void setFile(FileInfo file) {
        this.file = file;
    }

    /**
     * @return int
     */
    public int getFilePieces() {
        return filePieces;
    }

    /**
     * @param filePieces
     */
    public void setFilePieces(int filePieces) {
        this.filePieces = filePieces;
    }

    /**
     * @return List<Peer>
     */
    public List<Peer> getPeers() {
        return peers;
    }

    /**
     * @param peers
     */
    public void setPeers(List<Peer> peers) {
        this.peers = peers;
    }

    /**
     * @return List<Seed>
     */
    public List<Seed> getSeeders() {
        return seeders;
    }

    /**
     * @param seeders
     */
    public void setSeeders(List<Seed> seeders) {
        this.seeders = seeders;
    }
}
