package com.tuhocgira.common.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tuhocgira.common.util.DateUtils;


import lombok.Data;



@Data

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false)
	protected Long id;

	@Version
	protected int version;
	@CreatedBy
	protected String createdBy;
	@CreatedDate
	@DateTimeFormat(pattern = DateUtils.DATE_FORMAT)
	@JsonFormat(shape  = JsonFormat.Shape.STRING,pattern = DateUtils.DATE_FORMAT)
	protected LocalDateTime createdAt;
	@LastModifiedBy
	protected String updateBy;
	@LastModifiedDate
	@DateTimeFormat(pattern = DateUtils.DATE_FORMAT)
	@JsonFormat(shape  = JsonFormat.Shape.STRING,pattern = DateUtils.DATE_FORMAT)
	protected LocalDateTime updateAt;
}