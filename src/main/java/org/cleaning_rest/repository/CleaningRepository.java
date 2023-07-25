package org.cleaning_rest.repository;

import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;
import org.cleaning_rest.domain.entity.Cleaning;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CleaningRepository implements PanacheRepositoryBase<Cleaning, Long> {
}
