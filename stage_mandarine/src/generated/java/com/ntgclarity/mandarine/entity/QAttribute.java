package com.ntgclarity.mandarine.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QAttribute is a Querydsl query type for Attribute
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QAttribute extends EntityPathBase<Attribute> {

    private static final long serialVersionUID = -1557156472L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAttribute attribute = new QAttribute("attribute");

    public final com.ntgclarity.mandarine.service.base.QBaseEntity _super = new com.ntgclarity.mandarine.service.base.QBaseEntity(this);

    public final CollectionPath<AttributeValue, QAttributeValue> attributeValueCollection = this.<AttributeValue, QAttributeValue>createCollection("attributeValueCollection", AttributeValue.class, QAttributeValue.class, PathInits.DIRECT2);

    public final CollectionPath<AttributeValueList, QAttributeValueList> attributeValueListCollection = this.<AttributeValueList, QAttributeValueList>createCollection("attributeValueListCollection", AttributeValueList.class, QAttributeValueList.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final NumberPath<Integer> deleted = _super.deleted;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final NumberPath<java.math.BigInteger> mandatory = createNumber("mandatory", java.math.BigInteger.class);

    public final StringPath name = createString("name");

    public final QService serviceId;

    public final NumberPath<java.math.BigInteger> sort = createNumber("sort", java.math.BigInteger.class);

    public final StringPath type = createString("type");

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QAttribute(String variable) {
        this(Attribute.class, forVariable(variable), INITS);
    }

    public QAttribute(Path<? extends Attribute> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QAttribute(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QAttribute(PathMetadata<?> metadata, PathInits inits) {
        this(Attribute.class, metadata, inits);
    }

    public QAttribute(Class<? extends Attribute> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.serviceId = inits.isInitialized("serviceId") ? new QService(forProperty("serviceId")) : null;
    }

}

