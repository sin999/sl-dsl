package com.sbt.stop_list.dsl.dpl.expressions;

import com.sbt.persistence.api.criteria.Condition;
import com.sbt.persistence.api.criteria.Selector;

import java.util.ArrayList;
import java.util.Collection;

public class OrExpression {

    private Collection<AndExpression> andExpressions = new ArrayList<>();


    public Condition apply(Selector selector) {
        Condition condition = null;
        for (AndExpression andExpression : andExpressions) {
            if (condition == null) condition = andExpression.apply(selector);
            else condition = andExpression.apply(condition.or());
        }
        return condition;
    }
}
