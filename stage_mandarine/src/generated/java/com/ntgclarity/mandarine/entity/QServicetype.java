package com.ntgclarity.mandarine.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QServicetype is a Querydsl query type for Servicetype
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QServicetype extends EntityPathBase<Servicetype> {

    private static final long serialVersionUID = 898689883L;

    public static final QServicetype servicetype = new QServicetype("servicetype");

    public final com.ntgclarity.mandarine.service.base.QBaseEntity _super = new com.ntgclarity.mandarine.service.base.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final NumberPath<Integer> deleted = _super.deleted;

    public final StringPath describtion = createString("describtion");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath serviceType = createString("serviceType");

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QServicetype(String variable) {
        super(Servicetype.class, forVariable(variable));
    }

    public QServicetype(Path<? extends Servicetype> path) {
        super(path.getType(), path.getMetadata());
    }

    public QServicetype(PathMetadata<?> metadata) {
        super(Servicetype.class, metadata);
    }

}

