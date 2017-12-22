package com.ntgclarity.mandarine.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QService is a Querydsl query type for Service
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QService extends EntityPathBase<Service> {

    private static final long serialVersionUID = -1838705503L;

    public static final QService service = new QService("service");

    public final com.ntgclarity.mandarine.service.base.QBaseEntity _super = new com.ntgclarity.mandarine.service.base.QBaseEntity(this);

    public final CollectionPath<Attribute, QAttribute> attributeCollection = this.<Attribute, QAttribute>createCollection("attributeCollection", Attribute.class, QAttribute.class, PathInits.DIRECT2);

    public final CollectionPath<AttributeValue, QAttributeValue> attributeValueCollection = this.<AttributeValue, QAttributeValue>createCollection("attributeValueCollection", AttributeValue.class, QAttributeValue.class, PathInits.DIRECT2);

    public final CollectionPath<AttributeValueList, QAttributeValueList> attributeValueListCollection = this.<AttributeValueList, QAttributeValueList>createCollection("attributeValueListCollection", AttributeValueList.class, QAttributeValueList.class, PathInits.DIRECT2);

    public final CollectionPath<Component, QComponent> componentCollection = this.<Component, QComponent>createCollection("componentCollection", Component.class, QComponent.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final DateTimePath<java.util.Date> dateCreated = createDateTime("dateCreated", java.util.Date.class);

    //inherited
    public final NumberPath<Integer> deleted = _super.deleted;

    public final NumberPath<java.math.BigInteger> deliveryDays = createNumber("deliveryDays", java.math.BigInteger.class);

    public final NumberPath<java.math.BigInteger> deliveryFees = createNumber("deliveryFees", java.math.BigInteger.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final NumberPath<java.math.BigInteger> isactive = createNumber("isactive", java.math.BigInteger.class);

    public final StringPath name = createString("name");

    public final CollectionPath<Orders, QOrders> ordersCollection = this.<Orders, QOrders>createCollection("ordersCollection", Orders.class, QOrders.class, PathInits.DIRECT2);

    public final NumberPath<java.math.BigInteger> suspensionFees = createNumber("suspensionFees", java.math.BigInteger.class);

    public final NumberPath<java.math.BigInteger> terminationFees = createNumber("terminationFees", java.math.BigInteger.class);

    public final StringPath type = createString("type");

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QService(String variable) {
        super(Service.class, forVariable(variable));
    }

    public QService(Path<? extends Service> path) {
        super(path.getType(), path.getMetadata());
    }

    public QService(PathMetadata<?> metadata) {
        super(Service.class, metadata);
    }

}

