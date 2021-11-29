package com.demo.library.app.domain.querydsl;

import com.demo.library.app.domain.Book;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;

import javax.annotation.processing.Generated;

import java.time.LocalDateTime;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;

@Generated("com.querydsl.codegen.EntitySerializer")
public class QBook extends EntityPathBase<Book> {
    private static final long serialVersionUID = -1424365737L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBook book = new QBook("book");

    public final QBaseEntity _super = new QBaseEntity(this);

    private final DateTimePath<LocalDateTime> createAt = _super.createdAt;

    public final NumberPath<Long> id = _super.id;

    public final DateTimePath<LocalDateTime> updatedAt = _super.updatedAt;

    public final StringPath name = createString("name");
    public final StringPath author = createString("author");
    public final StringPath publisher = createString("publisher");
    public final NumberPath<Integer> floor = createNumber("floor",Integer.class);
    public final NumberPath<Integer> gimmick = createNumber("gimmick",Integer.class);

    public final QCategory category;

    public QBook(String variable){
        this(Book.class, forVariable(variable), INITS);
    }
    public QBook(Path<? extends Book> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBook(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBook(PathMetadata metadata, PathInits inits) {
        this(Book.class, metadata, inits);
    }

    public QBook(Class<? extends Book> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.category = inits.isInitialized("category")
                ? new QCategory(forProperty("category"), inits.get("category")):null;
    }
}
