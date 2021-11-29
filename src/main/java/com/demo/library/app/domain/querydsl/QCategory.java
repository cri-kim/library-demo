package com.demo.library.app.domain.querydsl;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.demo.library.app.domain.Category;
import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import java.time.LocalDateTime;

@Generated("com.querydsl.codegen.EntitySerializer")
public class QCategory extends EntityPathBase<QCategory> {
    private static final long serialVersionUID = 968584273L;

    public static final QCategory category = new QCategory("category");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final DateTimePath<LocalDateTime> createAt = _super.createdAt;

    public final NumberPath<Long> id = _super.id;
    public final StringPath name = createString("name");

    public final DateTimePath<LocalDateTime> updatedAt = _super.updatedAt;

    public QCategory(String variable){
        super(Category.class, forVariable(variable));
    }
    public QCategory(Path<? extends Category> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCategory(PathMetadata metadata) {
        super(Category.class, metadata);
    }
}
