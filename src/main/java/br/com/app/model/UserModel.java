package br.com.app.model;

import java.util.Collection;
import java.util.List;
// import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.transaction.Transactional;

// import org.hibernate.annotations.GenericGenerator;
// import org.hibernate.annotations.Type;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Transactional
@Entity
@Table(name="TB_USER")
public class UserModel implements UserDetails {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_USER")
    private Integer idUser;



	@Column(name = "USER", nullable = false, length = 200, unique = true)
	private String username;
	
	@Column(name = "PASSWORD", nullable = false, length = 200)
	private String password;
	
//	
//	@GeneratedValue(generator = "UUID")
//	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
//	@Column(name = "UUID", columnDefinition = "char(36)")
//	@Type(type = "org.hibernate.type.UUIDCharType")
//	private UUID uuid;

	
	public UserModel() {
        super();
    }


    public UserModel(String username, String password, List<RoleModel> roles) {
        super();
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    @ManyToMany
    @JoinTable(name = "TB_USERS_ROLES",
            joinColumns = @JoinColumn(name = "ID_USER"),
            inverseJoinColumns = @JoinColumn(name = "ID_ROLE"))
    private List<RoleModel> roles;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.roles;
	}


	@Override
	public String getPassword() {
		return this.password;
	}


	@Override
	public String getUsername() {
		return this.username;
	}


	@Override
	public boolean isAccountNonExpired() {
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}


	@Override
	public boolean isEnabled() {
		return true;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setUsername(String userName) {
		this.username = userName;
	}


}
