package com.cancino.sistemaalmacenspring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="usuarios")
@EntityListeners(AuditingEntityListener.class)

public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private Integer id;
	
	@Column(name="nombre",nullable=false,length=50)
	private String nombre;
	
	@Column(name="email",nullable=false,length=100)
	private String email;
	
	@Column(name="password",nullable=false,length=64)
	private String password;
	
	@Column(name="created_at",nullable=false,updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;
	
	@Column(name="updated_at")
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;
	
	@ManyToOne()
	@JoinColumn(name="rol_id")
	private Rol rol;  
}
