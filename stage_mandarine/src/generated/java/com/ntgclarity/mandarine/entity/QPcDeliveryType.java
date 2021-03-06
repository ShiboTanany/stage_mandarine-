package com.ntgclarity.mandarine.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPcDeliveryType is a Querydsl query type for PcDeliveryType
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPcDeliveryType extends EntityPathBase<PcDeliveryType> {

    private static final long serialVersionUID = -618265739L;

    public static final QPcDeliveryType pcDeliveryType = new QPcDeliveryType("pcDeliveryType");

    public final com.ntgclarity.mandarine.service.base.QBaseEntity _super = new com.ntgclarity.mandarine.service.base.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final NumberPath<Integer> deleted = _super.deleted;

    public final StringPath description = createString("description");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath name = createString("name");

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QPcDeliveryType(String variable) {
        super(PcDeliveryType.class, forVariable(variable));
    }

    public QPcDeliveryType(Path<? extends PcDeliveryType> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPcDeliveryType(PathMetadata<?> metadata) {
        super(PcDeliveryType.class, metadata);
    }

}

