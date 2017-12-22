package com.ntgclarity.mandarine.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QModifyreason is a Querydsl query type for Modifyreason
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QModifyreason extends EntityPathBase<Modifyreason> {

    private static final long serialVersionUID = -1521869550L;

    public static final QModifyreason modifyreason1 = new QModifyreason("modifyreason1");

    public final com.ntgclarity.mandarine.service.base.QBaseEntity _super = new com.ntgclarity.mandarine.service.base.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final NumberPath<Integer> deleted = _super.deleted;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath modifyreason = createString("modifyreason");

    public final NumberPath<java.math.BigDecimal> recid = createNumber("recid", java.math.BigDecimal.class);

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QModifyreason(String variable) {
        super(Modifyreason.class, forVariable(variable));
    }

    public QModifyreason(Path<? extends Modifyreason> path) {
        super(path.getType(), path.getMetadata());
    }

    public QModifyreason(PathMetadata<?> metadata) {
        super(Modifyreason.class, metadata);
    }

}

