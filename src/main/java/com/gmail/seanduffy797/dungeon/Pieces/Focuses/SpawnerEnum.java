package com.gmail.seanduffy797.dungeon.Pieces.Focuses;

public enum SpawnerEnum {
    GLADIATOR ("{SpawnPotentials:[" +
            "{data:" +
                "{entity:" +
                    "{id:skeleton," +
                    "LeftHanded:1b," +
                    "HandItems:" +
                        "[{Count:1,id:stone_sword,tag:{display:{Name:\"\\\"Gladius\\\"\"}}},{}]," +
                    "ArmorItems:" +
                        "[{Count:1,id:chainmail_boots,tag:{display:{Name:\"\\\"Gladiator Boots\\\"\"}}}," +
                        "{Count:1,id:chainmail_leggings,tag:{display:{Name:\"\\\"Gladiator Greaves\\\"\"}}}," +
                        "{Count:1,id:chainmail_chestplate,tag:{display:{Name:\"\\\"Gladiator Chestplate\\\"\"}}}," +
                        "{Count:1,id:chainmail_helmet,tag:{display:{Name:\"\\\"Gladiator Helmet\\\"\"}}}]," +
                    "CustomName:\"\\\"Gladiator\\\"\"," +
                    "HandDropChances:[0.08f,0.0f]," +
                    "ArmorDropChances:[0.08f,0.08f,0.08f,0.08f]}," +
                "}," +
                "weight:1," +
            "}," +
            "{data:" +
                "{entity:" +
                    "{id:skeleton," +
                    "LeftHanded:1b," +
                    "HandItems:" +
                        "[{Count:1,id:wooden_sword,tag:{display:{Name:\"\\\"Rudis\\\"\"}}},{}]," +
                    "ArmorItems:" +
                        "[{Count:1,id:leather_boots,tag:{display:{Name:\"\\\"Rudiarius Boots\\\"\"}}}," +
                        "{Count:1,id:leather_leggings,tag:{display:{Name:\"\\\"Rudiarius Greaves\\\"\"}}}," +
                        "{Count:1,id:leather_chestplate,tag:{display:{Name:\"\\\"Rudiarius Chestplate\\\"\"}}}," +
                        "{Count:1,id:leather_helmet,tag:{display:{Name:\"\\\"Rudiarius Helmet\\\"\"}}}]," +
                    "CustomName:\"\\\"Rudiarius\\\"\"," +
                    "HandDropChances:[0.08f,0.0f]," +
                    "ArmorDropChances:[0.08f,0.08f,0.08f,0.08f]}," +
                "}," +
                "weight:2," +
            "}," +
            "{data:" +
                "{entity:" +
                    "{id:skeleton," +
                    "CustomName:\"\\\"Cestus\\\"\"}," +
                "}," +
                "weight:4" +
            "}," +
            "{data:" +
                "{entity:" +
                    "{id:skeleton," +
                    "HandItems:" +
                        "[{Count:1,id:wooden_sword,tag:{display:{Name:\"\\\"Sica\\\"\"}}},{Count:1,id:wooden_sword,tag:{display:{Name:\"\\\"Sica\\\"\"}}}]," +
                    "HandDropChances:[0.08f,0.08f]," +
                    "CustomName:\"\\\"Dimachaerus\\\"\"}," +
                "}," +
                "weight:2" +
            "}," +
            "{data:" +
                "{entity:" +
                    "{id:skeleton," +
                    "HandItems:" +
                        "[{Count:1,id:bow,tag:{display:{Name:\"\\\"Reflex Bow\\\"\"}}},{}]," +
                    "HandDropChances:[0.08f,0.0f]," +
                    "CustomName:\"\\\"Sagittarius\\\"\"}," +
                "}," +
                "weight:3" +
            "}," +
            "{data:" +
                "{entity:" +
                    "{id:skeleton," +
                    "HandItems:" +
                        "[{Count:1,id:bamboo,tag:{display:{Name:\"\\\"Palm Branch\\\"\"}}},{}]," +
                    "HandDropChances:[1.0f,0.0f]," +
                    "CustomName:\"\\\"Editor\\\"\"}," +
                "}," +
                "weight:2" +
            "}" +
            "]," +
            "SpawnCount:2,MaxNearbyEntities:8,Delay:199,MinSpawnDelay:400,MaxSpawnDelay:1100,RequiredPlayerRange:24}"),
    VEX ("");

    private final String details;

    SpawnerEnum(String details) { this.details = details; }

    public String getDetails() {return details; }
}
