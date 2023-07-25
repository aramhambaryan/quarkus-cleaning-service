package org.cleaning_rest.controller;

import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;
import org.cleaning_rest.domain.dto.response.CleaningResponse;
import org.cleaning_rest.service.CleaningService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("cleanings")
@RequiredArgsConstructor
public class CleaningController {

    private final CleaningService cleaningService;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<List<CleaningResponse>> getPart(@QueryParam("part") Integer part) {
        return cleaningService.get(part)
                .invoke(() -> System.out.println("Received request from another service"));
    }
}
