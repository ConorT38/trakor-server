package com.trakor.Model;

import java.sql.Date;

/**
 * Torrent file information.
 */
public class FileInfo {
    private Long fileId;
    private String fileName;
    private Long fileSize;
    private Date uploadDate;

    public FileInfo(Long fileId, String fileName, Long fileSize, Date uploadDate) {
        this.setFileId(fileId);
        this.setFileName(fileName);
        this.setFileSize(fileSize);
        this.setUploadDate(uploadDate);
    }

    public FileInfo(String fileName, Long fileSize, Date uploadDate) {
        this.setFileName(fileName);
        this.setFileSize(fileSize);
        this.setUploadDate(uploadDate);
    }

    /**
     * @return Long
     */
    public Long getFileId() {
        return fileId;
    }

    /**
     * @param fileId
     */
    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    /**
     * @return String
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * @return Long
     */
    public Long getFileSize() {
        return fileSize;
    }

    /**
     * @param fileSize
     */
    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * @return Date
     */
    public Date getUploadDate() {
        return uploadDate;
    }

    /**
     * @param uploadDate
     */
    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

}
