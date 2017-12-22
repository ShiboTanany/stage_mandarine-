package com.ntgclarity.mandarine.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QSellingType is a Querydsl query type for SellingType
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QSellingType extends EntityPathBase<SellingType> {

    private static final long serialVersionUID = -1073905002L;

    public static final QSellingType sellingType = new QSellingType("sellingType");

    public final com.ntgclarity.mandarine.service.base.QBaseEntity _super = new com.ntgclarity.mandarine.service.base.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final NumberPath<Integer> deleted = _super.deleted;

    public final NumberPath<java.math.BigInteger> hideInDropDown = createNumber("hideInDropDown", java.math.BigInteger.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath type = createString("type");

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QSellingType(String variable) {
        super(SellingType.class, forVariable(variable));
    }

    public QSellingType(Path<? extends SellingType> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSellingType(PathMetadata<?> metadata) {
        super(SellingType.class, metadata);
    }

}

