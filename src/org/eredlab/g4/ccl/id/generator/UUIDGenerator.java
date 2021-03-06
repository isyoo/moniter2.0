package org.eredlab.g4.ccl.id.generator;

import org.apache.log4j.Logger;
import org.eredlab.g4.ccl.id.CreateIDException;

/**
 * UUIDGenerator
 * 此代码源于开源项目E3,原作者：黄云辉
 * 
 * @author XiongChun
 * @since 2010-03-17
 * @see AbstractUUIDGenerator
 */
public class UUIDGenerator extends AbstractUUIDGenerator {
   private static Logger logger = Logger.getLogger(UUIDGenerator.class);
	private String sep = "";
	public UUIDGenerator() {

	}

	public UUIDGenerator(String pSep) {
		this.sep = pSep;
	}

	protected String format(int intval) {
		String formatted = Integer.toHexString(intval);
		StringBuffer buf = new StringBuffer("00000000");
		buf.replace(8 - formatted.length(), 8, formatted);
		return buf.toString();
	}

	protected String format(short shortval) {
		String formatted = Integer.toHexString(shortval);
		StringBuffer buf = new StringBuffer("0000");
		buf.replace(4 - formatted.length(), 4, formatted);
		return buf.toString();
	}

	public String create() throws CreateIDException {
		StringBuffer sb = new StringBuffer(36);
		sb.append(format(getIP())).append(sep).append(format(getJVM())).append(
				sep).append(format(getHiTime())).append(sep).append(
				format(getLoTime())).append(sep).append(format(getCount()));
		return sb.toString();

	}

	public static void main(String[] args) throws Exception {
		UUIDGenerator a = new UUIDGenerator();
		logger.info(a.create().length());
//		System.out.println(a.create().length());
	}

}
