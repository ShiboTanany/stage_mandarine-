package com.ntgclarity.mandarine.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QAttributeValuePK is a Querydsl query type for AttributeValuePK
 */
@Generated("com.mysema.query.codegen.EmbeddableSerializer")
public class QAttributeValuePK extends BeanPath<AttributeValuePK> {

    private static final long serialVersionUID = 99230852L;

    public static final QAttributeValuePK attributeValuePK = new QAttributeValuePK("attributeValuePK");

    public final NumberPath<java.math.BigInteger> attributeId = createNumber("attributeId", java.math.BigInteger.class);

    public final NumberPath<java.math.BigInteger> orderId = createNumber("orderId", java.math.BigInteger.class);

    public final NumberPath<java.math.BigInteger> serviceId = createNumber("serviceId", java.math.BigInteger.class);

    public QAttributeValuePK(String variable) {
        super(AttributeValuePK.class, forVariable(variable));
    }

    public QAttributeValuePK(Path<? extends AttributeValuePK> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAttributeValuePK(PathMetadata<?> metadata) {
        super(AttributeValuePK.class, metadata);
    }

}

