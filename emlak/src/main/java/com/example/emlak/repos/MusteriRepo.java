package com.example.emlak.repos;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.emlak.entity.Musteri;

public interface MusteriRepo  extends JpaRepository<Musteri, Long> {

}
