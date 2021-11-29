package com.demo.library.app.domain.querydsl;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.demo.library.app.domain.Book;
import com.demo.library.app.domain.Category;
import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import java.time.LocalDateTime;

@Generated("com.querydsl.codegen.EntitySerializer")
public class QCategory extends EntityPathBase<Category> {
    private static final long serialVersionUID = 968584273L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCategory category = new QCategory("category");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final DateTimePath<LocalDateTime> createAt = _super.createdAt;

    public final NumberPath<Long> id = _super.id;
    public final StringPath name = createString("name");

    public final DateTimePath<LocalDateTime> updatedAt = _super.updatedAt;

    public final QBook book;

    public QCategory(String variable){
        this(Category.class, forVariable(variable),INITS);
    }
    public QCategory(Path<? extends Category> path) {
        this(path.getType(), path.getMetadata(),PathInits.getFor(path.getMetadata(),INITS));
    }

    public QCategory(PathMetadata metadata) {
        this(Category.class, metadata, PathInits.getFor(metadata,INITS));
    }

    public QCategory(PathMetadata metadata, PathInits inits) {
        this(Category.class, metadata, inits);
    }

    public QCategory(Class<? extends Category> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.book = inits.isInitialized("book")
                ? new QBook(forProperty("book"), inits.get("book")):null;
    }
}
