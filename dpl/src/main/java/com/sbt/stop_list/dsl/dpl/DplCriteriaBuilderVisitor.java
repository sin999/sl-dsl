package com.sbt.stop_list.dsl.dpl;

import com.sbt.persistence.api.basetypes.Dictionary;
import com.sbt.persistence.api.basetypes.Particle;
import com.sbt.persistence.api.collection.PublishedPartitionParticlesCollection;
import com.sbt.persistence.api.dao.DPL;
import com.sbt.persistence.api.dao.Partition;
import com.sbt.stop_list.jpa.JPABaseVisitor;
import com.sbt.stop_list.jpa.JPAParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DplCriteriaBuilderVisitor extends JPABaseVisitor<String> {

    private Logger logger = LoggerFactory.getLogger(DplCriteriaBuilderVisitor.class);

    private DPL dpl;
    private Dictionary partitionDictionary;
    private Partition partition;
    //    private final Class<? extends Particle> findingParticleClass;
    private PublishedPartitionParticlesCollection collection;

    public DplCriteriaBuilderVisitor(Partition partition, Class<? extends Particle> findingParticleClass) {
//        this.findingParticleClass = findingParticleClass;
//        this.partition = partition;
//        collection = partition.getParticles(findingParticleClass);
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public String visitSelect_statement(JPAParser.Select_statementContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public String visitWhere_clause(JPAParser.Where_clauseContext ctx) {
        logger.info("Where clause is visited");
        return visitChildren(ctx);
    }


    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public String visitConditional_expression(JPAParser.Conditional_expressionContext ctx) {
        logger.info("Conditional_expression statement is visited");
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public String visitConditional_term(JPAParser.Conditional_termContext ctx) {
        logger.info("Conditional_term statement is visited");
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public String visitConditional_factor(JPAParser.Conditional_factorContext ctx) {
        logger.info("Conditional_factor");
        return visitChildren(ctx);
    }


    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public String visitConditional_primary(JPAParser.Conditional_primaryContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public String visitSimple_cond_expression(JPAParser.Simple_cond_expressionContext ctx) {
        logger.info("Visiting Simple cond expression");
//        for(ParseTree pt : ctx.children)
//            logger.info(pt.getText());

        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public String visitComparison_expression(JPAParser.Comparison_expressionContext ctx) {
        logger.info("Visiting SComparison_expression");
//                for(ParseTree pt : ctx.children)
//            logger.info(pt.getText());
        return visitChildren(ctx);
    }


    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public String visitNumeric_literal(JPAParser.Numeric_literalContext ctx) {
        System.out.println("Literal >> " + ctx.getText());
        return visitChildren(ctx);
    }


}


