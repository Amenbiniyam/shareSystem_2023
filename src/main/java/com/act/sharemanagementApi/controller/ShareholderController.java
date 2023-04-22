package com.act.sharemanagementApi.controller;

import com.act.sharemanagementApi.model.Shareholder;
import com.act.sharemanagementApi.service.ShareholderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ShareholderController {

    @Autowired
    private ShareholderService shareholderService;
    @CrossOrigin(origins = "http://localhost:4200")

    @PostMapping("/api/shareholders")
    public ResponseEntity<?> createShareholder(@RequestBody Shareholder shareholder) throws Exception {
        try {
            Shareholder saveShareholder =  shareholderService.registerShareholder(shareholder);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(saveShareholder);
        }
        catch (Exception ex) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\":" + ex.getMessage() + "}");
        }
    }

//    @PostMapping("/api/shareholders")
//    public ResponseEntity<Shareholder> addProduct (@RequestBody Shareholder shareholder) {
//        return new ResponseEntity<>(shareholderService.addShareholder(shareholder), HttpStatus.OK);
//    }
    //@PreAuthorize("hasRole('Admin')")
//    @CrossOrigin(origins = "http://localhost:4200")
//    @GetMapping("/shareholders")
//    public Iterable<Shareholder> getAllShareholders() {
//        return shareholderService.getAll_Shareholders();
////        return accountRepository.findAll();
//    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/shareholder/{id}")
    public ResponseEntity<Shareholder> getUser (@PathVariable("id") Long id) {
        return new ResponseEntity<>(shareholderService.getshareholder(id), HttpStatus.OK);
    }
@CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/api/shareholders")
    public ResponseEntity<List<Shareholder>> getAllShareholders () {
        return new ResponseEntity<>(shareholderService.getAll_Shareholders(), HttpStatus.OK);
    }
}
