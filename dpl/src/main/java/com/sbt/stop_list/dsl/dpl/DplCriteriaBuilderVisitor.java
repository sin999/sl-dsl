package com.sbt.stop_list.dsl.dpl;

import com.sbt.persistence.api.basetypes.Dictionary;
import com.sbt.persistence.api.collection.ParticleCollection;
import com.sbt.persistence.api.dao.DPL;
import com.sbt.persistence.api.dao.Partition;
import com.sbt.stop_list.sl_grammar.StopListDslBaseVisitor;
import com.sbt.stop_list.sl_grammar.StopListDslParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DplCriteriaBuilderVisitor extends StopListDslBaseVisitor<String> {

    private Logger logger = LoggerFactory.getLogger(DplCriteriaBuilderVisitor.class);

    private DPL dpl;
    private Dictionary partitionDictionary;
    private Partition partition;
    private ParticleCollection particleCollection;

    public DplCriteriaBuilderVisitor(ParticleCollection particleCollection) {
//        particleCollection.filter().$("",Object.class);
    }

    @Override
    public String visitWhere_clause(StopListDslParser.Where_clauseContext ctx) {
        logger.info("Its the where clause!");
        return visitChildren(ctx);
    }


}


