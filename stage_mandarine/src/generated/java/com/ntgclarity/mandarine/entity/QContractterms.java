package com.ntgclarity.mandarine.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QContractterms is a Querydsl query type for Contractterms
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QContractterms extends EntityPathBase<Contractterms> {

    private static final long serialVersionUID = 975945889L;

    public static final QContractterms contractterms = new QContractterms("contractterms");

    public final com.ntgclarity.mandarine.service.base.QBaseEntity _super = new com.ntgclarity.mandarine.service.base.QBaseEntity(this);

    public final StringPath contractterm = createString("contractterm");

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final NumberPath<java.math.BigInteger> defaultcontract = createNumber("defaultcontract", java.math.BigInteger.class);

    //inherited
    public final NumberPath<Integer> deleted = _super.deleted;

    public final StringPath description = createString("description");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final NumberPath<java.math.BigInteger> iswebcontent = createNumber("iswebcontent", java.math.BigInteger.class);

    public final NumberPath<java.math.BigInteger> numberofmonths = createNumber("numberofmonths", java.math.BigInteger.class);

    public final NumberPath<java.math.BigDecimal> recid = createNumber("recid", java.math.BigDecimal.class);

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QContractterms(String variable) {
        super(Contractterms.class, forVariable(variable));
    }

    public QContractterms(Path<? extends Contractterms> path) {
        super(path.getType(), path.getMetadata());
    }

    public QContractterms(PathMetadata<?> metadata) {
        super(Contractterms.class, metadata);
    }

}

