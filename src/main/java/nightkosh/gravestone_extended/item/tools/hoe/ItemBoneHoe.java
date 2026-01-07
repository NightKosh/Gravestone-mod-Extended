package nightkosh.gravestone_extended.item.tools.hoe;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ItemBoneHoe {//TODO extends ItemHoe implements IBoneHoe {
//
//    public ItemBoneHoe() {
//        this(ToolMaterial.STONE);
//        this.setUnlocalizedName("gravestone.bone_hoe");
//        this.setRegistryName(ModInfo.ID, "gs_bone_hoe");
//        this.setCreativeTab(null);
//    }
//
//    public ItemBoneHoe(ToolMaterial material) {
//        super(material);
//    }
//
//    @Override
//    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
//        return super.getIsRepairable(toRepair, repair) || repair.getItem() == Item.getItemFromBlock(GSBlock.BONE_BLOCK);
//    }
//
//    @Override
//    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
//        ItemStack stack = player.getHeldItem(hand);
//        IBlockState state = world.getBlockState(pos);
//        if (state.getBlock() instanceof IGrowable) {
//            NBTTagList nbtList = stack.getEnchantmentTagList();
//            for (NBTBase nbt : nbtList) {
//                if (((NBTTagCompound) nbt).getInteger("id") == Enchantment.getEnchantmentID(GSEnchantment.BONE_RAIN)) {
//                    if (applyBonemeal(stack, world, pos, state, player, hand)) {
//                        if (!world.isRemote) {
//                            world.playEvent(2005, pos, 0);
//                        }
//                        return EnumActionResult.SUCCESS;
//                    }
//                    break;
//                }
//            }
//        }
//
//        return super.onItemUse(player, world, pos, hand, side, hitX, hitY, hitZ);
//    }
//
//    public static boolean applyBonemeal(ItemStack stack, World worldIn, BlockPos pos, IBlockState state, EntityPlayer player, @javax.annotation.Nullable EnumHand hand) {
//        if (!(state.getBlock() instanceof BlockGrass) || player.isSneaking()) {
//
//            int hook = net.minecraftforge.event.ForgeEventFactory.onApplyBonemeal(player, worldIn, pos, state, stack, hand);
//            if (hook != 0) return hook > 0;
//
//            IGrowable igrowable = (IGrowable) state.getBlock();
//            if (igrowable.canGrow(worldIn, pos, state, worldIn.isRemote)) {
//                if (!worldIn.isRemote) {
//                    if (igrowable.canUseBonemeal(worldIn, worldIn.rand, pos, state)) {
//                        igrowable.grow(worldIn, worldIn.rand, pos, state);
//                    }
//                    stack.damageItem(1, player);
//                }
//                return true;
//            }
//        }
//        return false;
//    }
}
