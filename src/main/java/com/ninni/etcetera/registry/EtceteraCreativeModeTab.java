package com.ninni.etcetera.registry;

import com.ninni.etcetera.Etcetera;
import com.ninni.etcetera.mixin.ItemGroupsAccessor;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.decoration.painting.PaintingEntity;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Predicate;

import static com.ninni.etcetera.registry.EtceteraItems.*;

public class EtceteraCreativeModeTab {

    public static final ItemGroup ITEM_GROUP = register("item_group", FabricItemGroup.builder().icon(ETCETERA::getDefaultStack).displayName(Text.translatable("etcetera.item_group")).entries((featureFlagSet, output) -> {
                output.add(RAW_BISMUTH_BLOCK);
                output.add(BISMUTH_BLOCK);
                output.add(BISMUTH_BARS);
                output.add(NETHER_BISMUTH_ORE);
                output.add(RAW_BISMUTH);
                output.add(BISMUTH_INGOT);
                output.add(IRIDESCENT_GLASS);
                output.add(IRIDESCENT_GLASS_PANE);
                output.add(IRIDESCENT_TERRACOTTA);
                output.add(IRIDESCENT_GLAZED_TERRACOTTA);
                output.add(IRIDESCENT_CONCRETE);
                output.add(IRIDESCENT_WOOL);
                output.add(IRIDESCENT_LANTERN);

                output.add(CHISEL);
                output.add(WRENCH);
                output.add(HAMMER);
                output.add(HANDBELL);

                output.add(ITEM_LABEL);

                output.add(DRUM);

                output.add(DICE);

                output.add(FRAME);

                output.add(PRICKLY_CAN);

                output.add(DREAM_CATCHER);

                output.add(BOUQUET);
                output.add(TERRACOTTA_VASE);

                output.add(ITEM_STAND);
                output.add(GLOW_ITEM_STAND);

                featureFlagSet.lookup().getOptionalWrapper(RegistryKeys.PAINTING_VARIANT).ifPresent((wrapper) -> addEtcPaintings(output, wrapper, (registryEntry) -> registryEntry.isIn(EtceteraTags.ETCETERA_PAINTING_VARIANTS), ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS));

                output.add(SQUID_LAMP);
                output.add(TIDAL_HELMET);
                output.add(TURTLE_RAFT);

                output.add(MUSIC_DISC_SQUALL);

                output.add(ADVENTURERS_BOOTS);

                output.add(GRAVEL_PATH);
                output.add(SAND_PATH);
                output.add(RED_SAND_PATH);
                output.add(SNOW_PATH);

                output.add(CRUMBLING_STONE);
                output.add(WAXED_CRUMBLING_STONE);
                output.add(LEVELED_STONE);
                output.add(LEVELED_STONE_STAIRS);
                output.add(LEVELED_STONE_SLAB);

                output.add(LIGHT_BULB);
                output.add(TINTED_LIGHT_BULB);

                output.add(GOLDEN_GOLEM);

                output.add(WEAVER_SPAWN_EGG);
                output.add(SILKEN_SLACKS);

                output.add(CHAPPLE_SPAWN_EGG);
                output.add(EGGPLE);
                output.add(GOLDEN_EGGPLE);

                output.add(COPPER_TAP);

                output.add(RUBBER);
                output.add(RUBBER_BLOCK);
                output.add(RUBBER_BUTTON);
                output.add(RUBBER_CHICKEN);
                output.add(REDSTONE_WIRES);
                output.add(REDSTONE_WIRE_TORCH);
                output.add(REDSTONE_WIRE_COMPARATOR);
                output.add(REDSTONE_WIRE_REPEATER);

                output.add(COTTON_SEEDS);
                output.add(COTTON_FLOWER);
                output.add(WHITE_SWEATER);
                output.add(LIGHT_GRAY_SWEATER);
                output.add(GRAY_SWEATER);
                output.add(BLACK_SWEATER);
                output.add(BROWN_SWEATER);
                output.add(RED_SWEATER);
                output.add(ORANGE_SWEATER);
                output.add(YELLOW_SWEATER);
                output.add(LIME_SWEATER);
                output.add(GREEN_SWEATER);
                output.add(CYAN_SWEATER );
                output.add(LIGHT_BLUE_SWEATER);
                output.add(BLUE_SWEATER);
                output.add(PURPLE_SWEATER);
                output.add(MAGENTA_SWEATER);
                output.add(PINK_SWEATER);
                output.add(TRADER_ROBE);
                output.add(WHITE_HAT);
                output.add(LIGHT_GRAY_HAT);
                output.add(GRAY_HAT);
                output.add(BLACK_HAT);
                output.add(BROWN_HAT);
                output.add(RED_HAT);
                output.add(ORANGE_HAT);
                output.add(YELLOW_HAT);
                output.add(LIME_HAT);
                output.add(GREEN_HAT);
                output.add(CYAN_HAT );
                output.add(LIGHT_BLUE_HAT);
                output.add(BLUE_HAT);
                output.add(PURPLE_HAT);
                output.add(MAGENTA_HAT);
                output.add(PINK_HAT);
                output.add(TRADER_HOOD);


            }).build()
    );

