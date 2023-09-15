package org.acme.reproducer.app;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.acme.reproducer.app.entity.BaseClass;
import org.acme.reproducer.app.entity.SubClassA;
import org.acme.reproducer.app.entity.SubClassB;
import org.acme.reproducer.app.entity.SubClassC;
import org.acme.reproducer.app.repository.BaseClassRepository;

import io.quarkus.runtime.StartupEvent;

@ApplicationScoped
public class StartupBean {

    private final BaseClassRepository repository;

    @Inject
    public StartupBean(BaseClassRepository repository) {
        this.repository = repository;
    }

    @Transactional
    void onStart(@Observes StartupEvent ev) {

        SubClassA entity1 = new SubClassA();
        entity1.setSharedField(5.);
        entity1.setFieldA(5.);

        SubClassA entity2 = new SubClassA();
        entity2.setSharedField(6.);
        entity2.setFieldA(6.);

        SubClassB entity3 = new SubClassB();
        entity3.setSharedField(7.);
        entity3.setFieldB(7.);

        SubClassB entity4 = new SubClassB();
        entity4.setSharedField(8.);
        entity4.setFieldB(8.);

        SubClassC entity5 = new SubClassC();
        entity5.setSharedField(9.);
        entity5.setFieldC(9.);

        List<BaseClass> entities = List.of(
                entity1,
                entity2,
                entity3,
                entity4,
                entity5);

        repository.persist(entities);
    }
}
