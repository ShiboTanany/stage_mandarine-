package com.ntgclarity.mandarine.util;

import java.awt.Color;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import com.ntgclarity.mandarine.constants.CodesAndMessages;
import com.ntgclarity.mandarine.dto.StatusResponse;

@PropertySource(value = { "classpath:application.properties" })
public class Utils {

	@Value("resource.base.name")
	private String baseResource;

	private static Boolean integrationEnable;

	private static Integer integrationMode;

	public static Long userID;

	public static Long organizationId;

	public static final String fileSeparator = "/";

	public static final String backSlash = "\\";

	public static final String spcae = " ";

	public static final String dash = "-";

	public static Boolean isEmptyString(String str) {
		return str == null || str.equals("");
	}

	public static boolean isEmpty(Object obj) {
		return obj == null;
	}

	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(List obj) {
		return obj == null || obj.size() == 0;
	}

	public static List<Integer> convertFromStringToInt(String[] stringArray) {
		List<Integer> listOfInt = new ArrayList<>();
		try {
			if (!isEmpty(stringArray)) {
				for (int i = 0; i < stringArray.length; i++) {
					if (isNumeric(stringArray[i]))
						listOfInt.add(Integer.parseInt(stringArray[i]));
				}

			} else {
				return null;
			}
		} catch (Exception ex) {
			return null;
		}
		return listOfInt;
	}

	public static List<Long> convertFromStringToLong(String[] stringArray) {
		List<Long> listOfLong = new ArrayList<>();
		try {
			if (!isEmpty(stringArray)) {
				for (int i = 0; i < stringArray.length; i++) {
					if (isNumeric(stringArray[i].trim()))
						listOfLong.add(Long.valueOf(stringArray[i].trim()));
				}

			} else {
				return null;
			}
		} catch (Exception ex) {
			return null;
		}
		return listOfLong;
	}

	public static Integer getIntegerValue(String input) {
		try {
			if (!isEmpty(input) && isNumeric(input)) {
				return Integer.parseInt(input);

			} else {
				return null;
			}
		} catch (Exception ex) {
			return null;
		}
	}

	public static Integer calcNoOfYears(Date finishDate, Date startDate) {
		if (isEmpty(finishDate) || isEmpty(startDate))
			return null;
		Long diffInMillies = finishDate.getTime() - startDate.getTime();
		TimeUnit dayUnit = TimeUnit.DAYS;
		Long years = dayUnit.convert(diffInMillies, TimeUnit.MILLISECONDS) / 365;
		return years.intValue();
	}

	public static StatusResponse buildErrorMessage(StatusResponse response, Locale locale) {
		ResourceBundle resourceBundle = ResourceBundle.getBundle("locale.messages", locale);
		String message = resourceBundle.getString(response.getKey());
		response.setMessage(message);
		return response;
	}

	public static StatusResponse buildErrorMessage(StatusResponse response) {
		ResourceBundle resourceBundle = ResourceBundle.getBundle("locale.messages",
				RequestHeadersUtil.getLocaleFromHttpRequest());
		String message = resourceBundle.getString(response.getKey());
		response.setMessage(message);
		return response;
	}

	public static StatusResponse internalServerError(String message, Locale locale) {

		StatusResponse error = new StatusResponse(CodesAndMessages.INTERNAL_SERVER_ERROR_CODE,
				CodesAndMessages.INTERNAL_SERVER_ERROR_MESSAGE, message);
		return buildErrorMessage(error, locale);
	}

	public static StatusResponse internalServerError(String message) {

		StatusResponse error = new StatusResponse(CodesAndMessages.INTERNAL_SERVER_ERROR_CODE,
				CodesAndMessages.INTERNAL_SERVER_ERROR_MESSAGE, message);
		return buildErrorMessage(error);
	}

	public static String getOSName() {
		return System.getProperty("os.name");
	}

	public static Boolean isWindows() {
		return getOSName().startsWith("Windows");
	}

	public static Double round(Double number, int precision) {
		int prec = 10 * precision;
		return Math.floor(number * prec + .5) / prec;
	}

	public static String getFileSeparator() {
		return System.getProperty("file.separator");
	}

	public static double round(double Rval, int Rpl) {
		double p = Math.pow(10, Rpl);
		Rval = Rval * p;
		double tmp = Math.round(Rval);
		return tmp / p;
	}

	public static Boolean isStringContains(String text, String innerText) {
		return (text != null && (text.contains(innerText)));
	}

