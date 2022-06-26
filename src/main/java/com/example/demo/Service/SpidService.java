package com.example.demo.Service;


import com.example.demo.Repository.SpidRespository;
import com.example.demo.Entities.Spid;
import com.example.demo.Entities.Status;
import com.example.demo.Entities.Type;
import com.example.demo.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpidService {

    @Autowired
    SpidRespository spidRepository;
    public Spid createSpid(User user){
        Spid newSpid = new Spid(user, Status.PENDING, Type.LEVEL_1);
        return spidRepository.save(newSpid);
    }

    public Optional<Spid> getSpid(long id){
        return spidRepository.findById(id);
    }
    public List<Spid> getAllSpid(){
        return spidRepository.findAll();
    }
    public void deleteSpid(long id){
        spidRepository.deleteById(id);
    }
    public Spid changeSpidStatu(long id){
        Spid spid = spidRepository.getReferenceById(id);
        if(spid.getStatus() == Status.PENDING){
            spid.setStatus(Status.READY_FOR_REVIEW);
        }
        return spidRepository.save(spid);
    }
    public Spid approveSpid(long id){
        Spid spid = spidRepository.getReferenceById(id);
        if(spid.getStatus() == Status.READY_FOR_REVIEW){
            spid.setStatus(Status.APPROVED);
        }
        return spidRepository.save(spid);
    }

}




