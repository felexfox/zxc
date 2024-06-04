package org.flx.zxc.util;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;

public class TextUtil {

    protected static final MiniMessage mm = MiniMessage.miniMessage();

    public static Component wrap(String input) {
        return mm.deserialize(input);
    }

}