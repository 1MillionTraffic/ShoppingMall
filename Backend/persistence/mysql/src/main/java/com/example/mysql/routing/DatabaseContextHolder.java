package com.example.mysql.routing;

import java.util.HashMap;
import java.util.Map;

public class DatabaseContextHolder {
    private static final ThreadLocal<Map<ShardKey, Integer>> context = ThreadLocal.withInitial(() -> {
        HashMap<ShardKey, Integer> shardMap = new HashMap<>();
        shardMap.put(ShardKey.BILLING, 0);
        return shardMap;
    });

    public static void setBillingShard(int shardNumber) {
        context.get().put(ShardKey.BILLING, shardNumber);
    }

    public static Map<ShardKey, Integer> getShardMap() {
        return context.get();
    }

}