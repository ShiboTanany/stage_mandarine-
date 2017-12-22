package com.ntgclarity.mandarine.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QDownloadType is a Querydsl query type for DownloadType
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QDownloadType extends EntityPathBase<DownloadType> {

    private static final long serialVersionUID = -1475916426L;

    public static final QDownloadType downloadType = new QDownloadType("downloadType");

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

    public QDownloadType(String variable) {
        super(DownloadType.class, forVariable(variable));
    }

    public QDownloadType(Path<? extends DownloadType> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDownloadType(PathMetadata<?> metadata) {
        super(DownloadType.class, metadata);
    }

}

