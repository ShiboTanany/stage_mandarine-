package com.ntgclarity.mandarine.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QCancelationReason is a Querydsl query type for CancelationReason
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QCancelationReason extends EntityPathBase<CancelationReason> {

    private static final long serialVersionUID = 758982091L;

    public static final QCancelationReason cancelationReason = new QCancelationReason("cancelationReason");

    public final com.ntgclarity.mandarine.service.base.QBaseEntity _super = new com.ntgclarity.mandarine.service.base.QBaseEntity(this);

    public final StringPath cancelreason = createString("cancelreason");

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final NumberPath<Integer> deleted = _super.deleted;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final NumberPath<Short> iscustomerrequest = createNumber("iscustomerrequest", Short.class);

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QCancelationReason(String variable) {
        super(CancelationReason.class, forVariable(variable));
    }

    public QCancelationReason(Path<? extends CancelationReason> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCancelationReason(PathMetadata<?> metadata) {
        super(CancelationReason.class, metadata);
    }

}

