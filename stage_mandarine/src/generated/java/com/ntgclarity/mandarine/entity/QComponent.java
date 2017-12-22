package com.ntgclarity.mandarine.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QComponent is a Querydsl query type for Component
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QComponent extends EntityPathBase<Component> {

    private static final long serialVersionUID = 1324818409L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QComponent component = new QComponent("component");

    public final com.ntgclarity.mandarine.service.base.QBaseEntity _super = new com.ntgclarity.mandarine.service.base.QBaseEntity(this);

    public final QCategory categoryId;

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final NumberPath<Integer> deleted = _super.deleted;

    public final StringPath description = createString("description");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final NumberPath<java.math.BigInteger> mrc = createNumber("mrc", java.math.BigInteger.class);

    public final StringPath name = createString("name");

    public final NumberPath<java.math.BigInteger> nrc = createNumber("nrc", java.math.BigInteger.class);

    public final CollectionPath<Service, QService> serviceCollection = this.<Service, QService>createCollection("serviceCollection", Service.class, QService.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QComponent(String variable) {
        this(Component.class, forVariable(variable), INITS);
    }

    public QComponent(Path<? extends Component> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QComponent(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QComponent(PathMetadata<?> metadata, PathInits inits) {
        this(Component.class, metadata, inits);
    }

    public QComponent(Class<? extends Component> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.categoryId = inits.isInitialized("categoryId") ? new QCategory(forProperty("categoryId"), inits.get("categoryId")) : null;
    }

}

