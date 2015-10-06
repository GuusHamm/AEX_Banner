package aexbanner;

import java.util.Timer;
import java.util.TimerTask;

public class BannerController {

	private AEXBanner banner;
	private MockEffectenbeurs effectenbeurs;
	private Timer pollingTimer;

	public BannerController(AEXBanner banner) {

		this.banner = banner;
		this.effectenbeurs = new MockEffectenbeurs();

		// Start polling timer: update banner every two seconds
		pollingTimer = new Timer();
		pollingTimer.schedule(new TimerTask() {
			@Override
			public void run() {
				banner.setKoersen(effectenbeurs.toString());
			}
		}, 16);
	}

	// Stop banner controller
	public void stop() {
		pollingTimer.cancel();
		// Stop simulation timer of effectenbeurs
	}
}
