package com.ntgclarity.mandarine.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QServiceCategory is a Querydsl query type for ServiceCategory
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QServiceCategory extends EntityPathBase<ServiceCategory> {

    private static final long serialVersionUID = 293242047L;

    public static final QServiceCategory serviceCategory = new QServiceCategory("serviceCategory");

    public final com.ntgclarity.mandarine.service.base.QBaseEntity _super = new com.ntgclarity.mandarine.service.base.QBaseEntity(this);

    public final NumberPath<java.math.BigInteger> bandwidthCoverageApplicable = createNumber("bandwidthCoverageApplicable", java.math.BigInteger.class);

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final NumberPath<Integer> deleted = _super.deleted;

    public final NumberPath<java.math.BigInteger> fupApllicable = createNumber("fupApllicable", java.math.BigInteger.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath name = createString("name");

    public final StringPath serviceAcivationGlCode = createString("serviceAcivationGlCode");

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QServiceCategory(String variable) {
        super(ServiceCategory.class, forVariable(variable));
    }

    public QServiceCategory(Path<? extends ServiceCategory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QServiceCategory(PathMetadata<?> metadata) {
        super(ServiceCategory.class, metadata);
    }

}

