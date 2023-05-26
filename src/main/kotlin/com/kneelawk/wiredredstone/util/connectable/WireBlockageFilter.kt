package com.kneelawk.wiredredstone.util.connectable

import com.kneelawk.graphlib.api.graph.NodeContext
import com.kneelawk.graphlib.api.graph.NodeHolder
import com.kneelawk.graphlib.api.node.BlockNode
import com.kneelawk.graphlib.api.wire.SidedWireBlockNode
import com.kneelawk.graphlib.api.wire.SidedWireConnectionFilter
import com.kneelawk.graphlib.api.wire.WireConnectionType
import net.minecraft.util.math.Direction

class WireBlockageFilter(
    private val wireSide: Direction, private val wireWidth: Double, private val wireHeight: Double
) : SidedWireConnectionFilter {
    override fun canConnect(
        self: SidedWireBlockNode, ctx: NodeContext, inDirection: Direction, connectionType: WireConnectionType,
        otherNode: NodeHolder<BlockNode>
    ): Boolean {
        return ConnectableUtils.canWireConnect(
            ctx.blockWorld, ctx.pos, inDirection, connectionType, wireSide, wireWidth, wireHeight
        )
    }
}
