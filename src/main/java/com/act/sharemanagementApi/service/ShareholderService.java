package com.act.sharemanagementApi.service;

import com.act.sharemanagementApi.exceptions.ProductNotFoundException;
import com.act.sharemanagementApi.model.Shareholder;
import com.act.sharemanagementApi.repo.ShareholderRepository;
import com.act.sharemanagementApi.utils.DuplicationCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShareholderService {
    // here we need the repository then we can not instantiate repo here
    //YOU CANNOT DO THIS! ShareholderRepository shareholderRepository = new ShareholderRepository();
    // then we use Singleton Pattern  is who have @annotation
    @Autowired
    private ShareholderRepository shareholderRepository;

    // this method accept Shareholders Object and return Shareholders
    public Shareholder registerShareholder(Shareholder shareholder) throws Exception {
        // here we can write validation and if we throw exception here in the service we have to catch it in Controller
        Boolean IsphoneExist = DuplicationCheck.findPhoneNumber(shareholder.getPhoneNumber());
        if(IsphoneExist == true) {
            throw new Exception("Phone Number is Exist");
        }

        return shareholderRepository.save(shareholder);
    }

//    public Iterable<Shareholder> getAll_Shareholders() {
//
//        //Business Logic comes here
//        // E.g. removing pin from being displayed or returned, merging names, filtering ...
//        return shareholderRepository.findAll();
//    }
    public Shareholder addShareholder (Shareholder shareholder) {
        return shareholderRepository.save(shareholder);
    }
    public List<Shareholder> getAll_Shareholders () {

        return shareholderRepository.findAll();
    }
    public Shareholder getshareholder (Long id) {
        return shareholderRepository.findById(id).orElseThrow(() ->
                new ProductNotFoundException("Product by id " + id + " was not found."));
    }

}
