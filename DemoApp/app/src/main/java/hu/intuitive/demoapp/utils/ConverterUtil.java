package hu.intuitive.demoapp.utils;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.Arrays;

public class ConverterUtil
{

    public static short byteToShort(byte unsigned8)
    {
        return (short) (unsigned8 & 0xFF);
    }

    public static int shortToInt(short unsigned16)
    {
        return unsigned16 & 0xFFFF;
    }

    public static long intToLong(int unsigned32)
    {
        return unsigned32 & 0xFFFFFFFFL;
    }

    public static String toHex(int[] data)
    {
        StringBuffer sb = new StringBuffer();
        for(int i : data)
        {
            sb.append(ConverterUtil.toHexWith0x(i) + " ");
        }
        return sb.toString();
    }

    public static String toHexWithout0x(int decimal)
    {
        String hex = Integer.toHexString(decimal).toUpperCase();
        if(hex.length() % 2 != 0)
        {
            hex = "0" + hex;
        }
        return hex;
    }

    public static String toHexWith0x(int decimal)
    {
        return "0x" + toHexWithout0x(decimal);
    }

    public static Integer toDecimal(String hexaCode)
    {
        return Integer.parseInt(hexaCode.replaceAll("0x", ""), 16);
    }

    public static byte[] byteArrayConcat(byte[]... arrays)
    {
        int length = 0;
        for(byte[] act : arrays)
        {
            if(act != null)
            {
                length += act.length;
            }
        }
        int pos = 0;
        byte[] ret = new byte[length];
        for(byte[] act : arrays)
        {
            if(act != null)
            {
                System.arraycopy(act, 0, ret, pos, act.length);
            }
            pos += act.length;
        }
        return ret;
    }


    public static byte[] numberToHexArray(long value, int length) throws Exception
    { //bejön 65535 -> 0xFF 0xFF -> 255 255 -> java: [-1, -1]
        byte[] byteArray = new byte[length];
        if(length != 0)
        {
            for(int i = 0; i < byteArray.length; i++)
            {
                byteArray[i] = '0'; //48: ASCII of '0'
            }
            String strhex = Long.toHexString(value).toUpperCase();
            for(int i = strhex.length() - 1, k = byteArray.length - 1; i >= 0; i--, k--)
            {
                byteArray[k] = (byte) strhex.charAt(i);
            }
        }
        return byteArray;
    }


    public static byte[] stringToByteArray(String srcStringWithSeparators)
    {
        srcStringWithSeparators = srcStringWithSeparators.replaceAll("0x", "");
        srcStringWithSeparators = srcStringWithSeparators.replaceAll(",", "");
        String[] tags = srcStringWithSeparators.split(" ");
        byte[] array = new byte[tags.length];
        for(int i = 0; i < array.length; i++)
        {
            array[i] = (byte) Short.parseShort(tags[i], 16);
        }
        return array;
    }


    private static String byteToHexTag(byte b)
    {
        short sh = b;
        if(sh < 0)
        {
            sh += 256;
        }
        String actHex = Integer.toHexString(sh);
        if(actHex.length() == 1)
        {
            actHex = "0" + actHex;
        }
        actHex = "0x" + actHex + " ";
        return actHex;
    }


    public static String byteArrayToHexLog(byte[] byteArray)
    {
        String s = "";
        for(byte b : byteArray)
        {
            s += byteToHexTag(b);
        }
        return s;
    }


    public static String intArrayToHexLog(int[] array)
    {
        String s = "";
        for(int i : array)
        {
            s += byteToHexTag((byte) i);
        }
        return s;
    }


    public static String byteArrayToSerialNumber(byte[] byteArray)
    {
        String s = "";
        for(int i = 0; i < byteArray.length; i++)
        {
            short sh = byteArray[i];
            if(sh < 0)
            {
                sh += 256;
            }
            String actHex = Integer.toHexString(sh);
            if(actHex.length() == 1)
            {
                actHex = "0" + actHex;
            }
            s += actHex;
            if((i + 1) % 2 == 0 && i != byteArray.length - 1)
            {
                s += '-';
            }
        }
        return s;
    }

    public static String byteArrayToRawLog(byte[] byteArray)
    {
        String s = "";
        for(byte b : byteArray)
        {
            s += byteToHexTag(b);
        }
        return s;
    }

    public static String byteArrayToNumberString(byte[] bytes)
    {
        if(bytes == null)
        {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < bytes.length; i++)
        {
            short sh = bytes[i];
            if(sh < 0)
            {
                sh += 256;
            }
            sb.append(String.format("%4d", sh) + " ");
        }
        return sb.toString();
    }


