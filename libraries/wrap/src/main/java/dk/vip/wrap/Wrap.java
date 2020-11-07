package dk.vip.wrap;

import dk.vip.expression.Expression;

/**
 * A Wrap contains 2 parts. The expression, that is the commands that the
 * user wants to use on the server. And then the "MetaCollection" which is a
 * collection of meta data that is used to place the user the correct spot in
 * the internal VIP.
 */
public class Wrap {

    private final Expression expression;
    private final MetaCollection metaCollection;

    public Wrap(Expression expression, MetaCollection metaCollection) {
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
