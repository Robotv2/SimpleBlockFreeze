package com.ordwen.simpleblockfreeze.enums;

import com.ordwen.simpleblockfreeze.BukkitConfigFile;
import com.ordwen.simpleblockfreeze.tools.ColorConvert;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

public enum Messages {

    COMMAND_NO_PERMISSION("no_permission", "&cYou don't have permission."),
    ITEM_NO_PERMISSION("item_no_permission", "&cYou don't have permission to use this item."),
    PLAYER_ONLY("player_only", "&cOnly player can execute this command."),

    FREEZE_SUCCESS("freeze_success", "&aBlock successfully frozen."),
    UNFREEZE_SUCCESS("unfreeze_success", "&aBlock successfully unfrozen."),
    ALREADY_FROZEN("already_frozen", "&cThis block is already frozen."),
    FREEZE_NOT_FOUND("freeze_not_found", "&cThis block is not frozen."),
    ERROR_OCCURRED("error_occurred", "&cAn error occurred. Please contact a server administrator."),
    ADMIN_HELP("admin_help", "&cUsage: /sbfa give <player>"),
    PLAYER_NOT_FOUND("player_not_found", "&cPlayer not found."),
    UNAUTHORIZED_REGION("unauthorized_region", "&cYou can't freeze blocks in this region."),

    ITEM_GIVEN("item_given", "&aFreeze item given to {player}."),
    CONFIG_RELOADED("config_reloaded", "&aConfiguration reloaded."),

    ;

    private final String path;
    private final String defaultMessage;
    private static BukkitConfigFile lang;

    /**
     * Message constructor.
     *
     * @param message message (String).
     */
    Messages(String path, String message) {
        this.path = path;
        this.defaultMessage = message;
    }

    /**
     * Set the {@code YamlConfiguration} to use.
     *
     * @param messagesFile the config to set.
     */
    public static void setFile(BukkitConfigFile messagesFile) {
        lang = messagesFile;
    }

    /**
     * Get message.
     *
     * @return message.
     */
    @Override
    public String toString() {
        String msg = lang.getConfiguration().getString(this.path, defaultMessage);

        if (msg.trim().isEmpty()) return "";
        else return ColorConvert.convertColorCode(msg);
    }

    /**
     * Get the default value of the path.
     *
     * @return the default value of the path.
     */
    public String getDefault() {
        return this.defaultMessage;
    }

    /**
     * Get the path to the string.
     *
     * @return the path to the string.
     */
    public String getPath() {
        return this.path;
    }

    public void send(CommandSender sender) {
        final String message = toString();
        if(!message.isEmpty()) {
            sender.sendMessage(message);
        }
    }
}
