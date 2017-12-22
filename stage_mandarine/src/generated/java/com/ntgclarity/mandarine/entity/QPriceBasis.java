package com.ntgclarity.mandarine.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPriceBasis is a Querydsl query type for PriceBasis
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPriceBasis extends EntityPathBase<PriceBasis> {

    private static final long serialVersionUID = 1371599625L;

    public static final QPriceBasis priceBasis = new QPriceBasis("priceBasis");

    public final com.ntgclarity.mandarine.service.base.QBaseEntity _super = new com.ntgclarity.mandarine.service.base.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final NumberPath<Integer> deleted = _super.deleted;

    public final StringPath describtion = createString("describtion");

    public final NumberPath<Short> freedaysonce = createNumber("freedaysonce", Short.class);

    public final StringPath freedaysservicebill = createString("freedaysservicebill");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath name = createString("name");

    public final NumberPath<Short> numberofmonths = createNumber("numberofmonths", Short.class);

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QPriceBasis(String variable) {
        super(PriceBasis.class, forVariable(variable));
    }

    public QPriceBasis(Path<? extends PriceBasis> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPriceBasis(PathMetadata<?> metadata) {
        super(PriceBasis.class, metadata);
    }

}

