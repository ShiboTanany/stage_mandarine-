package com.ntgclarity.mandarine.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QOrders is a Querydsl query type for Orders
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QOrders extends EntityPathBase<Orders> {

    private static final long serialVersionUID = -162257031L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOrders orders = new QOrders("orders");

    public final com.ntgclarity.mandarine.service.base.QBaseEntity _super = new com.ntgclarity.mandarine.service.base.QBaseEntity(this);

    public final StringPath address = createString("address");

    public final CollectionPath<AttributeValue, QAttributeValue> attributeValueCollection = this.<AttributeValue, QAttributeValue>createCollection("attributeValueCollection", AttributeValue.class, QAttributeValue.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final NumberPath<Integer> deleted = _super.deleted;

    public final StringPath email = createString("email");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath phone = createString("phone");

    public final NumberPath<Integer> quantity = createNumber("quantity", Integer.class);

    public final QService serviceid;

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath userName = createString("userName");

    public QOrders(String variable) {
        this(Orders.class, forVariable(variable), INITS);
    }

    public QOrders(Path<? extends Orders> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QOrders(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QOrders(PathMetadata<?> metadata, PathInits inits) {
        this(Orders.class, metadata, inits);
    }

    public QOrders(Class<? extends Orders> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.serviceid = inits.isInitialized("serviceid") ? new QService(forProperty("serviceid")) : null;
    }

}

