/*
 * Simple interface from Google to add event tracking to admob.
 */

package com.sajarvis.paint;

import com.google.ads.Ad;
import com.google.ads.AdRequest;
import com.sajarvis.fingerpaint.R;

public interface AdListener {
	public void onReceiveAd(Ad ad);
	public void onFailedToReceiveAd(Ad ad, AdRequest.ErrorCode error);
	public void onPresentScreen(Ad ad);
	public void onDismissScreen(Ad ad);
	public void onLeaveApplication(Ad ad);
}
