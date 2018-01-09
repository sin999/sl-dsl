package com.sbt.stop_list.dsl.dpl.expressions;

import com.sbt.persistence.api.criteria.Condition;
import com.sbt.persistence.api.criteria.Selector;

public abstract class AbstractCondition {
    public abstract Condition apply(Selector selector);
}
