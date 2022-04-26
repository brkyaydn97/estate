package com.example.emlak.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.emlak.entity.Emlak;
import com.example.emlak.entity.Emlakci;

public interface EmlakciRepo  extends JpaRepository<Emlakci, Long> {

}
