package com.example.demo.Repository;

import com.example.demo.entities.Spid;
import com.example.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping
public interface SpidRespository extends JpaRepository<Spid, Long> {
    List<Spid> findSpidByUserId(User user);

}
