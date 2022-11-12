package br.com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.app.model.CaseModel;
import br.com.app.service.CaseService;

public interface CaseRepository extends JpaRepository<CaseModel, Integer> {

	Optional<CaseModel> findByValue(String string);

}
