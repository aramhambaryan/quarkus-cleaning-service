package org.cleaning_rest.service;

import io.smallrye.mutiny.Uni;
import org.cleaning_rest.domain.dto.response.CleaningResponse;

import java.util.List;

public interface CleaningService {

    Uni<List<CleaningResponse>> get(Integer part);
}
