package br.com.app.model;

import java.time.LocalDateTime;
// import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// import org.hibernate.annotations.GenericGenerator;
// import org.hibernate.annotations.Type;

import lombok.Data;

@Data
@Entity
@Table(name = "TB_EMAIL")
public class EmailModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID_EMAIL")
    private Integer idEmail;
    private String ownerRef;
    private String emailFrom;
    private String emailTo;
    private String subject;
    @Column(columnDefinition = "TEXT")
    private String text;
    private LocalDateTime sendDateEmail;
    //private StatusEmail statusEmail;
    
    
//	@GeneratedValue(generator = "UUID")
//	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
//	@Column(name = "UUID", columnDefinition = "char(36)")
//	@Type(type = "org.hibernate.type.UUIDCharType")
//	private UUID uuid;
}