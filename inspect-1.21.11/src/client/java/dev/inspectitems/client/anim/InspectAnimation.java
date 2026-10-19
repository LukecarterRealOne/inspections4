package dev.inspectitems.client.anim;

/** A named inspect routine: shared raise/lower envelope plus per-axis keyframe tracks. */
public record InspectAnimation(String name, int ticks, Track inward, Track up, Track depth,
							   Track pitch, Track yaw, Track roll) {
	private static final float RAISE_INWARD = 0.30f;
	private static final float RAISE_UP = 0.26f;
	private static final float RAISE_DEPTH = 0.10f;

	public Frame sample(float t) {
		float e = envelope(t);
		return new Frame(
			RAISE_INWARD * e + inward.at(t),
			RAISE_UP * e + up.at(t),
			RAISE_DEPTH * e + depth.at(t),
			pitch.at(t), yaw.at(t), roll.at(t));
	}

	private static float envelope(float t) {
		return smoothstep(0f, 0.10f, t) * (1f - smoothstep(0.90f, 1f, t));
	}

	private static float smoothstep(float a, float b, float x) {
		float u = Math.max(0f, Math.min(1f, (x - a) / (b - a)));
		return u * u * (3f - 2f * u);
	}

	public static Builder builder(String name, int ticks) {
		return new Builder(name, ticks);
	}

	public static final class Builder {
		private final String name;
		private final int ticks;
		private Track inward = Track.ZERO, up = Track.ZERO, depth = Track.ZERO;
		private Track pitch = Track.ZERO, yaw = Track.ZERO, roll = Track.ZERO;

		private Builder(String name, int ticks) {
			this.name = name;
			this.ticks = ticks;
		}

		public Builder inward(Track t) { this.inward = t; return this; }
		public Builder up(Track t) { this.up = t; return this; }
		public Builder depth(Track t) { this.depth = t; return this; }
		public Builder pitch(Track t) { this.pitch = t; return this; }
		public Builder yaw(Track t) { this.yaw = t; return this; }
		public Builder roll(Track t) { this.roll = t; return this; }

		public InspectAnimation build() {
			return new InspectAnimation(name, ticks, inward, up, depth, pitch, yaw, roll);
		}
	}
}
