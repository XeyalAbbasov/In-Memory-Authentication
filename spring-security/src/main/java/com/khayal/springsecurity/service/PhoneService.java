package com.khayal.springsecurity.service;
import com.khayal.springsecurity.exception.PhoneNotFoundException;
import com.khayal.springsecurity.model.Phone;
import com.khayal.springsecurity.repo.PhoneRepository;
import com.khayal.springsecurity.request.CreatePhoneRequest;
import com.khayal.springsecurity.request.UpdatePhoneRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PhoneService {

    private final PhoneRepository phoneRepository;

    public Phone getPhoneById(Integer id){
        return phoneRepository.findById(id).get();
    }
    public List<Phone> getAllPhones(){
        return phoneRepository.findAll();
    }

    public List<Phone> getAllPhonesWithSorting(String field){
        return phoneRepository.findAll(Sort.by(Sort.Direction.ASC,field));
    }


    public Page<Phone> getAllPhonesWithPagination(int offset,Integer pageSize){

        Page<Phone> phones=phoneRepository.findAll(PageRequest.of(offset,pageSize));

        return phones;
    }

    public Page<Phone> getAllPhonesWithPaginationAndSorting(int offset,int pageSize,String field){

        Page<Phone> phones=phoneRepository.findAll(PageRequest.of(offset,pageSize).withSort(Sort.by(field)));

        return phones;
    }

   public Phone createPhone(final CreatePhoneRequest createPhoneRequest){

        Phone phone=new Phone();
        phone.setBrand(createPhoneRequest.getBrand());
        phone.setModel(createPhoneRequest.getModel());
        phone.setMemory(createPhoneRequest.getMemory());
        phone.setRAM(createPhoneRequest.getRAM());
        phone.setColor(createPhoneRequest.getColor());
        phone.setPrice(createPhoneRequest.getPrice());
        phone.setPublishDate(LocalDateTime.now());
        phone.setUpdateDate(LocalDateTime.now());

        return phoneRepository.save(phone);

   }
    public Phone updatePhone(final UpdatePhoneRequest updatePhoneRequest, Integer id) {

        Phone phone=findUserById(id);

        Phone updatePhone =new Phone();

        updatePhone.setId(phone.getId());
        updatePhone.setBrand(updatePhoneRequest.getBrand());
        updatePhone.setModel(updatePhoneRequest.getModel());
        updatePhone.setMemory(updatePhoneRequest.getMemory());
        updatePhone.setRAM(updatePhoneRequest.getRAM());
        updatePhone.setColor(updatePhoneRequest.getColor());
        updatePhone.setPrice(updatePhoneRequest.getPrice());
        updatePhone.setPublishDate(phone.getPublishDate());
        updatePhone.setUpdateDate(LocalDateTime.now());

        return phoneRepository.save(updatePhone);
    }

    protected Phone findUserById(Integer id) {

        return phoneRepository.findById(id)
                .orElseThrow(() -> new PhoneNotFoundException("Phone couldn't be found by following id:" + id));

    }
}
