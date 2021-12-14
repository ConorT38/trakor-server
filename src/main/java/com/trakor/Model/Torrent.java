package com.trakor.Model;

import java.util.List;

/**
 * Torrent information for file.
 */
public class Torrent {
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
        this.setFile(file);
        this.setFilePieces(filePieces);
        this.setSeeders(seeders);
        this.setPeers(peers);
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
