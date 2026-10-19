package dev.inspectitems.client.anim;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/** Catalog of inspect routines per item category. Add new ones here. */
public final class Animations {
	public enum Category { SWORD, AXE, TOOL, MACE, SPEAR, GENERIC }

	private static final Map<Category, List<InspectAnimation>> CATALOG = new EnumMap<>(Category.class);

	// ---- Sword -------------------------------------------------------------------------
	public static final InspectAnimation SWORD_TWIRL = InspectAnimation.builder("Sword twirl", 52)
		.yaw(Track.smooth(0, 0, 0.12f, 0, 0.28f, -70, 0.40f, -70, 0.52f, 0, 1, 0))
		.roll(Track.smooth(0, 0, 0.52f, 0, 0.80f, 360, 1, 360))
		.up(Track.smooth(0, 0, 0.52f, 0, 0.66f, 0.06f, 0.80f, 0, 1, 0))
		.pitch(Track.smooth(0, 0, 0.80f, 0, 0.87f, -18, 0.94f, 0, 1, 0))
		.build();

	public static final InspectAnimation SWORD_FLIP = InspectAnimation.builder("Sword flip", 56)
		.up(Track.smooth(0, 0, 0.22f, 0, 0.44f, 0.30f, 0.66f, 0, 1, 0))
		.pitch(Track.smooth(0, 0, 0.22f, 0, 0.66f, -360, 1, -360))
		.yaw(Track.smooth(0, 0, 0.70f, 0, 0.82f, 45, 0.94f, 0, 1, 0))
		.roll(Track.smooth(0, 0, 0.70f, 0, 0.80f, -35, 0.92f, 0, 1, 0))
		.build();

	// ---- Axe ---------------------------------------------------------------------------
	public static final InspectAnimation AXE_TOSS = InspectAnimation.builder("Axe toss", 56)
		.up(Track.smooth(0, 0, 0.18f, 0, 0.42f, 0.42f, 0.68f, 0, 1, 0))
		.pitch(Track.smooth(0, 0, 0.18f, 0, 0.68f, -720, 1, -720))
		.depth(Track.smooth(0, 0, 0.18f, 0, 0.42f, -0.10f, 0.68f, 0, 1, 0))
		.build();

	public static final InspectAnimation AXE_CHOP = InspectAnimation.builder("Axe chop", 48)
		.pitch(Track.smooth(0, 0, 0.28f, -70, 0.40f, -70, 0.48f, 40, 0.56f, 28, 0.64f, 40, 0.86f, 0, 1, 0))
		.depth(Track.smooth(0, 0, 0.40f, 0.05f, 0.48f, -0.16f, 0.64f, -0.10f, 0.86f, 0, 1, 0))
		.up(Track.smooth(0, 0, 0.28f, 0.08f, 0.40f, 0.08f, 0.48f, -0.10f, 0.86f, 0, 1, 0))
		.build();

	// ---- Pickaxe / shovel / hoe / misc tools ------------------------------------------------
	public static final InspectAnimation TOOL_TWIRL = InspectAnimation.builder("Tool twirl", 48)
		.roll(Track.smooth(0, 0, 0.14f, 0, 0.62f, 360, 1, 360))
		.yaw(Track.smooth(0, 0, 0.62f, 0, 0.76f, 60, 0.90f, 0, 1, 0))
		.up(Track.smooth(0, 0, 0.14f, 0, 0.38f, 0.08f, 0.62f, 0, 1, 0))
		.build();

	// ---- Mace --------------------------------------------------------------------------
	public static final InspectAnimation MACE_SLAM = InspectAnimation.builder("Mace slam", 64)
		.pitch(Track.smooth(0, 0, 0.30f, -95, 0.46f, -95, 0.54f, 38, 0.62f, 26, 0.70f, 34, 0.88f, 0, 1, 0))
		.up(Track.smooth(0, 0, 0.30f, 0.24f, 0.46f, 0.24f, 0.54f, -0.18f, 0.70f, -0.10f, 0.88f, 0, 1, 0))
		.depth(Track.smooth(0, 0, 0.46f, 0, 0.54f, -0.12f, 0.88f, 0, 1, 0))
		.roll(Track.smooth(0, 0, 0.54f, 0, 0.58f, 7, 0.62f, -6, 0.66f, 4, 0.70f, -2, 0.76f, 0, 1, 0))
		.build();

