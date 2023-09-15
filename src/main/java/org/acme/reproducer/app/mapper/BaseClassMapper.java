package org.acme.reproducer.app.mapper;

import org.acme.reproducer.api.BaseClassDto;
import org.acme.reproducer.api.SubClassADto;
import org.acme.reproducer.api.SubClassBDto;
import org.acme.reproducer.api.SubClassCDto;
import org.acme.reproducer.app.entity.BaseClass;
import org.acme.reproducer.app.entity.SubClassA;
import org.acme.reproducer.app.entity.SubClassB;
import org.acme.reproducer.app.entity.SubClassC;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.SubclassExhaustiveStrategy;
import org.mapstruct.SubclassMapping;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI, subclassExhaustiveStrategy = SubclassExhaustiveStrategy.RUNTIME_EXCEPTION)
public interface BaseClassMapper {

    @SubclassMapping(source = SubClassA.class, target = SubClassADto.class)
    @SubclassMapping(source = SubClassB.class, target = SubClassBDto.class)
    @SubclassMapping(source = SubClassC.class, target = SubClassCDto.class)
    BaseClassDto toDto(BaseClass entity);
}
