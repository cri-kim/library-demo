package com.demo.library.app.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class BaseEntity {

    protected Long id;

    private LocalDateTime regDtm;

    private LocalDateTime modDtm;

    protected BaseEntity(LocalDateTime regDtm){
        this.regDtm = regDtm;
    }
    protected BaseEntity(Long id, LocalDateTime regDtm){
        this.id = id;
        this.regDtm = regDtm;
    }
}
