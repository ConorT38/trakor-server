package com.trakor.Model;

import java.net.InetAddress;

/**
 * A seed is someone who as fully downloaded the file
 * and is currently uploading the file.
 */
public class Seed {
    private File fileInfo;
    private InetAddress ipAddress;
    private boolean isSeeding;

    public Seed(File fileInfo, InetAddress ipAddress, boolean isSeeding) {
        this.setFileInfo(fileInfo);
        this.setIpAddress(ipAddress);
        this.setSeeding(isSeeding);
    }

    /**
     * @return boolean
     */
    public boolean isSeeding() {
        return isSeeding;
    }

    /**
     * @return File
     */
    public File getFileInfo() {
        return fileInfo;
    }

    /**
     * @param fileInfo
     */
    public void setFileInfo(File fileInfo) {
        this.fileInfo = fileInfo;
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
     * @param isSeeding
     */
    public void setSeeding(boolean isSeeding) {
        this.isSeeding = isSeeding;
    }

}
