package com.ntgclarity.mandarine.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QUserTable is a Querydsl query type for UserTable
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QUserTable extends EntityPathBase<UserTable> {

    private static final long serialVersionUID = -1241445969L;

    public static final QUserTable userTable = new QUserTable("userTable");

    public final com.ntgclarity.mandarine.service.base.QBaseEntity _super = new com.ntgclarity.mandarine.service.base.QBaseEntity(this);

    public final StringPath address = createString("address");

    public final StringPath column1 = createString("column1");

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final NumberPath<Integer> deleted = _super.deleted;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QUserTable(String variable) {
        super(UserTable.class, forVariable(variable));
    }

    public QUserTable(Path<? extends UserTable> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserTable(PathMetadata<?> metadata) {
        super(UserTable.class, metadata);
    }

}

