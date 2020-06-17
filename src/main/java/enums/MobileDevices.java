package enums;

/**
 * @author shushKostumian
 */

public enum MobileDevices {
	
	GALAXY_S5("Galaxy S5"),
	PIXEL_2("Pixel 2"),
	PIXEL_2_XL("Pixel 2 XL"),
	IPHONE_5_SE("iPhone 5/SE"),
	IPHONE_6_7_8("iPhone 6/7/8 Plus"),
	IPHONE_6_7_8_PLUS("iPhone 6/7/8 Plus"),
	IPHONE_X("iPhone X"),
	IPAD("iPad"),
	IPAD_PRO("iPad Pro");
	
	//
	private final String device;

	public String getMobileDevice() {
		return device;
	}

	private MobileDevices(String device) {
		this.device = device;
	}

}
