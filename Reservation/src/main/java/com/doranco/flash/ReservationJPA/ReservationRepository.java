package com.doranco.flash.ReservationJPA;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Hotel,Long>
{

	List<Hotel> findByNuiteLessThan(double prix);
	
}
