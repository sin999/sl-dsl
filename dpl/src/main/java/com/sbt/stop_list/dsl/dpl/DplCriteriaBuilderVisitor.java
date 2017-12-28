package com.sbt.stop_list.dsl.dpl;

import com.sbt.persistence.api.basetypes.Dictionary;
import com.sbt.persistence.api.basetypes.Particle;
import com.sbt.persistence.api.collection.PublishedPartitionParticlesCollection;
import com.sbt.persistence.api.dao.DPL;
import com.sbt.persistence.api.dao.Partition;
import com.sbt.stop_list.jpa.JPABaseVisitor;
import com.sbt.stop_list.jpa.JPAParser;

public class DplCriteriaBuilderVisitor extends JPABaseVisitor<String> {

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
//        collection.filter().$("legacyId", Long.class).eq(10L);
        System.out.println("Select statement is visited");
        JPAParser.Where_clauseContext whereClause = ctx.where_clause();

        return "context is > " ;
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public String visitConditional_expression(JPAParser.Conditional_expressionContext ctx) {
        for (JPAParser.Conditional_termContext conditional_termContext : ctx.conditional_term()) {

        }
        System.out.println("Conditional_expression statement is visited");
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
        System.out.println("Conditional_term statement is visited");
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
        System.out.println(ctx.conditional_primary());
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
        System.out.println("Literal >> "+ctx.getText());
        return visitChildren(ctx);
    }


}


