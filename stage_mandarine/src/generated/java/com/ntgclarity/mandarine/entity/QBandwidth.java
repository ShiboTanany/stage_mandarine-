package com.ntgclarity.mandarine.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QBandwidth is a Querydsl query type for Bandwidth
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QBandwidth extends EntityPathBase<Bandwidth> {

    private static final long serialVersionUID = 758956957L;

    public static final QBandwidth bandwidth = new QBandwidth("bandwidth");

    public final com.ntgclarity.mandarine.service.base.QBaseEntity _super = new com.ntgclarity.mandarine.service.base.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final NumberPath<Integer> deleted = _super.deleted;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath name = createString("name");

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final NumberPath<Long> value = createNumber("value", Long.class);

    public QBandwidth(String variable) {
        super(Bandwidth.class, forVariable(variable));
    }

    public QBandwidth(Path<? extends Bandwidth> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBandwidth(PathMetadata<?> metadata) {
        super(Bandwidth.class, metadata);
    }

}

