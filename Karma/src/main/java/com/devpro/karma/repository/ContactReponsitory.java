package com.devpro.karma.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devpro.karma.entities.Contacts;

@Repository
public interface ContactReponsitory extends JpaRepository<Contacts, Integer>{
	
	@Query("Select count(*) from Contacts where status = 0")
	Long countContactNoSee();
	
	@Query("select t from Contacts t where status = 0")
	List<Contacts> findContactByStatusNoSee();
	
	@Query("select t from Contacts t where t.id = ?1")
	Optional<Contacts> findContactByID(Integer id);
	
//	@Query("SELECT s FROM Contact s")
////	@Query("select * from Contact t limit 3")
//	List<Contact> findContactToPagion(int page);
	@Query("Select count(*) from Contacts")
	Integer countContact();
}
