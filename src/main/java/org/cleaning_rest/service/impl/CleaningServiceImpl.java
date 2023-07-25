package org.cleaning_rest.service.impl;

import io.quarkus.panache.common.Sort;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;
import org.cleaning_rest.domain.dto.response.CleaningResponse;
import org.cleaning_rest.repository.CleaningRepository;
import org.cleaning_rest.service.CleaningService;
import org.cleaning_rest.service.mapper.CleaningMapper;

import javax.enterprise.context.ApplicationScoped;
import java.time.Duration;
import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
public class CleaningServiceImpl implements CleaningService {

    private final CleaningRepository cleaningRepository;
    private final CleaningMapper cleaningMapper;


    @Override
    public Uni<List<CleaningResponse>> get(Integer part) {
        if (part == null) {
            return cleaningRepository.listAll().map(cleaningMapper::toDtoList);
        } else {
            return getPart(part);
        }
    }

    public Uni<List<CleaningResponse>> getPart(int partNumber) {
        switch (partNumber) {
            case 1:
                return getCleanings(0, 2);
            case 2:
                return getCleanings(3, 6);
            case 3:
                return getCleanings(7, 9);
            default:
                throw new IllegalArgumentException();
        }
    }

    private Uni<List<CleaningResponse>> getCleanings(int startIndex, int lastIndex) {
        return cleaningRepository
                .findAll(Sort.by("roomNumber"))
                .range(startIndex, lastIndex)
                .list()
                .map(cleaningMapper::toDtoList);
                // добавляю задержку в 5 секунд, имитируем сложные калькуляции при каждом запросе
                //.onItem()
                //.delayIt()
                //.by(Duration.ofSeconds(1));
    }
}
