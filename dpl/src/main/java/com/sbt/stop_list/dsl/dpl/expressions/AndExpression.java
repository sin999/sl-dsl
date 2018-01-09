package com.sbt.stop_list.dsl.dpl.expressions;

import com.sbt.persistence.api.criteria.Condition;
import com.sbt.persistence.api.criteria.Selector;

import java.util.ArrayList;
import java.util.Collection;

public class AndExpression {

    private Collection<AbstractCondition> conditions = new ArrayList<>();


    public Condition apply(Selector selector) {
        Condition condition = null;
        for (AbstractCondition abstractCondition : conditions) {
            if (condition == null) condition = abstractCondition.apply(selector);
            else condition = abstractCondition.apply(condition.and());
        }
        return condition;
    }
}
