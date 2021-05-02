package com.xpr.dao.helper;


import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.io.Serializable;

@NoRepositoryBean
public interface CustomJPARepository<T, ID extends Serializable> extends JpaSpecificationExecutor<T>, PagingAndSortingRepository<T, ID>  {

    /**
     * This function is used to refresh an updated or newly created entity
     * @param T
     */
    @Transactional
    void refresh(T t);

    EntityManager getEntityManager();
}