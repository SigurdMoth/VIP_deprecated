package dk.vip.session.domain.network;

import java.util.Comparator;

import dk.vip.session.domain.network.models.VipNode;

public class NodeComparator implements Comparator<VipNode> {

    @Override
    public int compare(VipNode o1, VipNode o2) {
        return o1.getId() - o2.getId();
    }
}
