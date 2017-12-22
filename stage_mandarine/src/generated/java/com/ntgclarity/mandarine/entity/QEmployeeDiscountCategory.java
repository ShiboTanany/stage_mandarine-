package com.ntgclarity.mandarine.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QEmployeeDiscountCategory is a Querydsl query type for EmployeeDiscountCategory
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QEmployeeDiscountCategory extends EntityPathBase<EmployeeDiscountCategory> {

    private static final long serialVersionUID = -1814225983L;

    public static final QEmployeeDiscountCategory employeeDiscountCategory = new QEmployeeDiscountCategory("employeeDiscountCategory");

    public final com.ntgclarity.mandarine.service.base.QBaseEntity _super = new com.ntgclarity.mandarine.service.base.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final NumberPath<Integer> deleted = _super.deleted;

    public final StringPath discountCategory = createString("discountCategory");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath name = createString("name");

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QEmployeeDiscountCategory(String variable) {
        super(EmployeeDiscountCategory.class, forVariable(variable));
    }

    public QEmployeeDiscountCategory(Path<? extends EmployeeDiscountCategory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEmployeeDiscountCategory(PathMetadata<?> metadata) {
        super(EmployeeDiscountCategory.class, metadata);
    }

}

