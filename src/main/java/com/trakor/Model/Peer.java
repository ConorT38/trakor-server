package com.trakor.Model;

import java.net.InetAddress;

/**
 * A Peer node is someone with an ongoing download/leech
 * that has not yet fully downloaded the file.
 * Peers can also be uploading (seeding) parts of the file while
 * downloading.
 */
public class Peer {
    private InetAddress ipAddress;
    private FileInfo fileInfo;
    private boolean isLeeching;
    private boolean isSeeding;
    private long seedStartByte;
    private long seedEndByte;

    public Peer(InetAddress ipAddress, FileInfo fileInfo, boolean isLeeching, boolean isSeeding, long seedStartByte,
            long seedEndByte) {
        this.setIpAddress(ipAddress);
        this.setFileInfo(fileInfo);
        this.setLeeching(isLeeching);
        this.setSeeding(isSeeding);
        this.setSeedStartByte(seedStartByte);
        this.setSeedEndByte(seedEndByte);
    }

    /**
     * @return InetAddress
     */
    public InetAddress getIpAddress() {
        return ipAddress;
    }

    /**
     * @param ipAddress
     */
    public void setIpAddress(InetAddress ipAddress) {
        this.ipAddress = ipAddress;
    }

    /**
     * @return FileInfo
     */
    public FileInfo getFileInfo() {
        return fileInfo;
    }

    /**
     * @param fileInfo
     */
    public void setFileInfo(FileInfo fileInfo) {
        this.fileInfo = fileInfo;
    }

    /**
     * @return boolean
     */
    public boolean isLeeching() {
        return isLeeching;
    }

    /**
     * @param isLeeching
     */
    public void setLeeching(boolean isLeeching) {
        this.isLeeching = isLeeching;
    }

    /**
     * @return boolean
     */
    public boolean isSeeding() {
        return isSeeding;
    }

    /**
     * @param isSeeding
     */
    public void setSeeding(boolean isSeeding) {
        this.isSeeding = isSeeding;
    }

    /**
     * @return long
     */
    public long getSeedStartByte() {
        return seedStartByte;
    }

    /**
     * @param seedStartByte
     */
    public void setSeedStartByte(long seedStartByte) {
        this.seedStartByte = seedStartByte;
    }

    /**
     * @return long
     */
    public long getSeedEndByte() {
        return seedEndByte;
    }

    /**
     * @param seedEndByte
     */
    public void setSeedEndByte(long seedEndByte) {
        this.seedEndByte = seedEndByte;
    }

}
