package com.ntgclarity.mandarine.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QDiscountCategory is a Querydsl query type for DiscountCategory
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QDiscountCategory extends EntityPathBase<DiscountCategory> {

    private static final long serialVersionUID = 432529651L;

    public static final QDiscountCategory discountCategory = new QDiscountCategory("discountCategory");

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

    public QDiscountCategory(String variable) {
        super(DiscountCategory.class, forVariable(variable));
    }

    public QDiscountCategory(Path<? extends DiscountCategory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDiscountCategory(PathMetadata<?> metadata) {
        super(DiscountCategory.class, metadata);
    }

}

