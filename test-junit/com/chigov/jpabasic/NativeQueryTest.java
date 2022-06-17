package com.chigov.jpabasic;

import com.chigov.jpabasic.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaBasicApplication.class)
public class NativeQueryTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //want to test Course repository
    @Autowired
    EntityManager em;

    @Test
    public void nativeQueries() {
        Query query = em.createNativeQuery("select * from course",Course.class);
        List resultList = query.getResultList();
        logger.info("select * from course -> {}",resultList);
    }

    @Test
    public void nativeQueriesWithParameters() {
        Query query = em.createNativeQuery("select * from course where id = ?",Course.class);
        query.setParameter(1,1001L);
        List resultList = query.getResultList();
        logger.info("select * from course where id = ? -> {}",resultList);
    }

    @Test
    public void nativeQueriesWithNamedParameters() {
        Query query = em.createNativeQuery("select * from course where id = :id",Course.class);
        query.setParameter("id",1001L);
        List resultList = query.getResultList();
        logger.info("select * from course where id = :id -> {}",resultList);
    }

    @Test
    @Transactional
    public void nativeQueriesToUpdates() {
        Query query = em.createNativeQuery("update course set last_updated_date=now()",Course.class);
        int noOfRowsUpdated = query.executeUpdate();
        logger.info("Number of rows updated -> {}",noOfRowsUpdated);
    }

}