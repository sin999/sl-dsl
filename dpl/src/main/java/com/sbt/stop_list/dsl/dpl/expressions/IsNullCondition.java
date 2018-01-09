package com.sbt.stop_list.dsl.dpl.expressions;

import com.sbt.persistence.api.criteria.Condition;
import com.sbt.persistence.api.criteria.Selector;

import java.util.Date;

public class IsNullCondition  extends AbstractCondition{
    @Override
    public Condition apply(Selector selector) {
        return  selector.$("",Date.class).isNull();
    }
}
