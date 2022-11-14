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



@Entity
@Table(name = "TB_CASE")
public class CaseModel{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_CASE")
	private Integer idCase;

	
	
	@Column(nullable = false, length = 200, name = "VALUE_CASE")
	private String value;
	@Column(nullable = false, name = "DATE_CASE")
	private LocalDateTime data;
	
	
//	@GeneratedValue(generator = "UUID")
//	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
//	@Column(name = "UUID", columnDefinition = "char(36)")
//	@Type(type = "org.hibernate.type.UUIDCharType")
//	private UUID uuid;

	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	public CaseModel(String value, LocalDateTime data) {
		super();
		this.value = value;
		this.data = data;
	}
	@Override
	public String toString() {
		return "CaseModel [caseId=" + idCase + ", value=" + value + ", data=" + data + "]";
	}

}
