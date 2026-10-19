package dev.inspectitems.client;

import dev.inspectitems.client.anim.Animations;
import dev.inspectitems.client.anim.Frame;
import dev.inspectitems.client.anim.InspectAnimation;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.Random;

/** Holds the state of the current inspection and drives it from client ticks. */
public final class InspectController {
	private static final Random RANDOM = new Random();

	private static boolean active;
	private static int ticks;
	private static int totalTicks = 1;
	private static InspectAnimation animation;
	private static ItemStack startStack = ItemStack.EMPTY;

	private InspectController() {}

	public static boolean isActive() {
		return active;
	}

	public static void onClientTick(Minecraft mc) {
		boolean pressed = false;
		while (InspectItemsClient.inspectKey.consumeClick()) {
			pressed = true;
		}
		if (active) {
			advance(mc);
		} else if (pressed) {
			start(mc);
		}
	}

	private static void start(Minecraft mc) {
		LocalPlayer player = mc.player;
		if (player == null || mc.screen != null || player.isUsingItem()) {
			return;
		}
		ItemStack stack = player.getMainHandItem();
		if (stack.isEmpty() || stack.is(Items.FILLED_MAP)) {
			return;
		}
		String path = BuiltInRegistries.ITEM.getKey(stack.getItem()).getPath();
		animation = Animations.pick(Animations.categoryOf(path), RANDOM);
		float speed = Math.max(0.25f, InspectConfig.get().animationSpeed);
		totalTicks = Math.max(1, Math.round(animation.ticks() / speed));
		ticks = 0;
		startStack = stack.copy();
		active = true;
	}

	private static void advance(Minecraft mc) {
		LocalPlayer player = mc.player;
		if (player == null || mc.screen != null || player.isUsingItem()
			|| mc.options.keyAttack.isDown() || mc.options.keyUse.isDown()
			|| !ItemStack.isSameItemSameComponents(player.getMainHandItem(), startStack)) {
			stop();
			return;
		}
		if (++ticks >= totalTicks) {
			stop();
		}
	}

	public static void stop() {
		active = false;
		animation = null;
		startStack = ItemStack.EMPTY;
	}

	public static Frame frame(float partialTick) {
		if (!active || animation == null) {
			return Frame.REST;
		}
		float t = Mth.clamp((ticks + partialTick) / totalTicks, 0f, 1f);
		return animation.sample(t);
	}
}