    static {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.addAfter(Items.SMOOTH_QUARTZ_SLAB,
                    BISMUTH_BLOCK,
                    BISMUTH_BARS
            );
            entries.addAfter(Items.SMOOTH_STONE_SLAB,
                    LEVELED_STONE,
                    CRUMBLING_STONE,
                    WAXED_CRUMBLING_STONE,
                    LEVELED_STONE_STAIRS,
                    LEVELED_STONE_SLAB
            );
            entries.addAfter(Items.MUD_BRICK_WALL,
                    RUBBER_BLOCK,
                    RUBBER_BUTTON
            );
        });


        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.addAfter(Items.SOUL_LANTERN, LIGHT_BULB, TINTED_LIGHT_BULB);
            entries.addAfter(Items.END_ROD, SQUID_LAMP);
            entries.addAfter(Items.SEA_LANTERN, IRIDESCENT_LANTERN);
            entries.addAfter(Items.JUKEBOX, DRUM);
            entries.addAfter(Items.SCAFFOLDING, FRAME);
            entries.addAfter(Items.DECORATED_POT, TERRACOTTA_VASE);
            entries.addAfter(Items.GLOW_ITEM_FRAME, ITEM_STAND, GLOW_ITEM_STAND);
            entries.addAfter(Items.ENDER_CHEST, PRICKLY_CAN);
            entries.addAfter(Items.SUSPICIOUS_GRAVEL, CRUMBLING_STONE, WAXED_CRUMBLING_STONE);
            entries.addAfter(Items.BELL, DREAM_CATCHER);
            entries.addAfter(Items.CAULDRON, COPPER_TAP);
            entries.addBefore(Items.SKELETON_SKULL, RUBBER_CHICKEN);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(entries -> {
            entries.addAfter(Items.COMPARATOR, REDSTONE_WIRES, REDSTONE_WIRE_TORCH, REDSTONE_WIRE_REPEATER, REDSTONE_WIRE_COMPARATOR);
            entries.addAfter(Items.HEAVY_WEIGHTED_PRESSURE_PLATE, DRUM);
            entries.addAfter(Items.WHITE_WOOL, DICE);
            entries.addAfter(Items.BARREL, PRICKLY_CAN);
            entries.addAfter(Items.STONE_BUTTON, RUBBER_BUTTON);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(entries -> {
            entries.addAfter(Items.CAVE_SPIDER_SPAWN_EGG, CHAPPLE_SPAWN_EGG);
            entries.addAfter(Items.WARDEN_SPAWN_EGG, WEAVER_SPAWN_EGG);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.addAfter(Items.EGG, EGGPLE, GOLDEN_EGGPLE);
            entries.addAfter(Items.TURTLE_HELMET,
                    TIDAL_HELMET,
                    SILKEN_SLACKS,
                    ADVENTURERS_BOOTS,
                    WHITE_HAT,
                    TRADER_HOOD,
                    WHITE_SWEATER,
                    TRADER_ROBE
            );
            entries.addAfter(Items.TRIDENT, HAMMER);
            entries.addBefore(Items.TOTEM_OF_UNDYING, GOLDEN_GOLEM);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.addAfter(Items.BRUSH,
                    HAMMER,
                    CHISEL,
                    WRENCH,
                    HANDBELL
            );
            entries.addAfter(Items.BAMBOO_CHEST_RAFT, TURTLE_RAFT);
            entries.addAfter(Items.NAME_TAG, ITEM_LABEL);
            entries.addBefore(Items.MUSIC_DISC_OTHERSIDE, MUSIC_DISC_SQUALL);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.addAfter(Items.GRAVEL, GRAVEL_PATH);
            entries.addAfter(Items.SAND, SAND_PATH);
            entries.addAfter(Items.RED_SAND, RED_SAND_PATH);
            entries.addAfter(Items.SNOW, SNOW_PATH);
            entries.addAfter(Items.NETHER_GOLD_ORE, NETHER_BISMUTH_ORE);
            entries.addAfter(Items.RAW_GOLD_BLOCK, RAW_BISMUTH_BLOCK);
            entries.addAfter(Items.PINK_PETALS, BOUQUET);
            entries.addAfter(Items.BEETROOT_SEEDS, COTTON_SEEDS);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(entries -> {
            entries.addBefore(Items.WHITE_CONCRETE, IRIDESCENT_CONCRETE);
            entries.addBefore(Items.WHITE_WOOL, IRIDESCENT_WOOL);
            entries.addBefore(Items.WHITE_GLAZED_TERRACOTTA, IRIDESCENT_GLAZED_TERRACOTTA);
            entries.addAfter(Items.TERRACOTTA, IRIDESCENT_TERRACOTTA);
            entries.addAfter(Items.GLASS, IRIDESCENT_GLASS);
            entries.addAfter(Items.GLASS_PANE, IRIDESCENT_GLASS_PANE);
            entries.addAfter(Items.PINK_BED,
                    WHITE_SWEATER,
                    LIGHT_GRAY_SWEATER,
                    GRAY_SWEATER,
                    BLACK_SWEATER,
                    BROWN_SWEATER,
                    RED_SWEATER,
                    ORANGE_SWEATER,
                    YELLOW_SWEATER,
                    LIME_SWEATER,
                    GREEN_SWEATER,
                    CYAN_SWEATER ,
                    LIGHT_BLUE_SWEATER,
                    BLUE_SWEATER,
                    PURPLE_SWEATER,
                    MAGENTA_SWEATER,
                    PINK_SWEATER,
                    WHITE_HAT,
                    LIGHT_GRAY_HAT,
                    GRAY_HAT,
                    BLACK_HAT,
                    BROWN_HAT,
                    RED_HAT,
                    ORANGE_HAT,
                    YELLOW_HAT,
                    LIME_HAT,
                    GREEN_HAT,
                    CYAN_HAT ,
                    LIGHT_BLUE_HAT,
                    BLUE_HAT,
                    PURPLE_HAT,
                    MAGENTA_HAT,
                    PINK_HAT
            );
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.addAfter(Items.NETHERITE_INGOT, RUBBER);
            entries.addAfter(Items.EGG, EGGPLE, GOLDEN_EGGPLE);
            entries.addAfter(Items.RAW_GOLD, RAW_BISMUTH);
            entries.addAfter(Items.GOLD_INGOT, BISMUTH_INGOT);
            entries.addAfter(Items.WHEAT, COTTON_FLOWER);
        });
    }

    private static void addEtcPaintings(ItemGroup.Entries entries, RegistryWrapper.Impl<PaintingVariant> registryWrapper, Predicate<RegistryEntry<PaintingVariant>> predicate, ItemGroup.StackVisibility visibility) {
        registryWrapper.streamEntries().filter(predicate).sorted(ItemGroupsAccessor.getPAINTING_VARIANT_COMPARATOR()).forEach((variant) -> {
            ItemStack itemStack = new ItemStack(Items.PAINTING);
            NbtCompound nbtCompound = itemStack.getOrCreateSubNbt("EntityTag");
            PaintingEntity.writeVariantToNbt(nbtCompound, variant);
            entries.add(itemStack, visibility);
        });
    }

    private static ItemGroup register(String id, ItemGroup tab) {
        return Registry.register(Registries.ITEM_GROUP, new Identifier(Etcetera.MOD_ID, id), tab);
    }
}
