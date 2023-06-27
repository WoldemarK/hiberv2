package com.example.hiberv2.service;

import com.example.hiberv2.model.Details;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Service
@RequiredArgsConstructor
public class DetailsService {

    private final SessionFactory sessionFactory;

    @Transactional
    public void addingDetails(Details details) {
        log.info("The method {addingDetails}" + details);
        sessionFactory.getCurrentSession().save(details);
    }

    public Details findById(Integer idD) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Details.class,idD);
    }
}
