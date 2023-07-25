package org.cleaning_rest.controller;

import io.quarkus.oidc.UserInfo;
import io.quarkus.security.identity.SecurityIdentity;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.jwt.JsonWebToken;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RequiredArgsConstructor
@Path("test")
public class RolesTestController {

    private final SecurityIdentity identity;
    private final UserInfo userInfo;
    private final JsonWebToken jwt;

    @GET
    @Path("/user")
    @RolesAllowed("user")
    @Produces(MediaType.TEXT_PLAIN)
    public String onlyUser() {
        return "onlyUserHere \n" +
                identity.getPrincipal().getName() + "\n" +
                userInfo.getAllProperties() + "\n" +
                jwt;
    }

    @GET
    @Path("/admin")
    @RolesAllowed("admin")
    @Produces(MediaType.TEXT_PLAIN)
    public String onlyAdmin() {
        return "onlyAdminHere \n" +
                identity.getPrincipal().getName() + "\n" +
                userInfo.getAllProperties() + "\n" +
                jwt;
    }

    @GET
    @Path("/anyone")
    @Produces(MediaType.TEXT_PLAIN)
    public String anyOne() {
        return "anyOneHere";
    }
}
