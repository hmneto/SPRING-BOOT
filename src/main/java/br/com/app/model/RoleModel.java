package br.com.app.model;

import java.util.UUID;

// import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
//  import org.hibernate.annotations.GenericGenerator;
//  import org.hibernate.annotations.Type;
import org.springframework.security.core.GrantedAuthority;

import br.com.app.enums.RoleName;

@Entity
@Table(name = "TB_ROLE")
public class RoleModel implements GrantedAuthority {
    private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_ROLE")
    private Integer idRole;
	
	
	
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "UUID", columnDefinition = "char(36)")
	@Type(type = "org.hibernate.type.UUIDCharType")
	private UUID uuid;
	
    public RoleModel() {
        super();
    }

    public RoleModel(RoleName roleName) {
        super();
        this.roleName = roleName;
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private RoleName roleName;
   
    @Override
    public String getAuthority() {
        return this.roleName.toString();
    }

    public Integer getRoleId() {
        return idRole;
    }

    public RoleName getRoleName() {
        return roleName;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }
}