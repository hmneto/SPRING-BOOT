package br.com.app.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.security.core.GrantedAuthority;

import br.com.app.enums.RoleName;

@Entity
@Table(name = "TB_ROLE")
public class RoleModel implements GrantedAuthority {
    private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "UUID_ROLE", columnDefinition = "char(36)")
	@Type(type = "org.hibernate.type.UUIDCharType")
    private UUID roleId;
	
	
	
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

    public UUID getRoleId() {
        return roleId;
    }

    public RoleName getRoleName() {
        return roleName;
    }

    public void setRoleId(UUID roleId) {
        this.roleId = roleId;
    }

    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }
}