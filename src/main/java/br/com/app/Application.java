package br.com.app;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.SpringVersion;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.app.enums.RoleName;
import br.com.app.model.RoleModel;
import br.com.app.model.UserModel;
import br.com.app.repository.RoleRepository;
import br.com.app.repository.UserRepository;

@SpringBootApplication
@EntityScan(basePackages = { "br.com.app.model" })
@EnableJpaRepositories(basePackages = { "br.com.app.repository" })
@ComponentScan(basePackages={"br.com.app.controller"})

@Component
@RestController
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("senha123"));
		System.out.println("Spring Core Version:- " + SpringVersion.getVersion());
		// springApplication.run(args);
	}

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserRepository usuarioRepository;

	@Transactional
	@GetMapping("/")
	public String Index() {
		String senha = "$2a$10$DmQDpUUFEubvLxk2hmC4K.g3HRqtI4lH3ZGFuUAN0g4n.oRK072n2";
		RoleModel roleAdmin = new RoleModel(RoleName.ROLE_ADMIN);
		roleRepository.save(roleAdmin);

		RoleModel roleUser = new RoleModel(RoleName.ROLE_USER);
		roleRepository.save(roleUser);

		List<RoleModel> rolesAdmin = new ArrayList<RoleModel>();
		rolesAdmin.add(roleAdmin);

		UserModel Admin = new UserModel("admin", senha, rolesAdmin);
		usuarioRepository.save(Admin);

		List<RoleModel> rolesUser = new ArrayList<RoleModel>();
		rolesUser.add(roleUser);

		UserModel User = new UserModel("user", senha, rolesUser);
		usuarioRepository.save(User);

		return "index";
	}
}
