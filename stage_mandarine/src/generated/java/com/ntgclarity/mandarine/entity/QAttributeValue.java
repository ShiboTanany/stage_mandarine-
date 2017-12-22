package com.ntgclarity.mandarine.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QAttributeValue is a Querydsl query type for AttributeValue
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QAttributeValue extends EntityPathBase<AttributeValue> {

    private static final long serialVersionUID = 630270153L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAttributeValue attributeValue = new QAttributeValue("attributeValue");

    public final com.ntgclarity.mandarine.service.base.QBaseEntity _super = new com.ntgclarity.mandarine.service.base.QBaseEntity(this);

    public final QAttribute attributeId;

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final NumberPath<Integer> deleted = _super.deleted;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final QOrders orderId;

    public final QService serviceId;

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath value = createString("value");

    public QAttributeValue(String variable) {
        this(AttributeValue.class, forVariable(variable), INITS);
    }

    public QAttributeValue(Path<? extends AttributeValue> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QAttributeValue(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QAttributeValue(PathMetadata<?> metadata, PathInits inits) {
        this(AttributeValue.class, metadata, inits);
    }

    public QAttributeValue(Class<? extends AttributeValue> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.attributeId = inits.isInitialized("attributeId") ? new QAttribute(forProperty("attributeId"), inits.get("attributeId")) : null;
        this.orderId = inits.isInitialized("orderId") ? new QOrders(forProperty("orderId"), inits.get("orderId")) : null;
        this.serviceId = inits.isInitialized("serviceId") ? new QService(forProperty("serviceId")) : null;
    }

}

