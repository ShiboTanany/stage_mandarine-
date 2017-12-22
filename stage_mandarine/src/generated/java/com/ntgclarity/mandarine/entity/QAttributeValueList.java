package com.ntgclarity.mandarine.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QAttributeValueList is a Querydsl query type for AttributeValueList
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QAttributeValueList extends EntityPathBase<AttributeValueList> {

    private static final long serialVersionUID = 871481607L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAttributeValueList attributeValueList = new QAttributeValueList("attributeValueList");

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

    public final QService serviceid;

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath value = createString("value");

    public QAttributeValueList(String variable) {
        this(AttributeValueList.class, forVariable(variable), INITS);
    }

    public QAttributeValueList(Path<? extends AttributeValueList> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QAttributeValueList(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QAttributeValueList(PathMetadata<?> metadata, PathInits inits) {
        this(AttributeValueList.class, metadata, inits);
    }

    public QAttributeValueList(Class<? extends AttributeValueList> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.attributeId = inits.isInitialized("attributeId") ? new QAttribute(forProperty("attributeId"), inits.get("attributeId")) : null;
        this.serviceid = inits.isInitialized("serviceid") ? new QService(forProperty("serviceid")) : null;
    }

}

