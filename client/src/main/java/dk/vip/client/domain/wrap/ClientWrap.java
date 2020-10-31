package dk.vip.client.domain.wrap;

import dk.vip.client.domain.interpret.Expression;

public class ClientWrap {

    private final Expression expression;
    private final MetaCollection metaCollection;

    public ClientWrap(Expression expression, MetaCollection metaCollection) {
        this.expression = expression;
        this.metaCollection = metaCollection;
    }

    public Expression getExpression() {
        return this.expression;
    }

    public MetaCollection getMetaCollection() {
        return this.metaCollection;
    }

    @Override
    public String toString() {
        return "{" + " expression='" + getExpression() + "'" + ", metaCollection='" + getMetaCollection() + "'" + "}";
    }

    /*
     * MetaBundle include() { MetaBundle bundle = new
     * MetaBundle("NetworkConfiguration"); bundle.put("network", network);
     * bundle.put("node", node); return bundle; }
     */

    /**
     * { expression } ... { metaCollection { name : "network", properties : [
     * "network" : "4", "node" : "10" ] }, { bundle (UserConfiguration) } }
     */

}