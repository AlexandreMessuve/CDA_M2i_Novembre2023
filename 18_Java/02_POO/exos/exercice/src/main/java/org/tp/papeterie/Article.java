package org.tp.papeterie;

import java.util.UUID;

public abstract class Article {
    protected final UUID ref;

    public Article() {
        this.ref = UUID.randomUUID();
    }

    public UUID getRef(){
        return ref;
    }
}
