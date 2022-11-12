package br.com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.app.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer>{
	Optional<UserModel> findByUsername(String username);
}
