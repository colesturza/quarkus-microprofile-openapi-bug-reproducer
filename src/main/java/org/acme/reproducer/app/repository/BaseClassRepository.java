package org.acme.reproducer.app.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.acme.reproducer.app.entity.BaseClass;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;

@ApplicationScoped
public class BaseClassRepository implements PanacheRepository<BaseClass> {

    public List<BaseClass> listByType(int type) {
        return list("clazz_", Sort.ascending("id"), type);
    }
}
