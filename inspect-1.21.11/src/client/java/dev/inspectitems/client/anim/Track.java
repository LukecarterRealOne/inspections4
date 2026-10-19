package dev.inspectitems.client.anim;

/** A value over normalized time (0..1) defined by keyframes. Pure Java, no Minecraft types. */
public final class Track {
	public static final Track ZERO = new Track(new float[] {0f, 1f}, new float[] {0f, 0f}, false);

	private final float[] times;
	private final float[] values;
	private final boolean smooth;

	private Track(float[] times, float[] values, boolean smooth) {
		this.times = times;
		this.values = values;
		this.smooth = smooth;
	}

	/** Keys are time,value pairs. Eases in and out of every key (pauses at each one). */
	public static Track smooth(float... keys) {
		return of(keys, true);
	}

	/** Keys are time,value pairs. Straight lines between keys. */
	public static Track linear(float... keys) {
		return of(keys, false);
	}

	private static Track of(float[] keys, boolean smooth) {
		if (keys.length < 4 || keys.length % 2 != 0) {
			throw new IllegalArgumentException("Track needs at least two time,value pairs");
		}
		int n = keys.length / 2;
		float[] t = new float[n];
		float[] v = new float[n];
		for (int i = 0; i < n; i++) {
			t[i] = keys[i * 2];
			v[i] = keys[i * 2 + 1];
			if (i > 0 && t[i] < t[i - 1]) {
				throw new IllegalArgumentException("Track times must not decrease");
			}
		}
		return new Track(t, v, smooth);
	}

	public float at(float time) {
		int last = times.length - 1;
		if (time <= times[0]) {
			return values[0];
		}
		if (time >= times[last]) {
			return values[last];
		}
		for (int i = 1; i <= last; i++) {
			if (time <= times[i]) {
				float span = times[i] - times[i - 1];
				float u = span <= 0f ? 1f : (time - times[i - 1]) / span;
				if (smooth) {
					u = u * u * (3f - 2f * u);
				}
				return values[i - 1] + (values[i] - values[i - 1]) * u;
			}
		}
		return values[last];
	}
}