    public static String byteArrayToCharString(byte[] bytes)
    {
        if(bytes == null)
        {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < bytes.length; i++)
        {
            short sh = bytes[i];
            if(sh < 0)
            {
                sh += 256;
            }
            sb.append((char) (sh));
        }
        return sb.toString();
    }

    public static long byteArrayToNumber(byte[] byteArray, boolean littleEndian)
    {
        long value = 0L;
        if(littleEndian)
        {
            for(int i = 0; i < byteArray.length; i++)
            {
                Short sh = (short) byteArray[i];
                if(sh < 0)
                {
                    sh = (short) (sh + 256);
                }

                value += sh * Math.pow(256, (i));
            }
        }
        else
        {
            for(int i = 0; i < byteArray.length; i++)
            {
                Short sh = (short) byteArray[i];
                if(sh < 0)
                {
                    sh = (short) (sh + 256);
                }

                value += sh * Math.pow(256, (byteArray.length - i - 1));
            }
        }
        return value;
    }


    public static String simulatorByteArrayToReadable(byte[] byteArray)
    {
        String s = byteArrayToNumberString(byteArray);
        while(s.contains("  "))
        {
            s = s.replace("  ", " ");
        }
        s = s.trim();
        String[] a = s.split(" ");
        StringBuffer sb = new StringBuffer();
        StringBuffer sbDec = new StringBuffer("READABLE DECIMAL:\n");
        for(int i = 0; i < a.length; i++)
        {
            if(i == 8 - 1 || i == 16 - 1 || i == 24 - 1 || i == 32 - 1 || i == 36 - 1 || i == 44 - 1 || i == 46 - 1 || i == byteArray.length - 4 - 1)
            {
                sb.append(String.format("%4s", a[i]) + "|");
            }
            else
            {
                sb.append(String.format("%4s", a[i]) + " ");
            }
            if((i > 16 - 1 && i <= 46 - 1) || i >= byteArray.length - 4)
            {
                try
                {
                    sbDec.append(String.format("%4d", (int) hexAsciiCharToNumber(Short.parseShort(a[i]))) + " ");
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
            else
            {
                sbDec.append(String.format("%4s", "_") + " ");
            }
        }
        sb.append("\n");
        sb.append(sbDec);
        return sb.toString();
    }


    public static short hexAsciiCharToNumber(short sh)
    {
        if(Character.isDigit(sh))
        {
            return (short) (sh - '0');
        }
        else
        {
            char c = (char) sh;
            c = Character.toLowerCase(c);
            if('a' <= c && c <= 'f')
            {
                return (short) (c - 'a' + 10); //a = 10, b =  11, f = 15
            }
        }
        return 0;
    }

    public static String chopString(Object src)
    {
        if(src == null)
        {
            return "";
        }
        String s = new String(src.toString());
        if(s.length() > 1000)
        {
            s = s.substring(0, 1000) + " [ MORE... ]";
        }
        return s;
    }

    public static byte[] getHash(byte[] src)
    {
        byte byteData[] = null;
        try
        {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(src);
            byteData = md.digest();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return byteData;
    }

    public static byte[] getByteArrayFromHashString(String strMd5) throws Exception
    { //248b646537648c1fbdeb42b56771dbdb42129e8bab527ff551a1f49ce499464f -> [ ];
        if(strMd5.length() % 2 != 0)
        {
            throw new Exception("Hiba: paratlan hosszu md5!");
        }

        byte ret[] = new byte[strMd5.length() / 2];
        try
        {
            for(int i = 0; i < strMd5.length(); i = i + 2)
            {
                String tag = strMd5.charAt(i) + "" + strMd5.charAt(i + 1);
                Short sh = Short.valueOf(tag, 16);
                ret[i / 2] = sh.byteValue();
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return ret; //pw: [36, -117, 100, 101, 55, 100, -116, 31, -67, -21, 66, -75, 103, 113, -37, -37, 66, 18, -98, -117, -85, 82, 127, -11, 81, -95, -12, -100, -28, -103, 70, 79]
    }

    public static byte[] xor(byte[] array1, byte[] array2)
    {
        byte[] ret = new byte[4];
        for(int i = 0; i < 4; i++)
        {
            ret[i] = (byte) (array1[i] ^ array2[i]);
        }
        return ret;
    }

    private static byte[] byteArrayReverse(byte[] b)
    {
        byte[] ret = new byte[b.length];
        for(int i = 0; i < b.length; i++)
        {
            ret[i] = b[b.length - i - 1];
        }
        return ret;
    }

    public static byte[] calcAES128_key(byte[] sSalt, byte[] pwHash, byte[] cSalt, byte[] sessionID) throws Exception
    { //key  = Trunc128bit(hash(s)) ; s = (ssalt, PasswdHash, csalt, session-id)
        byte[] ret = byteArrayConcat((sSalt), pwHash, (cSalt), (sessionID));
        ret = getHash(ret);
        ret = Arrays.copyOfRange(ret, 0, 16);
        return ret;
    }

    public static int trueByte(byte b)
    {
        int ret = b;
        if(ret < 0)
        {
            ret = ret + 256;
        }
        return ret;
    }

    public static byte[] numberToDword(Long number) throws Exception
    {
        byte[] ret = new byte[4];
        int divider = 256 * 256 * 256;

        for(int i = 0; i < ret.length; i++)
        {
            ret[i] = (byte) (number / divider);
            number = number % divider;
            divider /= 256;
        }
        ret = byteArrayReverse(ret);
        return ret;
    }

    public static long dwordToNumber(byte[] dword) throws Exception
    {
        return byteArrayToNumber(dword, true);
    }

    public static byte[] byteArrayDwordNextValue(byte[] value) throws Exception
    {
        byte[] ret = new byte[4];
        long act = dwordToNumber(value);
        if(act == 0xffffffff)
        {
            act = 0;
        }
        else
        {
            act++;
        }
        ret = numberToDword(act);
        return ret;
    }

    public static byte[] readOneWanString(ByteBuffer bf)
    {
        byte[] ret = null;
        int wanStringLength = bf.get();
        if(wanStringLength > 0)
        {
            byte[] array = new byte[wanStringLength];

            for(int i = 0; i < array.length; i++)
            {
                array[i] = bf.get();
            }
            ret = array;
        }
        else
        {
            ret = new byte[0];
        }
        return ret;
    }

    public static byte[] readOneWanStringWithLength(ByteBuffer bf)
    {
        byte[] ret = null;
        int wanStringLength = bf.get();
        if(wanStringLength > 0)
        {
            byte[] array = new byte[wanStringLength + 1];
            array[0] = (byte) wanStringLength;
            for(int i = 1; i < array.length; i++)
            {
                array[i] = bf.get();
            }
            ret = array;
        }
        else
        {
            ret = new byte[0];
        }
        return ret;
    }

    public static String wanStringPairsToString(long count, byte[] pairs) throws Exception
    {
        String ret = "";
        int safe = 0;
        ByteBuffer bf = ByteBuffer.wrap(pairs);
        for(int i = 0; i < count; i++)
        {
            safe++;
            if(safe > 20000)
            {
                break;
            }

            byte[] actId = readOneWanString(bf);
            byte[] actValue = readOneWanString(bf);

            ret += byteArrayToCharString(actId) + "=" + byteArrayToCharString(actValue) + ";";
        }

        return ret;
    }

    public static byte[] byteArrayXor0xffffffff(byte[] b)
    {
        for(int i = 0; i < b.length; i++)
        {
            b[i] = (byte) (b[i] ^ 0xff);
        }
        return b;
    }


    public static int abs(byte b)
    {
        if(b >= 0)
        {
            return b;
        }
        return 256 + b;
    }

    public static byte[] getBytesFromReadableHexString(String scannerResponseString)
    {
        try
        {
            byte[] ret = new byte[scannerResponseString.length() / 2];
            for(int i = 0; i < scannerResponseString.length(); i = i + 2)
            {
                String twoNumber = scannerResponseString.charAt(i) + "" + scannerResponseString.charAt(i + 1);
                Integer decimal = toDecimal(twoNumber);
                ret[i / 2] = decimal.byteValue();
            }
            return ret;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return new byte[0];
        }

    }

    public static String majorOrMinorToTwoByteUrString(Integer majorOrMinor)
    {
        try
        {
            String ret = ConverterUtil.toHexWithout0x(majorOrMinor);
            if(ret.length() == 2)
            {
                ret = "00" + ret;
            }
            return ret;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public static String toDisplayAsciiPayload(String decodedDisplayMessage)
    {
        if(decodedDisplayMessage == null)
        {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < decodedDisplayMessage.length(); i++)
        {
            char c = decodedDisplayMessage.charAt(i);
            sb.append(toHexWithout0x(c));
        }
        return sb.toString();
    }

    public static String toDisplayUtf8Payload(String decodedDisplayMessage)
    {
        if(decodedDisplayMessage == null)
        {
            return "";
        }

        try
        {
            StringBuffer sb = new StringBuffer();
            byte[] ba = decodedDisplayMessage.getBytes("UTF-8");
            for(byte b : ba)
            {
                int i = b;
                if(i < 0)
                {
                    i = i + 256;
                }
                sb.append(toHexWithout0x(i));
            }
            return sb.toString();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return "";
        }
    }
}
