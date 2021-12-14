package com.trakor.Controller;

import java.util.List;

import com.trakor.Model.Peer;
import com.trakor.Model.Torrent;
import com.trakor.Service.Peers.PeerService;
import com.trakor.Service.Search.TorrentSearchService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/torrent")
public class PeerController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PeerService peerService;

    @GetMapping("/peers/{fileId}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<Peer>> getPeersByTorrentId(
            @PathVariable(value = "fileId") long fileId, @RequestHeader HttpHeaders headers) {
        log.info("Getting peers for fileId: '" + fileId + "'");
        return peerService.getPeersByTorrentId(fileId);
    }

}
