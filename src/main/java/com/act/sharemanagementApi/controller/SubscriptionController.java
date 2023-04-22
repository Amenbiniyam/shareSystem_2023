package com.act.sharemanagementApi.controller;

import com.act.sharemanagementApi.model.Shareholder;
import com.act.sharemanagementApi.model.Subscription;
import com.act.sharemanagementApi.model.SubscriptionDTO;
import com.act.sharemanagementApi.repo.ShareholderRepository;
import com.act.sharemanagementApi.repo.SubscriptionRepository;
import com.act.sharemanagementApi.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;
    private ShareholderRepository shareholderRepository;
    private SubscriptionRepository subscriptionRepository;


//   @CrossOrigin(origins = "http://localhost:4200")
//    @PostMapping("/api/subscription")
//    public ResponseEntity<?> AddSubscription(@RequestBody Subscription subscription) throws Exception {
//        try {
//            Subscription saveSubscription =  subscriptionService.Subscribe(subscription);
//            return ResponseEntity
//                    .status(HttpStatus.CREATED)
//                    .body(saveSubscription);
//        }
//        catch (Exception ex) {
//            return ResponseEntity
//                    .status(HttpStatus.BAD_REQUEST)
//                    .body("{\"error\":" + ex.getMessage() + "}");
//        }
//    }
@CrossOrigin(origins = "http://localhost:4200")
@PostMapping("/api/subscription")
public Subscription createSubscription(@RequestBody SubscriptionDTO subscriptionDto) {
    return subscriptionService.createSubscription(subscriptionDto);
}


//   public Subscription createSubscription(SubscriptionDTO subscriptionDto) {
//       Shareholder shareholder = shareholderRepository.findById(subscriptionDto.getShareholder_id())
//               .orElseThrow(() -> new EntityNotFoundException("Shareholder not found"));
//       SubscriptionDTO subscriptiondto = new SubscriptionDTO();
//       subscriptiondto.setShareholder_id(shareholder.getId());
//       subscriptiondto.setNumberOf_Share(subscriptionDto.getNumberOf_Share());
//       subscriptiondto.setShareId(subscriptionDto.getShareId());
//       subscriptiondto.setSubs_date(subscriptionDto.getSubs_date());
//       return subscriptionRepository.save(subscriptiondto);
//   }
   // @CrossOrigin(origins = "http://localhost:4200")
//    @PostMapping("/api/subscription")
//    public Subscription createSubscription(@RequestBody Subscription subscription) {
//        Shareholder shareholder = shareholderRepository.findById(subscription.getShareholder().getId())
//                .orElseThrow(() -> new RuntimeException("Shareholder not found"));
//        subscription.setShareholder(shareholder);
//        return subscriptionRepository.save(subscription);
//    }

//    @Autowired
//    private ShareholderRepository parentRepository;
//    public ResponseEntity<?> createChild(@RequestBody SubscrptionDTO childDTO) {
//        Shareholder parent = parentRepository.findById(childDTO.getShareId())
//                .orElseThrow(() -> new ChangeSetPersister.NotFoundException("Parent not found"));
//        ChildEntity child = new ChildEntity();
//        child.setName(childDTO.getName());
//        child.setParent(parent);
//        childRepository.save(child);
//        return ResponseEntity.ok().build();
//    }

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
    @GetMapping("/api/subscription")
    public ResponseEntity<List<Subscription>> getAllShareholders () {
        return new ResponseEntity<>(subscriptionService.getAll_Subscription(), HttpStatus.OK);
    }
}
