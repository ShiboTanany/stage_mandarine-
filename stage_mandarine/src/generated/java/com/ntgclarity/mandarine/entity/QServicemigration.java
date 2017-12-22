package com.ntgclarity.mandarine.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QServicemigration is a Querydsl query type for Servicemigration
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QServicemigration extends EntityPathBase<Servicemigration> {

    private static final long serialVersionUID = 373638221L;

    public static final QServicemigration servicemigration = new QServicemigration("servicemigration");

    public final com.ntgclarity.mandarine.service.base.QBaseEntity _super = new com.ntgclarity.mandarine.service.base.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final NumberPath<Integer> deleted = _super.deleted;

    public final NumberPath<java.math.BigInteger> fromserviceid = createNumber("fromserviceid", java.math.BigInteger.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final NumberPath<java.math.BigDecimal> recid = createNumber("recid", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigInteger> requestid = createNumber("requestid", java.math.BigInteger.class);

    public final NumberPath<java.math.BigInteger> serviceid = createNumber("serviceid", java.math.BigInteger.class);

    public final NumberPath<java.math.BigInteger> toserviceid = createNumber("toserviceid", java.math.BigInteger.class);

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QServicemigration(String variable) {
        super(Servicemigration.class, forVariable(variable));
    }

    public QServicemigration(Path<? extends Servicemigration> path) {
        super(path.getType(), path.getMetadata());
    }

    public QServicemigration(PathMetadata<?> metadata) {
        super(Servicemigration.class, metadata);
    }

}

