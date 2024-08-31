package by.sakuuj.blogsite.article.mapper.elasticsearch;

import by.sakuuj.blogsite.article.entity.elasticsearch.ArticleDocument;
import by.sakuuj.blogsite.article.entity.jpa.entities.ArticleEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface ArticleDocumentMapper {

    @Mappings({
            @Mapping(target = "datePublishedOn", source = "entity.modificationAudit.createdAt"),
    })
    ArticleDocument toDocument(ArticleEntity entity);
}
