package com.sbt.stop_list.dsl.dpl;

import com.sbt.persistence.api.collection.ParticleCollection;

public interface StopListFilter {
    void apply(ParticleCollection particleCollection, String query);
}
