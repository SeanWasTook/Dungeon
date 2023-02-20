package com.gmail.seanduffy797.dungeon.Items.management;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;

public enum Rarity {
    COMMON("Common", NamedTextColor.GRAY),
    UNCOMMON("Uncommon", NamedTextColor.DARK_AQUA),
    RARE("Rare", NamedTextColor.DARK_BLUE),
    LEGENDARY("Legendary", NamedTextColor.GOLD);

    private final TextComponent display;

    Rarity(String text, NamedTextColor color) {
        this.display = Component.text(text).color(color);
    }

    public TextComponent display() {
        return this.display;
    }
}
