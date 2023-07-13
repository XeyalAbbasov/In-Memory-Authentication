package com.khayal.springsecurity.controller;


import com.khayal.springsecurity.model.Phone;
import com.khayal.springsecurity.request.CreatePhoneRequest;
import com.khayal.springsecurity.request.UpdatePhoneRequest;
import com.khayal.springsecurity.service.PhoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/phones")
public class PhoneController {

    private final PhoneService phoneService;

    @GetMapping
    public ResponseEntity<List<Phone>> getAllPhones(){

        return ResponseEntity.ok(phoneService.getAllPhones());
    }


    @GetMapping("/{field}")
    public ResponseEntity<List<Phone>> getAllPhonesWithSorting(@PathVariable String field){

            return ResponseEntity.ok(phoneService.getAllPhonesWithSorting(field));

    }


    @GetMapping("/pagination/{offset}/{pageSize}")
    public ResponseEntity<Page<Phone>> getAllPhonesWithPagination(@PathVariable int offset,@PathVariable int pageSize){

        Page<Phone> phones=phoneService.getAllPhonesWithPagination(offset, pageSize);

        return ResponseEntity.ok(phones);

    }

    @GetMapping("/paginationAndSort/{offset}/{pageSize}/{field}")
    public ResponseEntity<Page<Phone>> getAllPhonesWithPagination(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String field){

        Page<Phone> phones=phoneService.getAllPhonesWithPaginationAndSorting(offset, pageSize,field);

        return ResponseEntity.ok(phones);

    }


    @PostMapping("/buy")
    public ResponseEntity<Phone> createPhone(@RequestBody CreatePhoneRequest createPhoneRequest){

        return ResponseEntity.ok(phoneService.createPhone(createPhoneRequest));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Phone> updatePhone(@RequestBody UpdatePhoneRequest updatePhoneRequest,@PathVariable Integer id){

        return ResponseEntity.ok(phoneService.updatePhone(updatePhoneRequest,id));
    }

}
