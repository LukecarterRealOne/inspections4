package dev.inspectitems.client.anim;

/**
 * One sampled pose of the held item, relative to its normal first-person resting spot.
 * inward: toward screen center, up: screen up, depth: toward the camera (negative = away),
 * pitch/yaw/roll: degrees, applied about the grip.
 */
public record Frame(float inward, float up, float depth, float pitch, float yaw, float roll) {
	public static final Frame REST = new Frame(0f, 0f, 0f, 0f, 0f, 0f);
}