	public static final InspectAnimation MACE_SPIN = InspectAnimation.builder("Mace spin", 64)
		.yaw(Track.smooth(0, 0, 0.18f, 0, 0.72f, 720, 1, 720))
		.pitch(Track.smooth(0, 0, 0.18f, 0, 0.35f, -22, 0.72f, -22, 0.88f, 0, 1, 0))
		.up(Track.smooth(0, 0, 0.18f, 0, 0.45f, 0.10f, 0.72f, 0, 1, 0))
		.build();

	// ---- Spear / trident ---------------------------------------------------------------
	public static final InspectAnimation SPEAR_THRUST = InspectAnimation.builder("Spear thrust", 52)
		.depth(Track.smooth(0, 0, 0.18f, 0.25f, 0.30f, 0.25f, 0.38f, -0.50f, 0.50f, -0.50f, 0.68f, 0, 1, 0))
		.pitch(Track.smooth(0, 0, 0.18f, 12, 0.30f, 12, 0.38f, -8, 0.50f, -8, 0.68f, 0, 1, 0))
		.roll(Track.smooth(0, 0, 0.55f, 0, 0.88f, 360, 1, 360))
		.build();

	public static final InspectAnimation STAFF_TWIRL = InspectAnimation.builder("Staff twirl", 56)
		.roll(Track.smooth(0, 0, 0.14f, 0, 0.78f, -720, 1, -720))
		.inward(Track.smooth(0, 0, 0.14f, 0, 0.30f, 0.08f, 0.62f, -0.08f, 0.78f, 0, 1, 0))
		.pitch(Track.smooth(0, 0, 0.14f, 0, 0.30f, 10, 0.78f, 10, 0.90f, 0, 1, 0))
		.build();

	// ---- Anything else -----------------------------------------------------------------
	public static final InspectAnimation TURNTABLE = InspectAnimation.builder("Turntable", 48)
		.yaw(Track.smooth(0, 0, 0.14f, 0, 0.86f, 360, 1, 360))
		.pitch(Track.smooth(0, 0, 0.14f, 0, 0.28f, -18, 0.74f, -18, 0.88f, 0, 1, 0))
		.up(Track.smooth(0, 0, 0.14f, 0, 0.50f, 0.05f, 0.86f, 0, 1, 0))
		.build();

	public static final InspectAnimation TOSS = InspectAnimation.builder("Toss", 44)
		.up(Track.smooth(0, 0, 0.20f, 0, 0.45f, 0.30f, 0.70f, 0, 1, 0))
		.pitch(Track.smooth(0, 0, 0.20f, 0, 0.70f, -360, 1, -360))
		.build();

	static {
		CATALOG.put(Category.SWORD, List.of(SWORD_TWIRL, SWORD_FLIP));
		CATALOG.put(Category.AXE, List.of(AXE_TOSS, AXE_CHOP));
		CATALOG.put(Category.TOOL, List.of(TOOL_TWIRL, AXE_TOSS));
		CATALOG.put(Category.MACE, List.of(MACE_SLAM, MACE_SPIN));
		CATALOG.put(Category.SPEAR, List.of(SPEAR_THRUST, STAFF_TWIRL));
		CATALOG.put(Category.GENERIC, List.of(TURNTABLE, TOSS));
	}

	private Animations() {}

	public static List<InspectAnimation> all() {
		return CATALOG.values().stream().flatMap(List::stream).distinct().toList();
	}

	public static InspectAnimation pick(Category category, Random random) {
		List<InspectAnimation> list = CATALOG.get(category);
		return list.get(random.nextInt(list.size()));
	}

	/** Category from an item's registry path, e.g. "iron_sword" or "mace". Works for modded items by name. */
	public static Category categoryOf(String path) {
		if (path.equals("mace")) return Category.MACE;
		if (path.endsWith("_sword")) return Category.SWORD;
		if (path.endsWith("_axe")) return Category.AXE;
		if (path.endsWith("_spear") || path.equals("spear") || path.equals("trident")) return Category.SPEAR;
		if (path.endsWith("_pickaxe") || path.endsWith("_shovel") || path.endsWith("_hoe")
			|| path.equals("shears") || path.equals("fishing_rod") || path.equals("brush")) {
			return Category.TOOL;
		}
		return Category.GENERIC;
	}
}
