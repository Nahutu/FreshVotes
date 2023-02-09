package ht.nahum.freshvotes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ht.nahum.freshvotes.domain.Product;
import ht.nahum.freshvotes.domain.User;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	List<Product> findByUser(User user);
	

}
