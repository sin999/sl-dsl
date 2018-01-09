package com.sbt.stop_list.dsl.dpl.expressions;

import com.sbt.persistence.api.criteria.Condition;
import com.sbt.persistence.api.criteria.Selector;
import com.sbt.stop_list.dsl.dpl.PropertyConverter;

public class EqualCondition extends AbstractCondition{

    private PropertyConverter propertyConverter;

    public Condition apply(Selector selector) {
        return applyTyped(selector);
    }

    private  <E,T> Condition applyTyped(Selector selector) {
        PropertyConverter<E,T> typedPropertyConverter = ((PropertyConverter<E,T>)propertyConverter);
        Class<T> propertyClass = typedPropertyConverter.resultClass();
        return selector.$(typedPropertyConverter.resultProprtyName(),propertyClass)
                .eq(typedPropertyConverter.resultValue(propertyClass,null));
    }

    protected <E,T> PropertyConverter<E,T> typedConverter(){
        return ((PropertyConverter<E,T>)propertyConverter);
    }
}
