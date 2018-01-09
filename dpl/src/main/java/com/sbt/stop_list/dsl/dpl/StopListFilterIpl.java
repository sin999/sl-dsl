package com.sbt.stop_list.dsl.dpl;

import com.sbt.persistence.api.collection.ParticleCollection;
import com.sbt.persistence.api.criteria.RootSelector;

public class StopListFilterIpl implements StopListFilter {
    @Override
    public void apply(ParticleCollection particleCollection, String query) {
        RootSelector rootSelector = particleCollection.filter();
        rootSelector.$("",String.class).not().eq("").and();
    }
}
