package com.demo.library.app.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @CreatedDate
    private LocalDateTime regDtm;

    @LastModifiedDate
    private LocalDateTime modDtm;

    protected BaseEntity(LocalDateTime regDtm){
        this.regDtm = regDtm;
    }
    protected BaseEntity(Long id, LocalDateTime regDtm){
        this.id = id;
        this.regDtm = regDtm;
    }
}
