package nightkosh.gravestone_extended.core.commands;


/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class SubCommandStatue {//TODO implements ISubCommand {
//
//    public static final String COMMAND_NAME = "getStatue";
//    public static final String COMMAND_USAGE = Command.MAIN_COMMAND_NAME + COMMAND_NAME + " <player name> <material>";
//
//    @Override
//    public String getCommandName() {
//        return COMMAND_NAME;
//    }
//
//    @Override
//    public String getCommandUsage() {
//        return COMMAND_USAGE;
//    }
//
//    @Override
//    public void execute(MinecraftServer minecraftServer, ICommandSender sender, String[] args) throws CommandException {
//        GSLogger.logInfo("Player statue command received");
//
//        if (args.length >= 1) {
//            EnumMemorials memorialType = EnumMemorials.STONE_STEVE_STATUE;
//            if (StringUtils.isNotBlank(args[2])) {
//                try {
//                    memorialType = EnumMemorials.getByTypeAndMaterial(EnumMemorialType.STEVE_STATUE, EnumGraveMaterial.valueOf(args[2].toUpperCase()));
//                } catch (Exception e) {
//                    sender.sendMessage(new TextComponentTranslation("commands.unknown_material").setStyle(new Style().setColor(TextFormatting.RED)));
//                }
//            }
//            GameProfileHelper.dropItem(minecraftServer, sender, args[1], GSBlock.MEMORIAL, memorialType.ordinal());
//        } else {
//            sender.sendMessage(new TextComponentTranslation("commands.not_enough_parameters").setStyle(new Style().setColor(TextFormatting.RED)));
//        }
//    }
}
