package br.com.app.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.app.model.RoleModel;

public interface RoleRepository extends JpaRepository<RoleModel, UUID>{

}
