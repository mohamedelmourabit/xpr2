package com.xpr.dao.helper;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.io.Serializable;

public class CustomJPARepositoryImpl<T, ID extends Serializable>
        extends SimpleJpaRepository<T, ID> implements CustomJPARepository<T, ID> {

    private final EntityManager entityManager;

    public CustomJPARepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    @Transactional
    public void refresh(T t) {
        this.entityManager.refresh(t);
    }
}
