package com.revature.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.revature.util.RegexUtil;

import lombok.Data;

@Entity
@Data
@Table(name="users")
public class User {

	@Id @Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotNull @NotBlank 
	@Length(min=3)
	@Column(nullable=false, unique=true)
	private String username;
	
	@Pattern(regexp=RegexUtil.PASSWORD_REGEX)
	@Column(nullable=false)
	private String password;
	
	@Column(name="register_datetime", updatable=false, columnDefinition="timestamp default CURRENT_TIMESTAMP")
	private LocalDateTime registerDateTime;
	
	@Enumerated(EnumType.STRING)
	private UserRole role;
}
