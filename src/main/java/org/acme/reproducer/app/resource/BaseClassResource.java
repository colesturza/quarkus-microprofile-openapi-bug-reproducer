package org.acme.reproducer.app.resource;

import java.util.List;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.acme.reproducer.api.BaseClassDto;
import org.acme.reproducer.api.SubClassADto;
import org.acme.reproducer.api.SubClassBDto;
import org.acme.reproducer.api.SubClassCDto;
import org.acme.reproducer.app.mapper.BaseClassMapper;
import org.acme.reproducer.app.repository.BaseClassRepository;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.jboss.resteasy.reactive.RestPath;

import io.quarkus.panache.common.Sort;

@Path("/base-class")
public class BaseClassResource {

    private final BaseClassRepository repository;
    private final BaseClassMapper mapper;

    @Inject
    public BaseClassResource(BaseClassRepository repository, BaseClassMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @GET
    @Path("/all")
    @APIResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(type = SchemaType.ARRAY, anyOf = {
            SubClassADto.class, SubClassBDto.class, SubClassCDto.class })))
    public List<BaseClassDto> list() {
        return repository.listAll(Sort.ascending("id")).stream().map(mapper::toDto).toList();
    }

    @GET
    @Path("/all-by-type/{type}")
    @APIResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(type = SchemaType.ARRAY, oneOf = {
            SubClassADto.class, SubClassBDto.class, SubClassCDto.class })))
    public List<BaseClassDto> listByType(@RestPath @NotNull @Positive Integer type) {
        return repository.listByType(type).stream().map(mapper::toDto).toList();
    }
}
