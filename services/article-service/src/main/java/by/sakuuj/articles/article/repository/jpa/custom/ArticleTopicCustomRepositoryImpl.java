package by.sakuuj.articles.article.repository.jpa.custom;

import by.sakuuj.articles.entity.jpa.embeddable.ArticleTopicId;
import by.sakuuj.articles.entity.jpa.entities.ArticleEntity;
import by.sakuuj.articles.entity.jpa.entities.ArticleTopicEntity;
import by.sakuuj.articles.entity.jpa.entities.TopicEntity;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ArticleTopicCustomRepositoryImpl implements ArticleTopicCustomRepository {

    private final EntityManager entityManager;

    @Override
    public ArticleTopicEntity save(ArticleTopicId articleTopicId) {

        ArticleEntity articleReference = entityManager.getReference(ArticleEntity.class, articleTopicId.getArticleId());
        TopicEntity topicReference = entityManager.getReference(TopicEntity.class, articleTopicId.getTopicId());

        ArticleTopicEntity articleTopicToPersist = ArticleTopicEntity.builder()
                .id(articleTopicId)
                .article(articleReference)
                .topic(topicReference)
                .build();

        entityManager.persist(articleTopicToPersist);

        return articleTopicToPersist;
    }
}
