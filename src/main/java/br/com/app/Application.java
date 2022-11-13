package br.com.app;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
// import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.SpringVersion;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.app.enums.RoleName;
import br.com.app.model.RoleModel;
import br.com.app.model.UserModel;
import br.com.app.repository.RoleRepository;
import br.com.app.repository.UserRepository;

@SpringBootApplication 
@EntityScan(basePackages = { "br.com.app.model" })
@EnableJpaRepositories(basePackages = { "br.com.app.repository" })
//@ComponentScan(basePackages={"br.com.app.controller"})

@Component
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("123"));
		System.out.println("Spring Core Version:- " + SpringVersion.getVersion());
	}

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserRepository usuarioRepository;

	@Transactional
	@GetMapping("/")
	public ResponseEntity<String> Index() {
		String senha = "$2a$10$xQKue46QQjssCHNZMUWCw.JpOwocN733j8Gr7txYDD5zhfGune/S.";
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
	    final HttpHeaders httpHeaders= new HttpHeaders();
	    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
	    return new ResponseEntity<String>("{\"test\": \"Index\"}", httpHeaders, HttpStatus.OK);
	}
}



