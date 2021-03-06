package com.xl.kffta.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.xl.kffta.base.App;

import org.apache.commons.lang3.StringUtils;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import androidx.annotation.ColorRes;
import androidx.core.content.ContextCompat;

import static java.util.regex.Pattern.compile;

public class SysUtils {

    /**
     * 将dp转换为px
     *
     * @param dp
     * @return
     */
    public static int convertDpToPixel(Context context, float dp) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return (int) (metrics.density * dp + 0.5f);
    }

    public static int convertDpToPixel(float dp) {
        DisplayMetrics metrics = App.instance.getResources().getDisplayMetrics();
        return (int) (metrics.density * dp + 0.5f);
    }

    public static int convertSpToPixel(Context context, float sp) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return (int) (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                sp, metrics));
    }

    /**
     * 将字符串转换成算术式并进行计算
     *
     * @param str 算术
     * @return 结果
     */
    public static double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') {
                    nextChar();
                }
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) {
                    throw new RuntimeException("Unexpected: " + (char) ch);
                }
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            //        | number | functionName factor | factor `^` factor

            double parseExpression() {
                double x = parseTerm();
                for (; ; ) {
                    if (eat('+')) {
                        // addition
                        x += parseTerm();
                    } else if (eat('-')) {
                        // subtraction
                        x -= parseTerm();
                    } else {
                        return x;
                    }
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (; ; ) {
                    if (eat('*')) {
                        // multiplication
                        x *= parseFactor();
                    } else if (eat('/')) {
                        // division
                        x /= parseFactor();
                    } else {
                        return x;
                    }
                }
            }

            double parseFactor() {
                if (eat('+')) {
                    // unary plus
                    return parseFactor();
                }
                if (eat('-')) {
                    // unary minus
                    return -parseFactor();
                }

                double x;
                int startPos = this.pos;
                if (eat('(')) {
                    // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') {
                    // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') {
                        nextChar();
                    }
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') {
                    // functions
                    while (ch >= 'a' && ch <= 'z') {
                        nextChar();
                    }
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) {
                        x = Math.sqrt(x);
                    } else if (func.equals("sin")) {
                        x = Math.sin(Math.toRadians(x));
                    } else if (func.equals("cos")) {
                        x = Math.cos(Math.toRadians(x));
                    } else if (func.equals("tan")) {
                        x = Math.tan(Math.toRadians(x));
                    } else {
                        throw new RuntimeException("Unknown function: " + func);
                    }
                } else {
                    throw new RuntimeException("Unexpected: " + (char) ch);
                }

                if (eat('^')) {
                    // exponentiation
                    x = Math.pow(x, parseFactor());
                }
                return x;
            }
        }.parse();
    }

    /**
     * 字符转化为浮点数
     */
    public static float parseFloat(String nStr) {
        float n;
        try {
            n = Float.parseFloat(nStr);
        } catch (Exception e) {
            n = 0.0f;
        }
        return n;
    }

    /**
     * 字符转化为数字(正整数)
     */
    public static int parseInt(String nStr) {
        int n;
        try {
            n = Integer.parseInt(nStr);
        } catch (Exception e) {
            n = -1;
        }
        return n;
    }

    /**
     * 字符转化为数字(正整数)
     */
    public static long parseLong(String nStr) {
        long n;
        try {
            n = Long.parseLong(nStr);
        } catch (Exception e) {
            n = -1;
        }
        return n;
    }

    /**
     * 字符转化为浮点数
     */
    public static double parseDouble(String nStr) {
        double n;
        try {
            n = Double.parseDouble(nStr);
        } catch (Exception e) {
            n = 0.0f;
        }
        return n;
    }

    public static boolean isEmpty(String string) {
        if (string == null || string.length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static int getColor(@ColorRes int resId) {
        return ContextCompat.getColor(App.getContext(), resId);
    }

    /**
     * 获取不为空的字符串
     *
     * @param string
     * @return string
     */
    public static String getSafeString(String string) {
        if (!isEmpty(string)) {
            return string;
        } else {
            return "";
        }
    }

    /**
     * 判断String是不是为纯字母数字
     */
    public static boolean IsNumLetter(String letter) {
        if (letter == null || letter.length() <= 0) {
            return false;
        }
        for (int i = 0; i < letter.length(); i++) {
            char c = letter.charAt(i);
            if (!(c >= 'a' && c <= 'z') && !(c >= 'A' && c <= 'Z') && !(c >= '0' && c <= '9')) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断String是不是为纯数字
     */
    public static boolean IsNumber(String nNum) {
        if (nNum == null || nNum.length() <= 0) {
            return false;
        }
        for (int i = 0; i < nNum.length(); i++) {
            char c = nNum.charAt(i);
            if (!(c >= '0' && c <= '9')) {
                return false;
            }
        }
        return true;
    }

    /**
     * 获取屏幕宽度
     *
     * @param context context
     * @return int
     */
    public static int getScreenWidth(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        return dm.widthPixels;
    }

    /**
     * 获取屏幕高度
     *
     * @param context context
     * @return int
     */
    public static int getScreenHeight(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        return dm.heightPixels;
    }

    /**
     * 针对全面屏的屏幕高度
     *
     * @param activity activity
     * @return int
     */
    public static int getScreenRealHeight(Activity activity) {
        DisplayMetrics dm = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            activity.getWindowManager().getDefaultDisplay().getRealMetrics(dm);
        } else {
            activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        }
        return dm.heightPixels;
    }

    /**
     * 获取状态栏的高度
     *
     * @param context context
     * @return int
     */
    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    public static String getDateTimestamp(String date) {
        if (TextUtils.isEmpty(date)) {
            return "";
        }
        String time = date.replaceAll("/", "");
        time = time.replace("(", "");
        time = time.replace(")", "");
        time = time.replace("Date", "");
        long timestamp = SysUtils.parseLong(time);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        Date sdDate = new Date(timestamp);
        return simpleDateFormat.format(sdDate);
    }

    /**
     * 时间戳转换为时间
     *
     * @param millionSecond
     * @return
     */
    public static String getFormatTime(long millionSecond) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        Date sdDate = new Date(millionSecond);
        return simpleDateFormat.format(sdDate);
    }

    /*
     * 将时间转换为时间戳
     */
    public static String dateToStamp(String s) {
        if (TextUtils.isEmpty(s)) {
            return "";
        }
        try {
            String res;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date date = simpleDateFormat.parse(s);
            long ts = date.getTime();
            res = String.valueOf(ts);
            return res;
        } catch (Exception exception) {
            return "";
        }
    }

    public static void showDatePickerDialog(Context activity, final TextView tv, Calendar calendar) {
        // 直接创建一个DatePickerDialog对话框实例，并将它显示出来
        new DatePickerDialog(activity, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int yearPick, int monthOfYear, int dayOfMonth) {
                // 此处得到选择的时间，可以进行你想要的操作

                // 选完了年月日，就搞个时间弹窗
                new TimePickerDialog(activity, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minutePicker) {
                        // 给文本赋值
                        tv.setText(String.format("%04d", yearPick) + "-" +
                                String.format("%02d", monthOfYear + 1) + "-" +
                                String.format("%02d", dayOfMonth) + " " +
                                String.format("%02d", hourOfDay) + ":" +
                                String.format("%02d", minutePicker));
                    }
                }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true).show();
            }

        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();

    }

    /**
     * 校验手机号码
     */
    public static boolean validateMobilePhone(String in) {
        return compile("^[1]\\d{10}$").matcher(in).matches();
    }

    public static Activity getActivity(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }

            context = ((ContextWrapper) context).getBaseContext();
        }

        return null;
    }

    private static Intent getAppOpenIntentByPackageName(Context context, String packageName) {
        //Activity完整名
        String mainAct = null;
        //根据包名寻找
        PackageManager pkgMag = context.getPackageManager();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        intent.setFlags(Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED | Intent.FLAG_ACTIVITY_NEW_TASK);

        @SuppressLint("WrongConstant") List<ResolveInfo> list = pkgMag.queryIntentActivities(intent, PackageManager.GET_ACTIVITIES);
        for (int i = 0; i < list.size(); i++) {
            ResolveInfo info = list.get(i);
            if (info.activityInfo.packageName.equals(packageName)) {
                mainAct = info.activityInfo.name;
                break;
            }
        }
        if (TextUtils.isEmpty(mainAct)) {
            return null;
        }
        intent.setComponent(new ComponentName(packageName, mainAct));
        return intent;
    }

    private static Context getPackageContext(Context context, String packageName) {
        Context pkgContext = null;
        if (context.getPackageName().equals(packageName)) {
            pkgContext = context;
        } else {
            // 创建第三方应用的上下文环境
            try {
                pkgContext = context.createPackageContext(packageName,
                        Context.CONTEXT_IGNORE_SECURITY
                                | Context.CONTEXT_INCLUDE_CODE);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        return pkgContext;
    }

    private static boolean openPackage(Context context, String packageName) {
        Context pkgContext = getPackageContext(context, packageName);
        Intent intent = getAppOpenIntentByPackageName(context, packageName);
        if (pkgContext != null && intent != null) {
            pkgContext.startActivity(intent);
            return true;
        }
        return false;
    }

    /**
     * 检查包是否存在
     *
     * @param packname
     * @return
     */
    private static boolean checkPackInfo(Context context, String packname) {
        PackageInfo packageInfo = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(packname, 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return packageInfo != null;
    }

    /**
     * 通过包名 在应用商店打开应用
     *
     * @param context     上下文
     * @param packageName 包名 com.cmcc.android.ysx
     * @param url         下载App的官方链接 https://download.125339.com.cn
     */
    private static void openApplicationMarket(Context context, String packageName, String url) {
        try {
            String str = "market://details?id=" + packageName;
            Intent localIntent = new Intent(Intent.ACTION_VIEW);
            localIntent.setData(Uri.parse(str));
            context.startActivity(localIntent);
        } catch (Exception e) {
            e.printStackTrace();
            // 调用系统浏览器进行下载
            Toast.makeText(context, "打开应用商店失败", Toast.LENGTH_SHORT).show();
            openLinkBySystem(context, url);
        }
    }

    /**
     * 调用系统浏览器打开网页或下载链接
     *
     * @param url 地址
     */

    private static void openLinkBySystem(Context context, String url) {
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        context.startActivity(intent);
    }

    public static void openYsxApp(Context context, String packname) {
        if (checkPackInfo(context, packname)) {
            openPackage(context, packname);
        } else {
            DialogUtil.INSTANCE.showCommonDialog(context, "您还未安装移动云视讯，是否前往商店下载", new DialogUtil.OnDialogOkClick() {
                @Override
                public void onDialogOkClick() {
                    openApplicationMarket(context, "com.cmcc.android.ysx", "https://download.125339.com.cn");
                }
            });
        }
    }

    public static byte[] readStream(String imagepath) throws Exception {
        FileInputStream fs = new FileInputStream(imagepath);
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while (-1 != (len = fs.read(buffer))) {
            outStream.write(buffer, 0, len);
        }
        outStream.close();
        fs.close();
        return outStream.toByteArray();
    }

    // 二进制转字符串
    public static String byte2hex(byte[] b) {
        StringBuffer sb = new StringBuffer();
        String tmp = "";
        for (int i = 0; i < b.length; i++) {
            tmp = Integer.toHexString(b[i] & 0XFF);
            if (tmp.length() == 1) {
                sb.append("0" + tmp);
            } else {
                sb.append(tmp);
            }

        }
        return sb.toString();
    }

    /**
     * 通过服务器返回的files字段，抽取出文件的真正提交路径
     *
     * @param filePath 原始文件字段
     */
    public static String getTrueFilePath(String filePath) {
        if (TextUtils.isEmpty(filePath)) {
            return "";
        }
        String[] fileInfos = filePath.split("\\|");
        if (fileInfos.length < 3) {
            return "";
        }
        try {
            String[] trueStrings = new String[3];
            System.arraycopy(fileInfos, 0, trueStrings, 0, 3);
            return StringUtils.join(trueStrings, "|");
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 如果有附件添加，弄个0的标志位在前面
     */
    public static String getAppendAddFilePath(String filePath) {
        if (TextUtils.isEmpty(filePath)) {
            return "";
        }
        String[] fileInfos = filePath.split("\\|");
        if (fileInfos.length < 3) {
            return "";
        }
        try {
            if (fileInfos.length == 3) {
                // 如果没有多余部分，直接加个0就行了
                if (filePath.endsWith("|")) {
                    return filePath + "0";
                }
                return filePath + "|0";
            } else {
                if (!TextUtils.isEmpty(fileInfos[3])) {
                    // 本身里面就有内容的，要在最后一个前面加0
                    String end = "0&" + fileInfos[3];
                    String[] headStrings = new String[4];
                    // 把前三个抠出来
                    System.arraycopy(fileInfos, 0, headStrings, 0, 3);
                    headStrings[3] = end;
                    return StringUtils.join(headStrings, "|");
                }
                if (filePath.endsWith("|")) {
                    return filePath + "0";
                }
                return filePath + "|0";
            }
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 通过filepath获取对应的id
     */
    public static ArrayList<Long> getFileIds(String filePath) {
        ArrayList<Long> ids = new ArrayList<>();
        if (!TextUtils.isEmpty(filePath)) {
            String[] fileInfos = filePath.split("\\|");
            if (fileInfos.length >= 4 && !TextUtils.isEmpty(fileInfos[3])) {
                String[] idStrs = fileInfos[3].split("&");
                if (idStrs != null && idStrs.length > 0) {
                    for (String str : idStrs) {
                        ids.add(SysUtils.parseLong(str));
                    }
                    return ids;
                }
            }
        }

        return ids;
    }

    /**
     * 把Base64字符串转换成bitmap
     */
    public static Bitmap base64ToBitmap(String base64String) {
        byte[] decode = Base64.decode(base64String, Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(decode, 0, decode.length);
        return bitmap;
    }
}
