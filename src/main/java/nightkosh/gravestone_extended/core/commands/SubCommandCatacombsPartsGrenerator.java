package nightkosh.gravestone_extended.core.commands;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import nightkosh.gravestone.core.commands.Command;
import nightkosh.gravestone.core.commands.ISubCommand;
import nightkosh.gravestone_extended.core.logger.GSLogger;
import nightkosh.gravestone_extended.structures.catacombs.components.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class SubCommandCatacombsPartsGrenerator implements ISubCommand {

    public static final String COMMAND_NAME = "catacombs_part";
    public static final String COMMAND_USAGE = Command.MAIN_COMMAND_NAME + COMMAND_NAME + " <part name> <direction> <x coordinate> <y coordinate> <z coordinate> <level>";


    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public String getCommandUsage() {
        return COMMAND_USAGE;
    }

    @Override
    public void execute(MinecraftServer minecraftServer, ICommandSender sender, String[] args) throws CommandException {
        GSLogger.logInfo("Catacombs part generation command received");
        GSLogger.logInfo("Do you know it is for debug purpose?");

        if (args.length >= 2) {
            String structureName = args[1];
            int x = sender.getPosition().getX();
            int y = sender.getPosition().getY();
            int z = sender.getPosition().getZ();
            int level = 0;
            EnumFacing facing = EnumFacing.getHorizontal(MathHelper.floor((double) (((Entity) sender).rotationYaw * 4 / 360F) + 0.5) & 3);
            try {
                if (args.length >= 3) {
                    facing = EnumFacing.byName(args[2]);
                    if (facing == null) {
                        sender.sendMessage(new TextComponentTranslation("commands.direction_error").setStyle(new Style().setColor(TextFormatting.RED)));
                        return;
                    }
                    if (args.length >= 4) {
                        x = Integer.parseInt(args[3]);
                        if (args.length >= 5) {
                            y = Integer.parseInt(args[4]);
                            if (args.length >= 6) {
                                z = Integer.parseInt(args[5]);
                                if (args.length >= 7) {
                                    level = Integer.parseInt(args[6]);
                                }
                            }
                        }
                    }
                }
            } catch (NumberFormatException e) {
                sender.sendMessage(new TextComponentTranslation("commands.coordinate_error").setStyle(new Style().setColor(TextFormatting.RED)));
                return;
            }
            Random rand = new Random();
            switch (structureName) {
                case "Bridge":
                    generateComponent(sender.getEntityWorld(), Bridge.class, rand, x, y, z, facing, level);
                    break;
                case "Corridor":
                    generateComponent(sender.getEntityWorld(), Corridor.class, rand, x, y, z, facing, level);
                    break;
                case "CreeperRoom":
                    generateComponent(sender.getEntityWorld(), CreeperRoom.class, rand, x, y, z, facing, level);
                    break;
                case "Crossing":
                    generateComponent(sender.getEntityWorld(), Crossing.class, rand, x, y, z, facing, level);
                    break;
                case "EnderHall":
                    generateComponent(sender.getEntityWorld(), EnderHall.class, rand, x, y, z, facing, level);
                    break;
                case "GraveCorridor":
                    generateComponent(sender.getEntityWorld(), GraveCorridor.class, rand, x, y, z, facing, level);
                    break;
                case "GraveHall":
                    generateComponent(sender.getEntityWorld(), GraveHall.class, rand, x, y, z, facing, level);
                    break;
                case "Mausoleum":
                    generateComponent(sender.getEntityWorld(), Mausoleum.class, rand, x, y, z, facing, level);
                    break;
                case "SpidersCorridor":
                    generateComponent(sender.getEntityWorld(), SpidersCorridor.class, rand, x, y, z, facing, level);
                    break;
                case "Stairs":
                    generateComponent(sender.getEntityWorld(), Stairs.class, rand, x, y, z, facing, level);
                    break;
                case "StatuesHall":
                    generateComponent(sender.getEntityWorld(), StatuesHall.class, rand, x, y, z, facing, level);
                    break;
                case "TrapCorridor":
                    generateComponent(sender.getEntityWorld(), TrapCorridor.class, rand, x, y, z, facing, level);
                    break;
                case "Treasury":
                    generateComponent(sender.getEntityWorld(), Treasury.class, rand, x, y, z, facing, level);
                    break;
                case "WitherHall":
                    generateComponent(sender.getEntityWorld(), WitherHall.class, rand, x, y, z, facing, level);
                    break;
                case "CatacombsEntrance":
                    generateComponent(sender.getEntityWorld(), CatacombsEntrance.class, rand, x, y, z, facing, level);
                    break;
                case "MausoleumPortal":
                    generateComponent(sender.getEntityWorld(), MausoleumPortal.class, rand, x, y, z, facing, level);
                    break;
                case "CatacombsPortal":
                    //TODO !!!!
                    generateComponent(sender.getEntityWorld(), MausoleumPortal.class, rand, x, y, z, facing, level);
                    break;
                default:
                    sender.sendMessage(new TextComponentTranslation("commands.generate.unknown_structure").setStyle(new Style().setColor(TextFormatting.RED)));
                    break;
            }
        } else {
            sender.sendMessage(new TextComponentTranslation("commands.not_enough_parameters").setStyle(new Style().setColor(TextFormatting.RED)));
        }

    }

    private static void generateComponent(World world, Class<? extends CatacombsBaseComponent> componentClass, Random rand, int x, int y, int z, EnumFacing direction, int level) {
        try {
            Constructor<? extends CatacombsBaseComponent> constructor = componentClass.getConstructor(EnumFacing.class, int.class, Random.class, int.class, int.class, int.class);
            CatacombsBaseComponent component = constructor.newInstance(direction, level, rand, x, y, z);
            component.addComponentParts(world, rand);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
