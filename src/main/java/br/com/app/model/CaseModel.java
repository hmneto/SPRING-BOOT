package br.com.app.model;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "TB_CASE")
public class CaseModel {
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "ID_CASE", columnDefinition = "char(36)")
	@Type(type = "org.hibernate.type.UUIDCharType")
	private UUID caseId;
	@Column(nullable = false, length = 200, name = "VALUE_CASE")
	private String value;
	@Column(nullable = false, name = "DATE_CASE")
	private LocalDateTime data;
	public CaseModel() {
	}
	public CaseModel(UUID id, String value, LocalDateTime data) {
		this.caseId = id;
		this.value = value;
		this.data = data;
	}
	public UUID getCaseId() {
		return caseId;
	}
	public void setCaseId(UUID caseId) {
		this.caseId = caseId;
	}
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

	@Override
	public String toString() {
		return "Case [id=" + caseId + ", value=" + value + ", data=" + data + "]";
	}
}