	public static String hex(byte[] array) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < array.length; ++i) {
			sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
		}
		return sb.toString();
	}

	public static String md5pwd(String message, String salt) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			String msg = new StringBuffer(message).append("{").append(salt).append("}").toString();
			return hex(md.digest(msg.getBytes("UTF-8")));
		} catch (NoSuchAlgorithmException e) {
		} catch (UnsupportedEncodingException e) {
		}
		return null;
	}

	public static String formatDateTime(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		return dateFormat.format(date);
	}

	public static String formatDate(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		return dateFormat.format(date);
	}

	public static String formatDate2(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		return dateFormat.format(date);
	}

	public static String formatDate3(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");
		return dateFormat.format(date);
	}

	public static String formatDate4(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(date);
	}

	public static Boolean validateReqularExpression(String reqExpression, String value) {
		Pattern pattern = Pattern.compile(reqExpression);
		Matcher fit = pattern.matcher(value);
		return fit.matches();
	}

	public static boolean isNumeric(String obj) {
		return obj.matches("(\\d+)");
	}

	public static boolean isIndexExist(List<?> list, int index) {
		try {
			return null != list.get(index);
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	public static String getFileExtention(String fileName) {
		String fileExt = "";
		Integer index = fileName.lastIndexOf(".");
		if (index > 0) {
			fileExt = fileName.substring(index + 1, fileName.length());
		}
		return fileExt;
	}

	public static List<Long> convertStringIdListToLongIdList(List<String> stringIdList) {
		List<Long> longIdList = new ArrayList<Long>();
		if (isNotEmpty(stringIdList)) {
			for (String id : stringIdList) {
				if (isNotEmpty(id)) {
					longIdList.add(Long.valueOf(id.trim()));
				}
			}
		}
		return longIdList;
	}

	public static Double getDecimalDegree(String degree) {
		try {
			Double decimal = -1D;
			if (isNotEmpty(degree)) {
				String[] degreeArr = degree.split("\\-");
				if (isNotEmpty(degreeArr) && degreeArr.length > 0) {
					decimal = Double.valueOf(degreeArr[0]);
					if (degreeArr.length > 1) {
						decimal += Double.valueOf(degreeArr[1]) / 60;
						if (degreeArr.length > 2) {
							decimal += Double.valueOf(degreeArr[2]) / 3600;
						}
					}
				}
			}
			return decimal;
		} catch (Exception e) {
			return -1D;
		}
	}

	public static String getDDMMSS(Double decimal) {
		String DDMMSS = "";
		if (isNotEmpty(DDMMSS)) {
			String[] DDMMSSArr = decimal.toString().split("\\.");
			if (isNotEmpty(DDMMSSArr) && DDMMSSArr.length > 0) {
				DDMMSS = DDMMSSArr[0];
				if (DDMMSSArr.length > 1) {
					double dd = Double.valueOf(DDMMSSArr[1]) / Math.pow(10, DDMMSSArr[1].length());
					decimal = dd * 60D;
					DDMMSSArr = decimal.toString().split("\\.");
					DDMMSS += "-";
					DDMMSS += DDMMSSArr[0];
					if (DDMMSSArr.length > 1) {
						double dd2 = Double.valueOf(DDMMSSArr[1]) / Math.pow(10, DDMMSSArr[1].length());
						decimal = dd2 * 60D;
						DDMMSS += "-";
						DDMMSS += Math.round(decimal);
					}
				}
			}
		}
		return DDMMSS;
	}

	/*
	 * :: lat1, lon1 = Latitude and Longitude of point 1 (in decimal degrees) :
	 */
	/*
	 * :: lat2, lon2 = Latitude and Longitude of point 2 (in decimal degrees) :
	 */
	/* :: unit = the unit you desire for results : */
	/* :: where: 'M' is statute miles : */
	/* :: 'K' is kilometers (default) : */
	/* :: 'N' is nautical miles : */
	public static double distance(Double lat1, Double lon1, Double lat2, Double lon2, char unit) {
		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
				+ Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		if (unit == 'K') {
			dist = dist * 1.609344;
		} else if (unit == 'N') {
			dist = dist * 0.8684;
		}
		return (dist);
	}

	/* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
	/* :: This function converts decimal degrees to radians : */
	/* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
	private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	/* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
	/* :: This function converts radians to decimal degrees : */
	/* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
	private static double rad2deg(double rad) {
		return (rad * 180.0 / Math.PI);
	}

	public static String enc(String S) {
		char[] Enc = { 'N', 'T', 'G' };
		if (S == null) {
			return "";
		}
		int j = 0;
		char[] C = S.toCharArray();
		for (int i = 0; i < C.length; i++) {
			C[i] ^= Enc[j];
			j++;
			if (j > 2) {
				j = 0;
			}
		}
		return String.valueOf(C);
	}

	@SuppressWarnings("deprecation")
	public static Long getDefaultViolatedTime() {
		return new Date(1990, 01, 01, 12, 00, 00).getTime();
	}

	@SuppressWarnings("rawtypes")
	public static boolean isNotEmpty(List obj) {
		return obj != null && obj.size() != 0;
	}

	public static boolean isNotEmpty(String obj) {
		return obj != null && obj.length() != 0;
	}

	public static boolean isNotEmpty(Object obj) {
		return obj != null;
	}

	public static boolean isNotEmpty(Long obj) {
		return obj != null && obj.toString().length() != 0;
	}

	public static boolean isNotEmpty(Object[] obj) {
		return obj != null && obj.length != 0;
	}

	// public static List<Long> getListAsIds(List list) {
	// List<Long> ids = new ArrayList<Long>();
	//
	// return ids;
	// }

	public static List<Long> convertStringToList(String ids) {
		List<Long> list = new ArrayList<Long>();
		if (isEmptyString(ids))
			return list;
		for (String id : ids.trim().split(","))
			list.add(Long.parseLong(id));
		return list;
	}

	public static List<String> convertStringToListString(String st) {
		List<String> list = new ArrayList<String>();
		if (isEmptyString(st))
			return list;
		for (String id : st.trim().split(","))
			list.add(id);
		return list;
	}

	public static List<Integer> convertStringToListIntegars(String ids) {
		List<Integer> list = new ArrayList<Integer>();
		if (isEmptyString(ids))
			return list;
		for (String id : ids.trim().split(","))
			list.add(Integer.parseInt(id));
		return list;
	}

	public String getForcolorAsRGB(Integer fgColor) {
		Color c = new Color(fgColor.intValue());
		String s = c.getRed() + "," + c.getGreen() + "," + c.getBlue();
		return s;
	}

	public String getBkcolorHEXSTR(Integer bgColor) {
		if (bgColor != null) {
			return "#" + Integer.toHexString(new Color(bgColor.intValue()).getRGB() & 0x00ffffff);
		} else {
			return null;
		}
	}

	/**
	 * Description: If it is true, the integration is enable; otherwise,
	 * integration is disable. Default value is true.
	 * 
	 * @param
	 * @return
	 */
	public static Boolean getIntegrationEnable() {
		return Utils.integrationEnable;
	}

	/**
	 * Description: Default value set is {null, 0, 1}. If it is null or 0, the
	 * it fetches data from local; If it is 1, integrating with ITTS. Default
	 * value is 0.
	 * 
	 * @param integrationMode
	 * @return
	 */
	public static Integer getIntegrationMode(Integer integrationMode) {
		if (Utils.isNotEmpty(integrationMode)) {
			return integrationMode;
		}
		return Utils.integrationMode;
	}

	/**
	 * Description : Get null property Name
	 * 
	 * @param source
	 * @return
	 */
	public static String[] getNullPropertyNames(Object source) {
		final BeanWrapper src = new BeanWrapperImpl(source);
		java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

		Set<String> emptyNames = new HashSet<String>();
		for (java.beans.PropertyDescriptor pd : pds) {
			Object srcValue = src.getPropertyValue(pd.getName());
			if (srcValue == null)
				emptyNames.add(pd.getName());
		}
		String[] result = new String[emptyNames.size()];
		return emptyNames.toArray(result);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static String passwordGenerator(int length, boolean includeSpecialChars) {
		SecureRandom srand = new SecureRandom();
		ArrayList validch = new ArrayList<>();
		for (int i = 65; i < 91; i++) {
			validch.add((char) i);// A-Z
			validch.add((char) (i + 32));// a-z
		}
		for (int i = 48; i < 58; i++) {
			validch.add((char) i);// 0-9
		}
		if (includeSpecialChars) {
			for (int i = 35; i < 39; i++) {
				validch.add((char) i);// *$%&
			}
			validch.add((char) 64);// @
		}
		Collections.shuffle(validch);
		StringBuilder sb = new StringBuilder("");
		for (int j = 0; j < length; j++) {
			sb.append((char) validch.get(srand.nextInt(validch.size())));
		}
		return sb.toString();
	}

	public static String generateSpecificPassword(String str, int strSubLength, int passwordTotalLength,
			boolean includeSpecialChars) {
		return ((!isEmptyString(str) && str.length() >= strSubLength)
				? str.substring(str.length() - strSubLength, str.length()) : "")
				+ Long.valueOf(new Date().getTime()).toString() + ((passwordTotalLength > strSubLength + 13)
						? passwordGenerator(passwordTotalLength - (strSubLength + 13), includeSpecialChars) : "");
	}

	public static String getStringListCommaSeparated(List<String> list) {
		if (Utils.isNotEmpty(list)) {
			return list.stream().map(x -> x).collect(Collectors.joining(","));
		}
		return "";
	}

}
